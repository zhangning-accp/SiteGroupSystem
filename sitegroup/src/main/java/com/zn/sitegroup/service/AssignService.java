package com.zn.sitegroup.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zn.sitegroup.ApplicationConfig;
import com.zn.sitegroup.dto.AssginDto;
import com.zn.sitegroup.dto.CategoryDto;
import com.zn.sitegroup.entity.DcAssginEntity;
import com.zn.sitegroup.entity.DcRulesEntity;
import com.zn.sitegroup.entity.LcCategoriesEntity;
import com.zn.sitegroup.entity.LcCategoriesInfoEntity;
import com.zn.sitegroup.entity.LcOptionGroupsEntity;
import com.zn.sitegroup.entity.LcOptionGroupsInfoEntity;
import com.zn.sitegroup.entity.LcOptionValuesEntity;
import com.zn.sitegroup.entity.LcOptionValuesInfoEntity;
import com.zn.sitegroup.entity.LcProductGroupsEntity;
import com.zn.sitegroup.entity.LcProductGroupsInfoEntity;
import com.zn.sitegroup.entity.LcProductGroupsValuesEntity;
import com.zn.sitegroup.entity.LcProductGroupsValuesInfoEntity;
import com.zn.sitegroup.entity.LcProductOptionTreesEntity;
import com.zn.sitegroup.entity.LcProductsCampaignsEntity;
import com.zn.sitegroup.entity.LcProductsEntity;
import com.zn.sitegroup.entity.LcProductsImagesEntity;
import com.zn.sitegroup.entity.LcProductsInfoEntity;
import com.zn.sitegroup.entity.LcProductsOptionsEntity;
import com.zn.sitegroup.entity.LcProductsOptionsStockEntity;
import com.zn.sitegroup.entity.LcProductsPricesEntity;
import com.zn.sitegroup.entity.LcProductsToCategoriesEntity;
import com.zn.sitegroup.jsonbean.CategoryJsonBean;
import com.zn.sitegroup.jsonbean.ProductGroupJsonBean;
import com.zn.sitegroup.repository.IAssginRepository;
import com.zn.sitegroup.repository.ICategoryInfoRepository;
import com.zn.sitegroup.repository.ICategoryRepository;
import com.zn.sitegroup.repository.IOptionGroupInfoRepository;
import com.zn.sitegroup.repository.IOptionGroupRepository;
import com.zn.sitegroup.repository.IOptionValueInfoRepository;
import com.zn.sitegroup.repository.IOptionValueRepository;
import com.zn.sitegroup.repository.IProductCampaignRepository;
import com.zn.sitegroup.repository.IProductGroupInfoRepository;
import com.zn.sitegroup.repository.IProductGroupRepository;
import com.zn.sitegroup.repository.IProductGroupValueInfoRepository;
import com.zn.sitegroup.repository.IProductGroupValueRepository;
import com.zn.sitegroup.repository.IProductImageRepository;
import com.zn.sitegroup.repository.IProductInfoRepository;
import com.zn.sitegroup.repository.IProductOptionRepository;
import com.zn.sitegroup.repository.IProductOptionStockRepository;
import com.zn.sitegroup.repository.IProductOptionTreeRepository;
import com.zn.sitegroup.repository.IProductPriceRepository;
import com.zn.sitegroup.repository.IProductRepository;
import com.zn.sitegroup.repository.IProductToCategoryRepository;
import com.zn.sitegroup.utils.JsonUtil;
import com.zn.sitegroup.utils.StringUtil;
import com.zn.sitegroup.utils.TemplateUtil;
import com.zn.sitegroup.utils.ZipUnZipUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zn on 2018/12/15.
 * 创建要分配的数据sql文件服务
 */
@Service
@Slf4j
public class AssignService {
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    ICategoryInfoRepository categoryInfoRepository;
    @Autowired
    IProductToCategoryRepository productToCategoryRepository;

