package com.zn.sitegroup.service;

import com.zn.sitegroup.utils.TemplateUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 创建docker-compose.yml文件
 * Created by zn on 2018/12/31.
 */
@Slf4j
public class BuilderDockerComposeYmlService {
    public void builder(String templateFolder,String ftlFile,
                        String ymlFileFolder,int number) {
        Template template = TemplateUtil.getTemplate(templateFolder,ftlFile);
        int httpPortStart = 30001;// http端口开始号
        int dbPortStart = 50001;// msyql 端口开始号
        String dataPath = "/root/data/site-";
        String ymlFileName = "/docker-compose-";
        FileWriter writer = null;
        File file = new File(ymlFileFolder);
        if(!file.exists()){
            file.mkdirs();
        }
        for(int i = 1; i <= number; i ++) {
            try {
                writer = new FileWriter(ymlFileFolder + ymlFileName + i + ".yml");
                Map<String,String> datas = new HashMap();
                datas.put("httpPort",httpPortStart + "");
                datas.put("dataPath",dataPath + i);
                datas.put("dbPort",dbPortStart + "");
                httpPortStart ++;
                dbPortStart ++;
                template.process(datas,writer);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            } finally {
                if(writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
