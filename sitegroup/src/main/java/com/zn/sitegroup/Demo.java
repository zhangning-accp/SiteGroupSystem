package com.zn.sitegroup;

import com.zn.sitegroup.entity.LcCategoriesEntity;
import com.zn.sitegroup.entity.LcProductsEntity;
import com.zn.sitegroup.entity.LcProductsInfoEntity;
import com.zn.sitegroup.repository.ICategoryInfoRepository;
import com.zn.sitegroup.repository.ICategoryRepository;
import com.zn.sitegroup.repository.IProductInfoRepository;
import com.zn.sitegroup.repository.IProductRepository;
import com.zn.sitegroup.service.CreateAssignDataSqlFileService;
import com.zn.sitegroup.service.ProductService;
import com.zn.sitegroup.utils.StringUtil;
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
import java.util.Scanner;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by zn on 2018/12/13.
 */
@Slf4j

public class Demo {
    @Autowired
    Bean bean;
    @Autowired
    IProductInfoRepository productInfoRepository;
    @Autowired
    ICategoryInfoRepository categoryInfoRepository;
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    CreateAssignDataSqlFileService createAssignDataSqlFileService;
    public void outSqlByBeetl() {
        long start = System.currentTimeMillis();
        try {

            FileResourceLoader resourceLoader = new FileResourceLoader("sitegroup/sql_template","utf-8");
            org.beetl.core.Configuration cfg = org.beetl.core.Configuration.defaultConfiguration();
            GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
            org.beetl.core.Template template = gt.getTemplate("beetl_sql.bl");

            log.info("开始获取info数据");
            List<LcProductsInfoEntity> productsinfo = productInfoRepository.findAll();
            productsinfo = productsinfo.stream().map(p->{
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

            Map datas = new HashMap();
            datas.put("productsInfo",productsinfo);
            log.info("info数据获取完毕，开始输出成sql文件...");
            template.binding(datas);
            template.renderTo(new FileWriter(new File("D://sql-test/beetl_test.sql")));
            long end = System.currentTimeMillis();
            System.out.print("----------- 耗时: " + (end - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 这个效率更高
    public void outGreatSqlByFreeMarkerGreat() {
        long start = System.currentTimeMillis();
        Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            freemarkerConfiguration.setDirectoryForTemplateLoading(new File("sitegroup/sql_template"));
            freemarkerConfiguration.setDefaultEncoding("UTF-8");
            freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            Template freeTemplate = freemarkerConfiguration.getTemplate("free_sql.ftl");
//            log.info("开始获取info数据");
            List<LcProductsInfoEntity> productsinfo = productInfoRepository.findAll();
//            long end = System.currentTimeMillis();
//            log.info("获取数据消耗：{}",end - start);
            productsinfo = productsinfo.stream().map(p->{
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
//            long end1 = System.currentTimeMillis();
//            log.info("整理数据消耗：{}",end1 - end);
            int count = productsinfo.size();
            int rows = 1000;
            int loop = count % rows == 0 ? count/rows : (count/rows) + 1;
            List<LcProductsInfoEntity> data = null;
            for(int i = 0; i < loop; i ++) {
                int startIndex = rows * i;
                int endIndex = startIndex + rows;
                if(endIndex > productsinfo.size()) {
                    endIndex = productsinfo.size();
                }
                if(startIndex > productsinfo.size()) {
                    startIndex = productsinfo.size() - 1;
                }
                if(endIndex == startIndex) {
                    break;
                }
                data = productsinfo.subList(startIndex,endIndex);
                Map datas = new HashMap();
                datas.put("productsInfo",data);
//                end = System.currentTimeMillis();
//                log.info("data数据获取完毕，size:{},耗时：{}开始输出成sql文件...",data.size(),end-end1);
//                end = System.currentTimeMillis();
                freeTemplate.process(datas,new FileWriter(new File("D:/sql-test/test.sql"),true));
//                end1 = System.currentTimeMillis();
//                log.info("输出完毕，开始销毁对象....,之前输出到文件耗时：{}",end1 - end);
            }
            long end5 = System.currentTimeMillis();
            productsinfo.clear();
            System.out.print("----------- 耗时: " + (end5 - start) + " 毫秒---------------");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public void outCategoriesSQL() {
//      createAssignDataSqlFileService.createAllCategorySqlFile(null,"D:/sql-test/categories.sql");
//      createAssignDataSqlFileService.createAllCategoryInfoSqlFile(null,"D:/sql-test/categories_info.sql");
//        createAssignDataSqlFileService.createAllOptionGroupsSqlFile(null,"D:/sql-test/option_groups.sql");
//        createAssignDataSqlFileService.createAllOptionGroupsInfoSqlFile(null,"D:/sql-test/option_groups_info.sql");
//        createAssignDataSqlFileService.createAllOptionValuesSqlFile(null,"d:/sql-test/option_values.sql");
//        createAssignDataSqlFileService.createAllOptionValuesInfoSqlFile(null,"d:/sql-test/option_values_info.sql");
//        createAssignDataSqlFileService.createAllProductGroupsSqlFile(null,"d:/sql-test/product_groups.sql");
//            createAssignDataSqlFileService.createAllProductGroupsInfoSqlFile(null,"d:/sql-test/product_groups_info.sql");
//        createAssignDataSqlFileService.createAllProductGroupsValuesSqlFile(null,"d:/sql-test/product_groups_values.sql");
//        createAssignDataSqlFileService.createAllProductGroupsValuesInfoSqlFile(null,"d:/sql-test/product_groups_values_info.sql");
//        createAssignDataSqlFileService.createAllProductOptionTreesInfoSqlFile(null,"d:/sql-test/product_option_trees.sql");
//        createAssignDataSqlFileService.createAllProductsSqlFile(null,"d:/sql-test/products.sql");
//        createAssignDataSqlFileService.createAllProductsInfoSqlFile(null,"d:/sql-test/products_info.sql");
//        createAssignDataSqlFileService.createAllProductsCampaignsSqlFile(null,"d:/sql-test/products_campaigns.sql");
        createAssignDataSqlFileService.createAllProductsImagesSqlFile(null,"d:/sql-test/products_images.sql");

    }



    public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Demo demo = (Demo)context.getBean("demo");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入任意字符开始");
//        if(scanner.next() != null) {
//            demo.outGreatSqlByFreeMarkerGreat();
//        }
            demo.outCategoriesSQL();
    }
}