    @Autowired
    IOptionGroupRepository optionGroupRepository;
    @Autowired
    IOptionGroupInfoRepository optionGroupInfoRepository;
    @Autowired
    IOptionValueRepository optionValueRepository;
    @Autowired
    IOptionValueInfoRepository optionValueInfoRepository;

    @Autowired
    IProductRepository productRepository;
    @Autowired
    IProductInfoRepository productInfoRepository;
    @Autowired
    IProductCampaignRepository productCampaignRepository;
    @Autowired
    IProductImageRepository productImageRepository;
    @Autowired
    IProductPriceRepository productPriceRepository;

    @Autowired
    IProductOptionRepository productOptionRepository;
    @Autowired
    IProductOptionStockRepository productOptionStockRepository;
    @Autowired
    IProductOptionTreeRepository productOptionTreeRepository;

    @Autowired
    IProductGroupRepository productGroupRepository;
    @Autowired
    IProductGroupInfoRepository productGroupInfoRepository;
    @Autowired
    IProductGroupValueRepository productGroupValueRepository;
    @Autowired
    IProductGroupValueInfoRepository productGroupValueInfoRepository;
    @Autowired
    IAssginRepository assginRepository;

    @Autowired
    CategoryService categoryService ;
    @Autowired
    RuleService rulesService;

//    @Getter @Setter
//    private AssginDto assginDto;
//
    public void saveAssgin(DcAssginEntity assginEntity) {
        assginRepository.save(assginEntity);
    }

    public DcRulesEntity getAssginEntity(long rulesId){
        return rulesService.find(rulesId);
    }

    public void createSqlFile(AssginDto dto){
        // 先把公共的数据sql文件生成，这些数据即使站点用不上，也不会产生影响，减少编码的复杂度
        createCommonSqlFile(dto);
        // 这里处理分类数据。先构建相关分类的目录结构，怎么创建？分类有两种:一种是原产品结构，一种是自定义的目录结构，这两种需要分开处理还是统一处理？需要仔细思考一下
        // 无论是何种结构，实际使用时暂不考虑随意更换层级关系的情况。我们就按当前分类往上找。这样简化处理。后期可能处理逻辑更加复杂。
        createCategoriesSqlFile(dto);
        // 导出产品相关数据：1. 获取规则和其他分发条件，2. 根据规则查产品和过滤产品（时间和产品名）。基本逻辑：1. 按照分类找。中途需要根据时间、option，产品名等做处理。之前的逻辑已经不适用。
        createProductSqlFile(dto);

    }

    /**
     * 创建全局数据sql文件
     * @param dto
     */
    private void createCommonSqlFile(AssginDto dto) {
        String sqlFile = ApplicationConfig.SQL_FOLDER + dto.getAssginEntity().getFileName();
        //1. 先把一些全局性的数据导出(这种数据不和具体的产品有关，站点多一些冗余数据也无妨)
        //product_groups
        List<LcProductGroupsEntity> productGroupsEntityList = productGroupRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "product_groups.ftl",sqlFile,productGroupsEntityList,true);
//        builderReplaceIntoSqlFile(null,"product_groups.ftl",sqlFile + "product_groups.sql",productGroupsEntityList,true);
        //product_groups_info
        List<LcProductGroupsInfoEntity> productGroupsInfoEntityList = productGroupInfoRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"product_groups_info.ftl",sqlFile,productGroupsInfoEntityList,true);
//        builderReplaceIntoSqlFile(null,"product_groups_info.ftl",sqlFile + "product_groups_info.sql",productGroupsInfoEntityList,true);
        //product_groups_values
        List<LcProductGroupsValuesEntity> productGroupsValuesEntityList = productGroupValueRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"product_groups_values.ftl",sqlFile,productGroupsValuesEntityList,true);
//        builderReplaceIntoSqlFile(null,"product_groups_values.ftl",sqlFile + "product_groups_values.sql",productGroupsValuesEntityList,true);
        //product_groups_values_info
        List<LcProductGroupsValuesInfoEntity> productGroupsValuesInfoEntityList = productGroupValueInfoRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"product_groups_values_info.ftl",sqlFile,productGroupsValuesInfoEntityList,true);
