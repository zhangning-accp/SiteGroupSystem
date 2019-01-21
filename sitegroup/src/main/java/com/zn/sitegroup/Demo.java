package com.zn.sitegroup;

import com.zn.sitegroup.entity.LcProductsInfoEntity;
import com.zn.sitegroup.repository.ICategoryInfoRepository;
import com.zn.sitegroup.repository.ICategoryRepository;
import com.zn.sitegroup.repository.IProductInfoRepository;
import com.zn.sitegroup.service.AssignService;
import com.zn.sitegroup.utils.StringUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    AssignService createAssignDataSqlFileService;

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
                return (LcProductsInfoEntity)StringUtil.escapeSingleQuotes(p);
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

    public void outSQL() {
        String sqlFile = "d:/sql-test/assgin_product.sql";
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
//        createAssignDataSqlFileService.createAllProductsImagesSqlFile(null,"d:/sql-test/products_images.sql");
//            createAssignDataSqlFileService.createAllProductsOptionsSqlFile(null,"d:/sql-test/products_options.sql");
//        createAssignDataSqlFileService.createAllProductsOptionsStockSqlFile(null,"d:/sql-test/products_options_stock.sql");
//        createAssignDataSqlFileService.createAllProductsPricesSqlFile(null,"d:/sql-test/products_prices.sql");
//        createAssignDataSqlFileService.createAllProductsToCategoriesSqlFile(null,"d:/sql-test/products_to_categories.sql");

        long start = System.currentTimeMillis();
//        createAssignDataSqlFileService.createAllCategorySqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllCategoryInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllOptionGroupsSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllOptionGroupsInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllOptionValuesSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllOptionValuesInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductGroupsSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductGroupsInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductGroupsValuesSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductGroupsValuesInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductOptionTreesInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsInfoSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsCampaignsSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsImagesSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsOptionsSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsOptionsStockSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsPricesSqlFile(null,sqlFile);
//        createAssignDataSqlFileService.createAllProductsToCategoriesSqlFile(null,sqlFile);
        long end = System.currentTimeMillis();
        log.info("生成sql文件总耗时:{}分钟",(end-start)/(1000*60.0));
        log.info("开始执行导入sql....");
        Runtime runtime = Runtime.getRuntime();
        String cmdarray[] = { "mysql -uroot litecart_no_data<d:/sql-test/assgin_product.sql"};
        Process process = null;
        BufferedReader br = null;
        try {
            process = runtime.exec("cmd /c " + cmdarray[0]);// cmd之后执行数组的第一个条件进入数据库

            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
            long end1 = System.currentTimeMillis();
            log.info("sql执行结束，耗时{}",end - end);
            log.info("全部总耗时:{}分钟",((end1 - start)/1000)/60.0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            process.destroy();
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    void test() {
//        List list = cate.findChildParentsByChildId(311);
//        log.info("size:{}",list);
        String os = System.getProperty("os.name");
        System.out.println(os);
//        createAssignDataSqlFileService.createSqlFileByCategoryID(0);
//        File file = new File("d:/sql-test/desc/");
//        File [] files = file.listFiles();
//        String [] fileStr = new String[files.length];
//        for(int i = 0; i < files.length; i ++) {
//            File f = files[i];
//            fileStr[i] = f.getAbsolutePath();
//        }
//        ZipUnZipUtils.zip("d:/sql-test/desc/sql.zip",fileStr);
    }

    public static void main(String [] args) {
        long start = System.currentTimeMillis();
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Demo demo = (Demo)context.getBean("demo");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("输入任意字符开始");
//        if(scanner.next() != null) {
//            demo.outGreatSqlByFreeMarkerGreat();
//        }

            demo.test();
            long end = System.currentTimeMillis();
            log.info("总耗时:{}秒",(end - start)/1000);
    }
}
