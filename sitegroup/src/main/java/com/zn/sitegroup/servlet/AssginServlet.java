package com.zn.sitegroup.servlet;

import com.zn.sitegroup.ApplicationConfig;
import com.zn.sitegroup.dto.AssginDto;
import com.zn.sitegroup.entity.DcAssginEntity;
import com.zn.sitegroup.entity.DcRulesEntity;
import com.zn.sitegroup.service.AssignService;
import com.zn.sitegroup.service.UploadFileService;
import com.zn.sitegroup.utils.SequenceUtil;
import com.zn.sitegroup.utils.StringUtil;
import com.zn.sitegroup.utils.ZipUnZipUtils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zn on 2018/12/20.
 */
@WebServlet(name = "assgin",urlPatterns = "/assgin.do")
@Slf4j
public class AssginServlet extends HttpServlet {
    private String configFolder = "";
    private String logFolder = "";
    private String [] siteIps = null;
    private String siteAssginServiceUrl = "";
    private AssignService assignService;
    private ApplicationContext context;
    @Override
    public void init() throws ServletException {
        ServletContext application = this.getServletContext();
        String realPath = application.getRealPath("/");
        configFolder = realPath + "WEB-INF/classes/";
        logFolder = realPath;
        System.getProperties().setProperty("logFilesPath", logFolder);
        PropertyConfigurator.configure(configFolder + "log4j.properties");
        String applicationPath = "/" + configFolder + "applicationContext.xml";
        log.info("realPath:{},configFolder:{},logFolder:{},applicationPath:{}",
                realPath,configFolder,logFolder,applicationPath);
        context = new FileSystemXmlApplicationContext(applicationPath);
        assignService = (AssignService)context.getBean("assignService");
        ApplicationConfig.FTL_TEMPLATE_FOLDER = realPath + "WEB-INF/sql_template/";
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(configFolder+"site_group.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ApplicationConfig.SQL_FOLDER = properties.getProperty("sql.folder");
//        ApplicationConfig.SQL_FILE_NAME = properties.getProperty("sql.fileName");
        ApplicationConfig.SQL_ZIP_FOLDER = properties.getProperty("sql.zip.folder");
//        ApplicationConfig.SQL_ZIP_FILE_NAME = properties.getProperty("sql.zip.fileName");
//        siteIps = properties.getProperty("site.ip").split("|");
        siteAssginServiceUrl = properties.getProperty("site.assgin.service.url");
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        //1 拿到以下数据:规则id，分发站点的数据，目录数据，时间数据
        String ruleId = null;
        String websites = null;
        String categories = null;
        Date from = null;
        Date to = null;
        String fileName = null;
        String [] siteIps = request.getParameter("site_ips").toString().split("\r\n");
            //TODO: 1. 需要解决多站点多文件的问题。 2. 采用多线程
//            String sqlFile = ApplicationConfig.SQL_FOLDER + ApplicationConfig.SQL_FILE_NAME;
//            String zipFile = ApplicationConfig.SQL_ZIP_FOLDER + ApplicationConfig.SQL_ZIP_FILE_NAME;
//            String tmpIp = "site_assgin";
//            ApplicationConfig.SQL_FILE_NAME = tmpIp + ".sql";
//            ApplicationConfig.SQL_ZIP_FILE_NAME = tmpIp + ".zip";
        String localSql = request.getParameter("isNoReaderDB");
        long end = System.currentTimeMillis();
        long start = System.currentTimeMillis();
            String sqlFile = ApplicationConfig.SQL_FOLDER + fileName;
            String zipFile = ApplicationConfig.SQL_ZIP_FOLDER + fileName + ".zip";
            if(localSql.equals("1")) {
                // 使用本地sql.zip
                log.info("本次操作是读取本地sql zip文件到子站");
                zipFile = request.getParameter("sql_zip_file");
            } else if(localSql.equals("0")) {
                File file = new File(sqlFile);
                file.delete();
                file = new File(zipFile);
                file.delete();
                log.info("收到请求，开始导出数据.... sqlFile:{},zipFile:{}",sqlFile,zipFile);
                start = System.currentTimeMillis();
                // 构建AssginDto对象
                AssginDto assginDto = new AssginDto();
                //1. 根据id查询rule
                DcRulesEntity rulesEntity = assignService.getAssginEntity(Long.parseLong(ruleId));
                //2. 构建assgin对象并入库
                DcAssginEntity assginEntity = new DcAssginEntity();
                assginEntity.setId(SequenceUtil.sequence());
                assginEntity.setCategories(categories);
                assginEntity.setDateCreated(new Date());
                assginEntity.setDateUpdated(new Date());
                assginEntity.setDateFrom(from);
                assginEntity.setDateTo(to);
                assginEntity.setFileName(fileName);
                assginEntity.setSites(websites);
                assignService.saveAssgin(assginEntity);

                assginDto.setAssginEntity(assginEntity);
                assginDto.setRulesEntity(rulesEntity);

                assignService.createSqlFile(assginDto);
                log.info("sql文件全部生成完毕..,开始压缩{}", sqlFile);
                end = System.currentTimeMillis();
                ZipUnZipUtils.zip(zipFile, sqlFile);
                log.info("sql文件压缩完毕，耗时:{}秒,zip文件;{}", (end - start) / 1000.0, zipFile);
                end = System.currentTimeMillis();
                message = "数据导出完毕，耗时" + ((end - start) / 1000) + "秒</br>";
                log.info("数据导出完毕，耗时:{}秒,开始上传数据到子站，等待执行入库操作", (end - start) / 1000.0);
            }
        for (String siteIp : siteIps) {
            String info = siteIp;
            String [] infos = siteIp.split("-");
            siteIp = infos[0];
            end = System.currentTimeMillis();
            log.info("上传{}数据到{}",zipFile,siteIp);
            String siteAssginServiceUrl = "";
            if(siteIp.startsWith("http")) {
                siteAssginServiceUrl = siteIp + this.siteAssginServiceUrl;
            } else {
                siteAssginServiceUrl ="http://" + siteIp + this.siteAssginServiceUrl;
            }
            UploadFileService uploadFileService = new UploadFileService();
            ResponseBody responseBody = uploadFileService.upload(siteAssginServiceUrl,
                    zipFile, zipFile,infos[1],infos[2]);
            start = System.currentTimeMillis();
            String responseText = responseBody.string();
            log.info("入库完毕，耗时:{}秒，子站{}返回的信息：{}", (start - end) / 1000.0, siteIp,responseText);
            message += "入库完毕，耗时" + (start - end) / 1000.0 + "秒" + ",子站" + siteIp + "返回的信息" + responseText;
        }
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect("/sitegroup/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }


}
