package com.zn.sitegroup.servlet;

import com.zn.sitegroup.ApplicationConfig;
import com.zn.sitegroup.service.AssignService;
import com.zn.sitegroup.service.UploadFileService;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;

/**
 * Created by zn on 2018/12/22.
 */
@WebServlet(name = "TestServlet",urlPatterns = "/test.do")
@Slf4j
public class TestServlet extends HttpServlet {
    private String configFolder = "";
    private String logFolder = "";
    private AssignService createAssignDataSqlFileService;
    private ApplicationContext context;
    @Override
    public void init() throws ServletException {
        ServletContext application = this.getServletContext();
        String realPath = application.getRealPath("/");
        configFolder = realPath + "WEB-INF/classes/";
        logFolder = realPath;
        System.getProperties().setProperty("logFilesPath", logFolder);
        PropertyConfigurator.configure(configFolder + "log4j.properties");
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
        super.init();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UploadFileService uploadFileService = new UploadFileService();
//        ResponseBody responseText = uploadFileService.upload("http://localhost/AssginServer/service/service.php",
//                ApplicationConfig.SQL_FOLDER + ApplicationConfig.SQL_ZIP_FILE_NAME,
//                        ApplicationConfig.SQL_ZIP_FILE_NAME);
//
//        log.info("http://localhost/AssginServer/server.php response message:{}",responseText);
//        PrintWriter writer = response.getWriter();
//        writer.print(responseText.string());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
