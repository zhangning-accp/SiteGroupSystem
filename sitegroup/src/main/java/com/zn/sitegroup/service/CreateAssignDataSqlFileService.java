package com.zn.sitegroup.service;

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
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void createSqlFileByCategoryID(String categoryId) {
        // 找到当前分类下的所有商品(含子分类)


    }

    public void createSqlFileByProductID(String productId) {
        // 找到当前分类下的所有商品(含子分类)

    }

    /**
     *
     * @param parentId
     */
    public void createCategorySqlFileByParentCategroyId(int parentId,String categroiesSqlPath,String categoriesInfoSqlPath) {

    }

    /**
     * Test pass
     * 输出categies 表里的所有数据到指定的sql文件。
     * Test pass
     * @param sqlTemplatePath Freemarker file path. if null or whitespaces, default “sitegroup/sql_template”
     * @param sqlFilePath Out sql file path. if null or whitespaces, default categories.sql
     */
    public void createAllCategorySqlFile(String sqlTemplatePath,
                                         String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "categories.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("categories.ftl");
            log.info("开始获取info数据");
            List<LcCategoriesEntity> categoriesEntityList = categoryRepository.findAll();
            long end = System.currentTimeMillis();
            log.info("获取数据消耗：{}",end - start);
            long end1 = System.currentTimeMillis();
            log.info("整理数据消耗：{}",end1 - end);
            Map datas = new HashMap();
            datas.put("categories",categoriesEntityList);
            log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...",categoriesEntityList.size(),end1-end);
            end = System.currentTimeMillis();
            freeTemplate.process(datas,new FileWriter(new File(sqlFilePath)));
            end1 = System.currentTimeMillis();
            log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}",end1 - end);
            end = System.currentTimeMillis();
            log.info("消毁list完毕，耗时：{}",end - end1);

            long end5 = System.currentTimeMillis();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出categies_info 表里的所有数据到指定的sql文件。
     * Test pass
     * @param sqlTemplatePath Freemarker file path. if null or whitespaces, default “sitegroup/sql_template”
     * @param sqlFilePath Out sql file path. if null or whitespaces, default categories_info.sql
     */
    public void createAllCategoryInfoSqlFile(String sqlTemplatePath,
                                         String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "categories_info.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("categories_info.ftl");
            log.info("开始获取info数据");
            List<LcCategoriesInfoEntity> categoriesInfoEntityList = categoryInfoRepository.findAll();
            long end = System.currentTimeMillis();
            log.info("获取数据消耗：{}",end - start);
            long end1 = System.currentTimeMillis();
            log.info("整理数据消耗：{}",end1 - end);
            Map datas = new HashMap();
            datas.put("categoriesInfo",categoriesInfoEntityList);
            log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...",categoriesInfoEntityList.size(),end1-end);
            end = System.currentTimeMillis();
            freeTemplate.process(datas,new FileWriter(new File(sqlFilePath)));
            end1 = System.currentTimeMillis();
            log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}",end1 - end);
            end = System.currentTimeMillis();
            log.info("消毁list完毕，耗时：{}",end - end1);

            long end5 = System.currentTimeMillis();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出option_groups表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllOptionGroupsSqlFile(String sqlTemplatePath,
                                             String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "option_groups.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("option_groups.ftl");
            log.info("开始获取info数据");
            List<LcOptionGroupsEntity> optionGroupsEntityList = optionGroupRepository.findAll();
            if(optionGroupsEntityList.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datas = new HashMap();
                datas.put("optionGroups", optionGroupsEntityList);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", optionGroupsEntityList.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datas, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * Test pass
     * 输出option_groups表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllOptionGroupsInfoSqlFile(String sqlTemplatePath,
                                             String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "option_groups_info.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("option_groups_info.ftl");
            log.info("开始获取info数据");
            List<LcOptionGroupsInfoEntity> datas = optionGroupInfoRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map dataMap = new HashMap();
                dataMap.put("datas", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datas, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出option_values表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllOptionValuesSqlFile(String sqlTemplatePath,
                                                 String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "option_values.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("option_values.ftl");
            log.info("开始获取info数据");
            List<LcOptionValuesEntity> optionValuesEntityList = optionValueRepository.findAll();
            if(optionValuesEntityList.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datas = new HashMap();
                datas.put("optionValues", optionValuesEntityList);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", optionValuesEntityList.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datas, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出option_values_info表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllOptionValuesInfoSqlFile(String sqlTemplatePath,
                                             String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "option_values_info.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("option_values_info.ftl");
            log.info("开始获取info数据");
            List<LcOptionValuesInfoEntity> datas = optionValueInfoRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datasMap = new HashMap();
                datasMap.put("optionValuesInfo", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出product_groups表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllProductGroupsSqlFile(String sqlTemplatePath,
                                                 String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "product_groups.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups.ftl");
            log.info("开始获取info数据");
            List<LcProductGroupsEntity> datas = productGroupRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datasMap = new HashMap();
                datasMap.put("datas", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出product_groups_info表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllProductGroupsInfoSqlFile(String sqlTemplatePath,
                                              String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "product_groups_info.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups_info.ftl");
            log.info("开始获取info数据");
            List<LcProductGroupsInfoEntity> datas = productGroupInfoRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datasMap = new HashMap();
                datasMap.put("datas", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出product_groups_values表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllProductGroupsValuesSqlFile(String sqlTemplatePath,
                                                  String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "product_groups_values.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups_values.ftl");
            log.info("开始获取info数据");
            List<LcProductGroupsValuesEntity> datas = productGroupValueRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datasMap = new HashMap();
                datasMap.put("datas", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出product_groups_values表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllProductGroupsValuesInfoSqlFile(String sqlTemplatePath,
                                                    String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "product_groups_values_info.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("product_groups_values_info.ftl");
            log.info("开始获取info数据");
            List<LcProductGroupsValuesInfoEntity> datas = productGroupValueInfoRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datasMap = new HashMap();
                datasMap.put("datas", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * Test pass
     * 输出product_option_trees表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllProductOptionTreesInfoSqlFile(String sqlTemplatePath,String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "product_option_trees.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("product_option_trees.ftl");
            log.info("开始获取info数据");
            List<LcProductOptionTreesEntity> datas = productOptionTreeRepository.findAll();
            if(datas.size() > 0) {
                long end = System.currentTimeMillis();
                log.info("获取数据消耗：{}", end - start);
                long end1 = System.currentTimeMillis();
                log.info("整理数据消耗：{}", end1 - end);
                Map datasMap = new HashMap();
                datasMap.put("datas", datas);
                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...", datas.size(), end1 - end);
                end = System.currentTimeMillis();
                freeTemplate.process(datasMap, new FileWriter(new File(sqlFilePath)));
                end1 = System.currentTimeMillis();
                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}", end1 - end);
                end = System.currentTimeMillis();
                log.info("消毁list完毕，耗时：{}", end - end1);

                long end5 = System.currentTimeMillis();
                System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test pass
     * 输出products表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     */
    public void createAllProductsSqlFile(String sqlTemplatePath,String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "products.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("products.ftl");
            List<LcProductsEntity> datas = productRepository.findAll();
            int count = datas.size();
            int rows = 1000;
            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
            List<LcProductsEntity> data = null;
            for(int i = 0; i < loop; i ++) {
                int startIndex = rows * i;
                int endIndex = startIndex + rows;
                if(endIndex > datas.size()) {
                    endIndex = datas.size();
                }
                if(startIndex > datas.size()) {
                    startIndex = datas.size() - 1;
                }
                if(endIndex == startIndex) {
                    break;
                }
                data = datas.subList(startIndex,endIndex);
                Map datasMap = new HashMap();
                datasMap.put("datas",data);
                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
            }
            long end5 = System.currentTimeMillis();
//            datas.clear();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * Test pass
     * 输出products_info表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     * 该方法会将数据拆分成每份1000.
     */
    public void createAllProductsInfoSqlFile(String sqlTemplatePath,String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "products_info.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("products_info.ftl");
            List<LcProductsInfoEntity> datas = productInfoRepository.findAll();
            datas = datas.stream().map(p->{
                String name = StringUtil.escapeSingleQuotes(p.getName());
                String shortDescription = StringUtil.escapeSingleQuotes(p.getShortDescription());
                String description = StringUtil.escapeSingleQuotes(p.getDescription());
                String headTitle = StringUtil.escapeSingleQuotes(p.getHeadTitle());
                String metaDescription = StringUtil.escapeSingleQuotes(p.getMetaDescription());
                String attributes = StringUtil.escapeSingleQuotes(p.getAttributes());
                p.setName(name);
                p.setShortDescription(shortDescription);
                p.setDescription(description);
                p.setHeadTitle(headTitle);
                p.setMetaDescription(metaDescription);
                p.setAttributes(attributes);
                return p;
            }).collect(Collectors.toList());
            int count = datas.size();
            int rows = 1000;
            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
            List<LcProductsInfoEntity> data = null;
            for(int i = 0; i < loop; i ++) {
                int startIndex = rows * i;
                int endIndex = startIndex + rows;
                if(endIndex > datas.size()) {
                    endIndex = datas.size();
                }
                if(startIndex > datas.size()) {
                    startIndex = datas.size() - 1;
                }
                if(endIndex == startIndex) {
                    break;
                }
                data = datas.subList(startIndex,endIndex);
                Map datasMap = new HashMap();
                datasMap.put("datas",data);
                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
            }
            long end5 = System.currentTimeMillis();
            datas.clear();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * Test pass
     * 输出products_campaigns表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     * 该方法会将数据拆分成每份1000.
     */
    public void createAllProductsCampaignsSqlFile(String sqlTemplatePath,String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "products_campaigns.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("products_campaigns.ftl");
            List<LcProductsCampaignsEntity> datas = productCampaignRepository.findAll();
            int count = datas.size();
            int rows = 1000;
            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
            List<LcProductsCampaignsEntity> data = null;
            for(int i = 0; i < loop; i ++) {
                int startIndex = rows * i;
                int endIndex = startIndex + rows;
                if(endIndex > datas.size()) {
                    endIndex = datas.size();
                }
                if(startIndex > datas.size()) {
                    startIndex = datas.size() - 1;
                }
                if(endIndex == startIndex) {
                    break;
                }
                data = datas.subList(startIndex,endIndex);
                Map datasMap = new HashMap();
                datasMap.put("datas",data);
                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
            }
            long end5 = System.currentTimeMillis();
//            datas.clear();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    /**
     * Test pass
     * 输出products_images表里的所有数据到sql文件
     * @param sqlTemplatePath
     * @param sqlFilePath
     * 该方法会将数据拆分成每份1000.
     */
    public void createAllProductsImagesSqlFile(String sqlTemplatePath,String sqlFilePath) {
        if(StringUtil.isBlank(sqlTemplatePath)) {
            sqlTemplatePath = "sitegroup/sql_template";
        }
        if(StringUtil.isBlank(sqlFilePath)) {
            sqlFilePath = "products_images.sql";
        }
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("products_images.ftl");
            List<LcProductsImagesEntity> datas = productImageRepository.findAll();
            int count = datas.size();
            int rows = 1000;
            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
            List<LcProductsImagesEntity> data = null;
            for(int i = 0; i < loop; i ++) {
                int startIndex = rows * i;
                int endIndex = startIndex + rows;
                if(endIndex > datas.size()) {
                    endIndex = datas.size();
                }
                if(startIndex > datas.size()) {
                    startIndex = datas.size() - 1;
                }
                if(endIndex == startIndex) {
                    break;
                }
                data = datas.subList(startIndex,endIndex);
                Map datasMap = new HashMap();
                datasMap.put("datas",data);
                freeTemplate.process(datasMap,new FileWriter(new File(sqlFilePath),true));
            }
            long end5 = System.currentTimeMillis();
//            datas.clear();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

}
