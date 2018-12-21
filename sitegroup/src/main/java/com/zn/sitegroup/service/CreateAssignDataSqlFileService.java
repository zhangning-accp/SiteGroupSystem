package com.zn.sitegroup.service;

import com.zn.sitegroup.ApplicationConfig;
import com.zn.sitegroup.dto.CategoryDto;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zn on 2018/12/15.
 * 创建要分配的数据sql文件服务
 */
@Service
@Slf4j
public class CreateAssignDataSqlFileService {
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
    CategoryService categoryService ;

    /**
     * 根据分类生成相关sql文件
     * @param categoryId
     */
    public void createSqlFileByCategoryID(int categoryId) {
//        String sqlFile = "d:/sql-test/desc/";
//        String sqlFile = ApplicationConfig.SQL_FOLDER + "assgin.sql";
        String sqlFile = ApplicationConfig.SQL_FOLDER + ApplicationConfig.SQL_FILE_NAME;
//        File file = new File(sqlFile);
//        file.delete();
//        file = new File(ApplicationConfig.SQL_ZIP_FOLDER + ApplicationConfig.SQL_ZIP_FILE_NAME);
//        file.delete();
        // 构建分类相关sql
        //1. 找到当前分类下的所有子分类
//        List<CategoryDto> childernList = categoryService.findParentAllChildern(categoryId);
        //2. 找到当前分类下的父分类
//        List<CategoryDto> parentList = categoryService.findChildParents(categoryId);
//        parentList.addAll(childernList);
        // 无论什么情况，都拿出所有的分类数据给子站,
        //TODO:这里有问题，不能这样处理还是只能像以前获取当前分类下的子分类以及当前分类，不然子站会有多分类没有商品
        List<LcCategoriesEntity> categoriesEntityList = categoryRepository.findAll();
        List<LcCategoriesInfoEntity> categoriesInfoEntityList = categoryInfoRepository.findAll();

//        parentList.stream().forEach(categoryDto->{
//            // 1. 构建lc_categories
//            LcCategoriesEntity categoriesEntity = categoryService.getCategoriesEntityByCategoryDto(categoryDto);
//            // 2. 构建lc_categories_info
//            LcCategoriesInfoEntity categoriesInfoEntity = categoryService.getCategoriesInfoEntityByCategoryDto(categoryDto);
//
//            categoriesEntityList.add(categoriesEntity);
//            categoriesInfoEntityList.add(categoriesInfoEntity);
//
//        });
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,
                "categories.ftl",sqlFile,
                categoriesEntityList,true);
        builderReplaceIntoSqlFile(ApplicationConfig.FTL_TEMPLATE_FOLDER,"categories_info.ftl",
                sqlFile,categoriesInfoEntityList,true);

//        builderReplaceIntoSqlFile(null,
//                            "categories.ftl",sqlFile+"categories.sql",
//                                    categoriesEntityList,true);
//        builderReplaceIntoSqlFile(null,"categories_info.ftl",
//                                    sqlFile+"categories_info.sql",categoriesInfoEntityList,true);
        // 构建product_group
//            3 `lc_product_groups` all
//            4 `lc_product_groups_info` all
//            5 `lc_product_groups_values` all
//            6 `lc_product_groups_values_info`   all
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

//        // 2 根据产品构建sql文件
//            // 2.1  1 找到当前分类下的所有商品(含子分类)
        List<LcProductsEntity> list = categoryService.findProductsByCategoryContainAllChildrenCategory(categoryId,true);
        createSqlFileByProducts(list);
        log.info("sql文件全部生成完毕,文件路径:{}",sqlFile);
    }

    /**
     * 根据产品生成相关sql文件,注意该方法不会去做分类相关的操作。只能满足非分类以外数据的更新或插入。如果产品的分类发生变化，改方法不能满足，
     * 暂时还没有提供其他方法来满足此类需求
     * @param productId
     */
    private void createSqlFileByProducts(List<LcProductsEntity> products) {

        log.info("进入 createSqlFileByProducts，商品数量:{}",products.size());
//        String sqlFile = "d:/sql-test/desc/";
//        String sqlFile = "d:/sql-test/assgin.sql";
        String sqlFile = ApplicationConfig.SQL_FOLDER + ApplicationConfig.SQL_FILE_NAME;
        List<LcProductsInfoEntity> productsInfoEntityList =  new ArrayList<>();
        List<LcProductsCampaignsEntity> productsCampaignsEntityList = new ArrayList<>();
        List<LcProductsImagesEntity> productsImagesEntityList = new ArrayList<>();
        List<LcProductsPricesEntity> productsPricesEntityList = new ArrayList<>();
        List<LcProductsToCategoriesEntity> productsToCategoriesEntityList = new ArrayList();

        List<LcProductOptionTreesEntity> productOptionTreesEntityList = new ArrayList<>();
        List<LcProductsOptionsEntity> productsOptionsEntityList = new ArrayList<>();
        List<LcProductsOptionsStockEntity> productsOptionsStockEntityList = new ArrayList<>();

        log.info("开始获取每个商品的特定数据,商品数量:{}",products.size());
        int size = products.size();
        int count = 0;
        int rows = 1000;
        int i = 0;
        long start = System.currentTimeMillis();
        for(;i < size; i ++) {// 这里耗时也非常多，18w达到
            LcProductsEntity product = products.get(i);
                // 为了减少内存使用，这里需要分批处理，每达到1000个商品就生成一次sql文件
                int productId = product.getId();
                //        7 `lc_products` product_id
                //        8 `lc_products_info` product_id
                productsInfoEntityList.add(productInfoRepository.findByProductId(productId));
                //        9 `lc_products_campaigns` product_id
                productsCampaignsEntityList.addAll(productCampaignRepository.findByProductId(productId));
                //        10 `lc_products_images`    product_id
                productsImagesEntityList.addAll(productImageRepository.findByProductId(productId));
                //        11 `lc_products_prices`    product_id
                productsPricesEntityList.addAll(productPriceRepository.findByProductId(productId));
                //        12 `lc_products_to_categories` product_id
                productsToCategoriesEntityList.addAll(productToCategoryRepository.findByProductId(productId));
                /*product end*/
                //         17 `lc_product_option_trees` product_id
                productOptionTreesEntityList.addAll(productOptionTreeRepository.findByProductId(productId));
                //         18 `lc_products_options` product_id
                List<LcProductsOptionsEntity> productsOptionsList = productOptionRepository.findByProductId(productId);
                productsOptionsEntityList.addAll(productsOptionsList);
                //         19 `lc_products_options_stock` product_id
                productsOptionsStockEntityList.addAll(productOptionStockRepository.findByProductId(productId));
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
    
//    /**
//     * Test pass
//     * 输出categies 表里的所有数据到指定的sql文件。
//     * Test pass
//     * @param sqlTemplatePath Freemarker file folder path. if null or whitespaces, default “sitegroup/sql_template”
//     * @param sqlFilePath Out sql file path. if null or whitespaces, default categories.sql
//     */
//    private void createAllCategorySqlFile(String sqlTemplatePath,String ftlFile,
//                                         String sqlFilePath,boolean isAppend) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(ftlFile)) {
//            ftlFile = "categories.ftl";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "categories.sql";
//        }
//        long start = System.currentTimeMillis();
////        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
////        try {
////            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
////            freemarkerConfiguration.setDefaultEncoding("UTF-8");
////            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
////            Template freeTemplate = TemplateUtil.getTemplate(sqlTemplatePath,ftlFile);
//////            log.info("开始获取info数据");
//            List<LcCategoriesEntity> datas = categoryRepository.findAll();
//            builderReplaceIntoSqlFile(sqlTemplatePath,ftlFile,sqlFilePath,datas,isAppend);
////            long end = System.currentTimeMillis();
////            log.info("获取数据消耗：{}",end - start);
////            long end1 = System.currentTimeMillis();
//////            log.info("整理数据消耗：{}",end1 - end);
////            Map dataMap = new HashMap();
////            dataMap.put("datas",datas);
//////            log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...",categoriesEntityList.size(),end1-end);
////            end = System.currentTimeMillis();
////            freeTemplate.process(dataMap,new FileWriter(new File(sqlFilePath),true));
////            end1 = System.currentTimeMillis();
////            log.info("输出完毕，耗时：{}",end1 - end);
//////            end = System.currentTimeMillis();
//////            log.info("消毁list完毕，耗时：{}",end - end1);
////
////            long end5 = System.currentTimeMillis();
////            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (TemplateException e) {
////            e.printStackTrace();
////        }
//    }
//
//    /**
//     * Test pass
//     * 输出categies_info 表里的所有数据到指定的sql文件。
//     * Test pass
//     * @param sqlTemplatePath Freemarker file path. if null or whitespaces, default “sitegroup/sql_template”
//     * @param sqlFilePath Out sql file path. if null or whitespaces, default categories_info.sql
//     */
//    private void createAllCategoryInfoSqlFile(String sqlTemplatePath,String ftlFile,
//                                         String sqlFilePath,boolean isAppend) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "categories_info.sql";
//        }
//        if(StringUtil.isBlank(ftlFile)) {
//            ftlFile = "categories_info.ftl";
//        }
//        long start = System.currentTimeMillis();
////        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
////        try {
////            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
////            freemarkerConfiguration.setDefaultEncoding("UTF-8");
////            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
////            Template freeTemplate = freemarkerConfiguration.getTemplate("categories_info.ftl");
////            log.info("开始获取info数据");
//            List<LcCategoriesInfoEntity> datas = categoryInfoRepository.findAll();
//            builderReplaceIntoSqlFile(sqlTemplatePath,ftlFile,sqlFilePath,datas,isAppend);
////            long end = System.currentTimeMillis();
////            log.info("获取数据消耗：{}",end - start);
////            long end1 = System.currentTimeMillis();
//////            log.info("整理数据消耗：{}",end1 - end);
////            Map dataMap = new HashMap();
////            dataMap.put("datas",datas);
//////            log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...",categoriesInfoEntityList.size(),end1-end);
////            end = System.currentTimeMillis();
////            freeTemplate.process(dataMap,new FileWriter(new File(sqlFilePath),true));
////            end1 = System.currentTimeMillis();
////            log.info("输出完毕耗时：{}",end1 - end);
////            end = System.currentTimeMillis();
//////            log.info("消毁list完毕，耗时：{}",end - end1);
////
////            long end5 = System.currentTimeMillis();
////            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
////        } catch (IOException e) {
////            e.printStackTrace();
////        } catch (TemplateException e) {
////            e.printStackTrace();
////        }
//    }
//
//    /**
//     * Test pass
//     * 输出option_groups表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllOptionGroupsSqlFile(String sqlTemplatePath,
//                                             String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "option_groups.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("option_groups.ftl");
////            log.info("开始获取info数据");
//            List<LcOptionGroupsEntity> datas = optionGroupRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map dataMap = new HashMap();
//                dataMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(dataMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出option_groups表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllOptionGroupsInfoSqlFile(String sqlTemplatePath,
//                                             String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "option_groups_info.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("option_groups_info.ftl");
//            log.info("开始获取info数据");
//            List<LcOptionGroupsInfoEntity> datas = optionGroupInfoRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map dataMap = new HashMap();
//                dataMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(dataMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出option_values表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllOptionValuesSqlFile(String sqlTemplatePath,
//                                                 String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "option_values.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("option_values.ftl");
////            log.info("开始获取info数据");
//            List<LcOptionValuesEntity> datas = optionValueRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map dataMap = new HashMap();
//                dataMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", optionValuesEntityList.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(dataMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出option_values_info表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllOptionValuesInfoSqlFile(String sqlTemplatePath,
//                                             String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "option_values_info.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("option_values_info.ftl");
////            log.info("开始获取info数据");
//            List<LcOptionValuesInfoEntity> datas = optionValueInfoRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map datasMap = new HashMap();
//                datasMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出product_groups表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllProductGroupsSqlFile(String sqlTemplatePath,
//                                                 String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "product_groups.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups.ftl");
//            log.info("开始获取info数据");
//            List<LcProductGroupsEntity> datas = productGroupRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map datasMap = new HashMap();
//                datasMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出product_groups_info表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllProductGroupsInfoSqlFile(String sqlTemplatePath,
//                                              String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "product_groups_info.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups_info.ftl");
////            log.info("开始获取info数据");
//            List<LcProductGroupsInfoEntity> datas = productGroupInfoRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map datasMap = new HashMap();
//                datasMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出product_groups_values表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllProductGroupsValuesSqlFile(String sqlTemplatePath,
//                                                  String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "product_groups_values.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups_values.ftl");
//            log.info("开始获取info数据");
//            List<LcProductGroupsValuesEntity> datas = productGroupValueRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map datasMap = new HashMap();
//                datasMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出product_groups_values表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllProductGroupsValuesInfoSqlFile(String sqlTemplatePath,
//                                                    String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "product_groups_values_info.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups_values_info.ftl");
////            log.info("开始获取info数据");
//            List<LcProductGroupsValuesInfoEntity> datas = productGroupValueInfoRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map datasMap = new HashMap();
//                datasMap.put("datas", datas);
//                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出product_option_trees表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllProductOptionTreesInfoSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "product_option_trees.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("product_option_trees.ftl");
////            log.info("开始获取info数据");
//            List<LcProductOptionTreesEntity> datas = productOptionTreeRepository.findAll();
//            if(datas.size() > 0) {
//                long end = System.currentTimeMillis();
//                log.info("获取数据消耗：{}", end - start);
//                long end1 = System.currentTimeMillis();
////                log.info("整理数据消耗：{}", end1 - end);
//                Map datasMap = new HashMap();
//                datasMap.put("datas", datas);
////                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
//                end = System.currentTimeMillis();
//                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
//                end = System.currentTimeMillis();
////                log.info("消毁list完毕，耗时：{}", end - end1);
//
//                long end5 = System.currentTimeMillis();
//                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出products表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     */
//    private void createAllProductsSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        long start = System.currentTimeMillis();
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products.sql";
//        }
//
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products.ftl");
//            List<LcProductsEntity> datas = productRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据消耗:{}",end - start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
////            datas.clear();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出products_info表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsInfoSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_info.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_info.ftl");
//            List<LcProductsInfoEntity> datas = productInfoRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据消耗:{}",end - start);
//            start = System.currentTimeMillis();
//            datas = datas.stream().map(p->{
////                String name = StringUtil.escapeSingleQuotes(p.getName());
////                String shortDescription = StringUtil.escapeSingleQuotes(p.getShortDescription());
////                String description = StringUtil.escapeSingleQuotes(p.getDescription());
////                String headTitle = StringUtil.escapeSingleQuotes(p.getHeadTitle());
////                String metaDescription = StringUtil.escapeSingleQuotes(p.getMetaDescription());
////                String attributes = StringUtil.escapeSingleQuotes(p.getAttributes());
////                p.setName(name);
////                p.setShortDescription(shortDescription);
////                p.setDescription(description);
////                p.setHeadTitle(headTitle);
////                p.setMetaDescription(metaDescription);
////                p.setAttributes(attributes);
//                return (LcProductsInfoEntity)StringUtil.escapeSingleQuotes(p);
//            }).collect(Collectors.toList());
//            end = System.currentTimeMillis();
//            log.info("整理数据消耗:{}",end - start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsInfoEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
//            datas.clear();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出products_campaigns表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsCampaignsSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_campaigns.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_campaigns.ftl");
//            List<LcProductsCampaignsEntity> datas = productCampaignRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据消耗:{}",end - start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsCampaignsEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
////            datas.clear();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出products_images表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsImagesSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_images.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_images.ftl");
//            List<LcProductsImagesEntity> datas = productImageRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据消耗:{}",end - start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsImagesEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出products_options表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsOptionsSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_options.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_options.ftl");
//            List<LcProductsOptionsEntity> datas = productOptionRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据消耗:{}",end - start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsOptionsEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Test pass
//     * 输出products_options_stock表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsOptionsStockSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_options_stock.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_options_stock.ftl");
//            List<LcProductsOptionsStockEntity> datas = productOptionStockRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据完成，耗时：{}",end-start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsOptionsStockEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出products_options_stock表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsPricesSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_prices.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_prices.ftl");
//            List<LcProductsPricesEntity> datas = productPriceRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据完成，耗时：{}",end-start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsPricesEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * Test pass
//     * 输出products_to_categories表里的所有数据到sql文件
//     * @param sqlTemplatePath
//     * @param sqlFilePath
//     * 该方法会将数据拆分成每份1000.
//     */
//    private void createAllProductsToCategoriesSqlFile(String sqlTemplatePath,String sqlFilePath) {
//        if(StringUtil.isBlank(sqlTemplatePath)) {
//            sqlTemplatePath = "sitegroup/sql_template";
//        }
//        if(StringUtil.isBlank(sqlFilePath)) {
//            sqlFilePath = "products_to_categories.sql";
//        }
//        long start = System.currentTimeMillis();
//        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
//        try {
//            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
//            freemarkerConfiguration.setDefaultEncoding("UTF-8");
//            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
//            Template freeTemplate = freemarkerConfiguration.getTemplate("products_to_categories.ftl");
//            List<LcProductsToCategoriesEntity> datas = productToCategoryRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据完成，耗时：{}",end-start);
//            int count = datas.size();
//            int rows = 1000;
//            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
//            List<LcProductsToCategoriesEntity> data = null;
//            for(int i = 0; i < loop; i ++) {
//                int startIndex = rows * i;
//                int endIndex = startIndex + rows;
//                if(endIndex > datas.size()) {
//                    endIndex = datas.size();
//                }
//                if(startIndex > datas.size()) {
//                    startIndex = datas.size() - 1;
//                }
//                if(endIndex == startIndex) {
//                    break;
//                }
//                data = datas.subList(startIndex,endIndex);
//                Map datasMap = new HashMap();
//                datasMap.put("datas",data);
//                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
//            }
//            long end5 = System.currentTimeMillis();
//            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//    }
}