//        builderReplaceIntoSqlFile(null,"product_groups_values_info.ftl",sqlFile + "product_groups_values_info.sql",productGroupsValuesInfoEntityList,true);
        /*product groups end*/
        // 因为option表数据是全局的，所以一次全部导出，这里不再针对每个产品做判断，需要判断的是每个产品有哪些，这个在方法createSqlFileByProducts里做
//      15 `lc_option_groups all option_groups
        List<LcOptionGroupsEntity> optionGroupsEntityList = optionGroupRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"option_groups.ftl",sqlFile,optionGroupsEntityList,true);
//        builderReplaceIntoSqlFile(null,"option_groups.ftl",sqlFile + "option_groups.sql",optionGroupsEntityList,true);
//      16 `lc_option_groups_info` all option_groups_info
        List<LcOptionGroupsInfoEntity> optionGroupsInfoEntityList = optionGroupInfoRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"option_groups_info.ftl",sqlFile,optionGroupsInfoEntityList,true);
//        builderReplaceIntoSqlFile(null,"option_groups_info.ftl",sqlFile + "option_groups_info.sql",optionGroupsInfoEntityList,true);
//      17 `lc_option_values` all option_values
        List<LcOptionValuesEntity> optionValuesEntityList = optionValueRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"option_values.ftl",sqlFile,optionValuesEntityList,true);
