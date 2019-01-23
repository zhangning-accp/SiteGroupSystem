package com.zn.sitegroup.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zn on 2019/1/22.
 */
@WebFilter(filterName = "ConfigFilter")
@Slf4j
public class ConfingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext application = config.getServletContext();
        String realPath = application.getRealPath("/");
        String configFolder = realPath + "WEB-INF/classes/";

        String logFolder = realPath;
        System.getProperties().setProperty("logFilesPath", logFolder);
        PropertyConfigurator.configure(configFolder + "log4j.properties");
        String applicationPath = "/" + configFolder + "applicationContext.xml";
        log.info("realPath:{},configFolder:{},logFolder:{},applicationPath:{}",
                realPath,configFolder,logFolder,applicationPath);

        application.setAttribute("applicationPath",applicationPath);
        application.setAttribute("configFolder",configFolder);
        application.setAttribute("realPath",realPath);
    }

}
