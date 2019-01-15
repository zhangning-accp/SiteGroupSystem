package com.zn.sitegroup.utils;

import com.zn.sitegroup.ApplicationConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by zn on 2018/12/15.
 *
 */
public class TemplateUtil {
    private static Configuration freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
    private static String sqlTemplatePath = ApplicationConfig.FTL_TEMPLATE_FOLDER;
    static {
        resetConfiguration();
    }
    private static void resetConfiguration() {
        try {
            if(!StringUtil.isBlank(sqlTemplatePath)) {
                freemarkerConfiguration.setDirectoryForTemplateLoading(new File(sqlTemplatePath));
                freemarkerConfiguration.setDefaultEncoding("UTF-8");
                freemarkerConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Template getTemplate(String templateFolder,String ftlFile) {
        if(!StringUtil.isBlank(templateFolder) && !sqlTemplatePath.equals(templateFolder)) {
            sqlTemplatePath = templateFolder;
            resetConfiguration();
        }
        try {
            return freemarkerConfiguration.getTemplate(ftlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