//        builderReplaceIntoSqlFile(null,"option_values.ftl",sqlFile + "option_values.sql",optionValuesEntityList,true);
//      18 `lc_option_values_info all option_values_info
        List<LcOptionValuesInfoEntity> optionValuesInfoEntityList = optionValueInfoRepository.findAll();
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"option_values_info.ftl",sqlFile,optionValuesInfoEntityList,true);
//        builderReplaceIntoSqlFile(null,"option_values_info.ftl",sqlFile + "option_values_info.sql",optionValuesInfoEntityList,true);
       /* option end */
    }
    /**
     * 创建分类数据sql文件
     */
    private void createCategoriesSqlFile(AssginDto dto) {
        //TODO:有个问题，如果是原产品目录结构，那么需要怎么处理？应该要找到父类和子类，不能只找父类。
        String sqlFile = ApplicationConfig.SQL_FOLDER + dto.getAssginEntity().getFileName();
        // 获取上层分类。然后生成sql，这里不需要找对应的产品，只是生成分类
        DcAssginEntity assginEntity = dto.getAssginEntity();// 这里到底是json字符串还是一个json还没定，但无论如何，最后都是一个id数组，然后循环处理。考虑去重
        String categories = assginEntity.getCategories();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 读取json数据，
            List<CategoryJsonBean> categoryJsonBeanList = mapper.readValue(categories,new TypeReference<List<CategoryJsonBean>>(){});
            List<LcCategoriesEntity> categoriesEntityList = null;
            List<LcCategoriesInfoEntity> categoriesInfoEntityList = new ArrayList<>();
            // 获取json格式里分类id对应的自己和所有父级分类和子分类
            categoriesEntityList = findCategoryByCategoryJsonBeanList(categoryJsonBeanList);
            // 3 获取分类的id集合，并得到分类的info信息
            List<Long> categoryIds = categoriesEntityList.stream().map(LcCategoriesEntity::getId)
                    .distinct().collect(Collectors.toList());
            categoriesInfoEntityList = categoryInfoRepository.find(categoryIds);

            // 4. 生成sql数据文件。
            builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,
                    "categories.ftl",sqlFile,
                    categoriesEntityList,true);
            builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"categories_info.ftl",
                    sqlFile,categoriesInfoEntityList,true);

        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString(),e);
        }
    }

    /**
     * 处理产品相关数据，这方法逻辑将比较复杂，同时耗时较久，内存消耗也很大。
     * @param dto
     */
    private void createProductSqlFile(AssginDto dto) {
        String sqlFile = ApplicationConfig.SQL_FOLDER + dto.getAssginEntity().getFileName();
        //1. 获取要分发哪些产品通过rule获取。
        //2. 这些产品需要归属于哪些分类，通过assgin获取。(这里有个情况，如果分发时是使用的原产品分类目录，那么assgin里需不需要记录分类？)
        String categories = dto.getRulesEntity().getCategories();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // TODO:拿到规则里所有的分类，并获取每个分类下的产品和子分类。
            List<CategoryJsonBean> categoryJsonBeanList = mapper.readValue(categories,new TypeReference<List<CategoryJsonBean>>(){});
            List<LcCategoriesEntity> categoriesEntityList = null;
            // 获取json格式里分类id，这里应该获取子类而不是父类，
            categoriesEntityList = findCategoryByCategoryJsonBeanList(categoryJsonBeanList);
//            // 3 获取分类的id集合，并得到分类的id信息
            List<Long> categoryIds = categoriesEntityList.stream().map(LcCategoriesEntity::getId)
                    .distinct().collect(Collectors.toList());
            // 获取这些分类下的产品
           for(long categoryId: categoryIds) {
               List<LcProductsEntity> list = categoryService.findProductsByCategoryContainAllChildrenCategory(categoryId,true);
               //TODO: 注意，option的处理和以前不同，需要从dc_option_trees里查询生成lc_product_option_trees数据
               createSqlFileByProducts(list,dto);
               log.info("sql文件全部生成完毕,文件路径:{}",sqlFile);
           }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param list
     * @return
     */
    private List<LcCategoriesEntity> findCategoryByCategoryJsonBeanList(List<CategoryJsonBean> list){
        List<LcCategoriesEntity> categoriesEntityList = null;
        Set<LcCategoriesEntity> categoriesSet = new HashSet();
        // 遍历上传的分类对象，拿到id
        for(CategoryJsonBean bean : list) {
            long id = bean.getId();
            // 1. 查询当前分类的以及所有父类信息，这里还应该获取子分类信息。否则分类信息是不完整的。
            categoriesEntityList = categoryRepository.findChildParents(id);
            // 2 把数据放入到set做去重处理
            categoriesSet.addAll(categoriesEntityList);
        }
        // 5 将set里的对象转移到list里
        categoriesEntityList = new ArrayList<>(categoriesSet);
        return categoriesEntityList;
    }
    /**
     * 根据分类生成相关sql文件 旧版本的实现
     * @param categoryId
     */
//    private void createSqlFileByCategoryID(int categoryId,AssginDto assginDto) {
////        String sqlFile = "d:/sql-test/desc/";
////        String sqlFile = ApplicationConfig.SQL_FOLDER + "assgin.sql";
//        String sqlFile = ApplicationConfig.SQL_FOLDER + assginDto.getAssginEntity().getFileName();
////        File file = new File(sqlFile);
////        file.delete();
////        file = new File(ApplicationConfig.SQL_ZIP_FOLDER + ApplicationConfig.SQL_ZIP_FILE_NAME);
////        file.delete();
//        // 构建分类相关sql
//        //1. 找到当前分类下的所有子分类
////        List<CategoryDto> childernList = categoryService.findParentAllChildern(categoryId);
//        //2. 找到当前分类下的父分类
////        List<CategoryDto> parentList = categoryService.findChildParents(categoryId);
////        parentList.addAll(childernList);
//        // 无论什么情况，都拿出所有的分类数据给子站,
//        //TODO:这里有问题，不能这样处理还是只能像以前获取当前分类下的子分类以及当前分类，不然子站会有多分类没有商品
////        List<LcCategoriesEntity> categoriesEntityList = categoryRepository.findAll();
////        List<LcCategoriesInfoEntity> categoriesInfoEntityList = categoryInfoRepository.findAll();
//
////        parentList.stream().forEach(categoryDto->{
////            // 1. 构建lc_categories
////            LcCategoriesEntity categoriesEntity = categoryService.getCategoriesEntityByCategoryDto(categoryDto);
////            // 2. 构建lc_categories_info
////            LcCategoriesInfoEntity categoriesInfoEntity = categoryService.getCategoriesInfoEntityByCategoryDto(categoryDto);
////
////            categoriesEntityList.add(categoriesEntity);
////            categoriesInfoEntityList.add(categoriesInfoEntity);
////
////        });
////        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,
////                "categories.ftl",sqlFile,
////                categoriesEntityList,true);
////        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"categories_info.ftl",
////                sqlFile,categoriesInfoEntityList,true);
//
////        builderReplaceIntoSqlFile(null,
////                            "categories.ftl",sqlFile+"categories.sql",
////                                    categoriesEntityList,true);
////        builderReplaceIntoSqlFile(null,"categories_info.ftl",
////                                    sqlFile+"categories_info.sql",categoriesInfoEntityList,true);
//        // 构建product_group
////            3 `lc_product_groups` all
////            4 `lc_product_groups_info` all
////            5 `lc_product_groups_values` all
////            6 `lc_product_groups_values_info`   all
//
////        // 2 根据产品构建sql文件
////            // 2.1  1 找到当前分类下的所有商品(含子分类)
////        List<LcProductsEntity> list = categoryService.findProductsByCategoryContainAllChildrenCategory(categoryId,true);
//////        createSqlFileByProducts(list);
////        log.info("sql文件全部生成完毕,文件路径:{}",sqlFile);
//    }

    /**
     * 根据产品生成相关sql文件,注意该方法不会去做分类相关的操作。只能满足非分类以外数据的更新或插入。如果产品的分类发生变化，改方法不能满足，
     * 暂时还没有提供其他方法来满足此类需求
     * @param productId
     */
    private void createSqlFileByProducts(List<LcProductsEntity> products,AssginDto assginDto) {

        log.info("进入 createSqlFileByProducts，商品数量:{}",products.size());
//        String sqlFile = "d:/sql-test/desc/";
//        String sqlFile = "d:/sql-test/assgin.sql";
        String sqlFile = ApplicationConfig.SQL_FOLDER + assginDto.getAssginEntity().getFileName();
        List<LcProductsInfoEntity> productsInfoEntityList =  new ArrayList<>();
        List<LcProductsCampaignsEntity> productsCampaignsEntityList = new ArrayList<>();
        List<LcProductsImagesEntity> productsImagesEntityList = new ArrayList<>();
        List<LcProductsPricesEntity> productsPricesEntityList = new ArrayList<>();
        List<LcProductsToCategoriesEntity> productsToCategoriesEntityList = new ArrayList();

        List<LcProductOptionTreesEntity> productOptionTreesEntityList = new ArrayList<>();
        List<LcProductsOptionsEntity> productsOptionsEntityList = new ArrayList<>();
        List<LcProductsOptionsStockEntity> productsOptionsStockEntityList = new ArrayList<>();

        /**这里得到quantity、product_groups、price全局信息**/
        BigDecimal quantity =  assginDto.getRulesEntity().getQuantity();
        BigDecimal price = assginDto.getRulesEntity().getProductPrice();
        String seoInfo = assginDto.getRulesEntity().getSeoInfo();
        String productGroupJsonString = assginDto.getRulesEntity().getProductGroups();
        List<ProductGroupJsonBean> productGroupJsonBeanList = JsonUtil.getArrayByJsonString(productGroupJsonString, new TypeReference<List<ProductGroupJsonBean>>(){});
        StringBuffer productGroups = new StringBuffer();
        for(ProductGroupJsonBean bean : productGroupJsonBeanList) {
            long id = bean.getId();
            List<ProductGroupJsonBean> values = bean.getValues();
            for(ProductGroupJsonBean value : values) {
                productGroups.append(id + "-" + value.getId() + ",");
            }
        }
        // 去除最后一个逗号
        if(productGroups.lastIndexOf(",") == productGroups.length() - 1) {
            productGroups.delete(productGroups.length() - 1,productGroups.length());
        }
        log.info("开始获取每个商品的特定数据,商品数量:{}",products.size());
        int size = products.size();
        int count = 0;
        int rows = 1000;
        int i = 0;
        long start = System.currentTimeMillis();
        for(;i < size; i ++) {// 这里耗时也非常多，18w达到
            LcProductsEntity product = products.get(i);
            /***
             * 这里lc_products表需要修改product_groups列的数据和quantity列。 组id-itemId,组id-itemId 这种格式
             */
            product.setQuantity(quantity);
            product.setProductGroups(productGroups.toString());
            // 为了减少内存使用，这里需要分批处理，每达到1000个商品就生成一次sql文件
            int productId = product.getId();
            //        7 `lc_products` product_id
            //        8 `lc_products_info` product_id
            LcProductsInfoEntity productInfo = productInfoRepository.findByProductId(productId);
            productInfo.setHeadTitle(seoInfo);
            productInfo.setMetaDescription(seoInfo);
            productsInfoEntityList.add(productInfo);

            //        9 `lc_products_campaigns` product_id
//            productsCampaignsEntityList.addAll(productCampaignRepository.findByProductId(productId));
            //        10 `lc_products_images`    product_id
            productsImagesEntityList.addAll(productImageRepository.findByProductId(productId));
            //        11 `lc_products_prices`    product_id
            List<LcProductsPricesEntity> pricesEntityList = productPriceRepository.findByProductId(productId);
            pricesEntityList.stream().forEach(productPrice->{
                productPrice.setUsd(price);
            });
            productsPricesEntityList.addAll(pricesEntityList);

            // 12 `lc_products_to_categories` product_id TODO:这里逻辑不对，应该按照实际分发时的逻辑来
            productsToCategoriesEntityList.addAll(productToCategoryRepository.findByProductId(productId));
            /*product end*/
            /************ 一下是 product option 的处理 ***********************
             * lc_product_option_trees的处理逻辑
             * 1.
             *
             *
             * lc_product_options的处理逻辑
             */

        //         17 `lc_product_option_trees` product_id // 这里需要根据dc_option_trees来生成，数据中心lc_product_option_trees不保存数据。
            productOptionTreesEntityList.addAll(productOptionTreeRepository.findByProductId(productId));
            //         18 `lc_products_options` product_id 这个地方也应该要重新处理，数据中心不应该保存该数据。
            List<LcProductsOptionsEntity> productsOptionsList = productOptionRepository.findByProductId(productId);
            productsOptionsEntityList.addAll(productsOptionsList);
            //         19 `lc_products_options_stock` product_id// 这里如果没有会怎么样？
            //  litecart的数量实际在购买时并没有修改具体每个option stock的值，只是改了product 表里的总数，所以这个地方原则上是可以不用导出
//            productsOptionsStockEntityList.addAll(productOptionStockRepository.findByProductId(productId));

            /*---- options end */
            count++;
            if(count >= rows || i == size-1) {
                long end = System.currentTimeMillis();
                count = 0;
                log.info("{}商品特定数据获取完毕，耗时:{},开始写入到sql文件.",rows,(end - start));
 //        builderReplaceIntoSqlFile(null,"products.ftl",sqlFile + "products.sql",products,true);
                //8 products_info
                log.info("products_info，数据容量:{}", productsInfoEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_info.ftl", sqlFile, productsInfoEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_info.ftl",sqlFile + "products_info.sql",productsInfoEntityList,true);
                //9 products_campaigns
                log.info("products_campaigns，数据容量:{}", productsCampaignsEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_campaigns.ftl", sqlFile, productsCampaignsEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_campaigns.ftl",sqlFile + "products_campaigns.sql",productsCampaignsEntityList,true);
                //10 products_images
                log.info("products_images，数据容量:{}", productsImagesEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_images.ftl", sqlFile, productsImagesEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_images.ftl",sqlFile + "products_images.sql",productsImagesEntityList,true);
                //11 products_prices
                log.info("products_prices，数据容量:{}", productsPricesEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_prices.ftl", sqlFile, productsPricesEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_prices.ftl",sqlFile + "products_prices.sql",productsPricesEntityList,true);
                //12 products_to_categories
                log.info("products_to_categories，数据容量:{}", productsToCategoriesEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_to_categories.ftl", sqlFile, productsToCategoriesEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_to_categories.ftl",sqlFile + "products_to_categories.sql",productsToCategoriesEntityList,true);
                //13 product_option_trees
                log.info("product_option_trees，数据容量:{}", productOptionTreesEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "product_option_trees.ftl", sqlFile, productOptionTreesEntityList, true);
//        builderReplaceIntoSqlFile(null,"product_option_trees.ftl",sqlFile + "product_option_trees.sql",productOptionTreesEntityList,true);
                //14 products_options
                log.info("products_options，数据容量:{}", productsOptionsEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_options.ftl", sqlFile, productsOptionsEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_options.ftl",sqlFile + "products_options.sql",productsOptionsEntityList,true);
                //19 products_options_stock
                log.info("products_options_stock，数据容量:{}", productsOptionsStockEntityList.size());
                builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products_options_stock.ftl", sqlFile, productsOptionsStockEntityList, true);
//        builderReplaceIntoSqlFile(null,"products_options_stock.ftl",sqlFile + "products_options_stock.sql",productsOptionsStockEntityList,true);
                start = System.currentTimeMillis();
                log.info("完成{}商品信息写入后，products数据数据容量:{}", rows,products.size());
            }
        }
        //7 products
        log.info("最后写入products数据，数据容量:{}", products.size());
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER, "products.ftl", sqlFile, products, true);

    }

    /**
     * 构建sql文件，默认按每1000条生成一个values,该方法执行完毕后会调用datas.clear().
     * @param sqlTemplateFolder 模板目录
     * @param ftlFile   模板文件名，方法会到sqlTemplateFolder下去找该文件，如果该文件还有父目录，加上父目录即可
     * @param sqlFilePath   生成的sql文件
     * @param datas 需要生成sql的数据
     * @param isAppend  是否以追加的方式生成sql文件。true，那么会在sqlFilePath指定的文件内容上进行数据追加，false,原文件会被覆盖
     */
    private void builderReplaceIntoSqlFile(String sqlTemplateFolder,String ftlFile,
                                String sqlFilePath,List datas,boolean isAppend) {
        if(datas.size() > 0) {
            FileWriter writer = null;
            long start = System.currentTimeMillis();
            if (StringUtil.isBlank(sqlTemplateFolder)) {
                sqlTemplateFolder = "sitegroup/sql_template";
            }
            Template freeTemplate = TemplateUtil.getTemplate(sqlTemplateFolder, ftlFile);
            try {
                datas.stream().forEach(data -> {
                    if (data != null) {
                        StringUtil.escapeSingleQuotes(data);
                    }
                });
                if (isAppend == true) {
                    writer = new FileWriter(new File(sqlFilePath), true);
                    int count = datas.size();
                    int rows = 1000;
                    int loop = count % rows == 0 ? count / rows : (count / rows) + 1;
                    List<LcProductsEntity> data = null;
                    for (int i = 0; i < loop; i++) {
                        int startIndex = rows * i;
                        int endIndex = startIndex + rows;
                        if (endIndex > datas.size()) {
                            endIndex = datas.size();
                        }
                        if (startIndex > datas.size()) {
                            startIndex = datas.size() - 1;
                        }
                        if (endIndex == startIndex) {
                            break;
                        }
                        data = datas.subList(startIndex, endIndex);
                        Map datasMap = new HashMap();
                        datasMap.put("datas", data);
                        freeTemplate.process(datasMap, writer);
                    }
                } else {
                    writer = new FileWriter(new File(sqlFilePath));
                    Map dataMap = new HashMap();
                    dataMap.put("datas", datas);
                    freeTemplate.process(dataMap, writer);
                }
            } catch (TemplateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                datas.clear();
            }
            long end = System.currentTimeMillis();
            log.info("----------- 耗时: {}毫秒，模板文件：{}---------------", (end - start), ftlFile);
        }
    }
}
