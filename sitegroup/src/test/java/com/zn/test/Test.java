package com.zn.test;

import com.zn.sitegroup.service.BuilderDockerComposeYmlService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zn on 2018/12/14.
 */
public class Test {
    public static void builderSql() {
        List list = new ArrayList<>();

        for(int i = 0;i < 33; i ++) {
            list.add(i);
        }
        StringBuffer root = new StringBuffer();
        StringBuffer buffer = null;
        int count = 0;
        int rows = 5;
        for(int i =0; i < list.size();i ++) {
            if(count <= rows) {
                if(count == 0) {
                    buffer = new StringBuffer("replace into:");
                }
                if (count == rows || i == list.size() -1) {
                    buffer.append(list.get(i));

                }
                if(i == list.size() -1) {
                    break;
                }
                if (count < rows) {
                    buffer.append(list.get(i) + ",");
                }
                count ++;
            } else {
                if(i < list.size() - 1) {
                    buffer.append("\nreplace into:");
                    buffer.append(list.get(i));
                    if(i < list.size() -1 ) {
                        buffer.append(",");
                    }
                    count = 1;
                }

            }
        }
        System.out.println(buffer);
    }
    public static void main(String ... args) {
        System.out.print("start....");
        BuilderDockerComposeYmlService service = new BuilderDockerComposeYmlService();
        String templateFolder = "D:\\project\\idea\\SiteGroupSystem\\sitegroup\\src\\main\\resources";
        String ftlFile = "docker-compose.ftl";
        String ymlFolder = "D:\\跨境电商\\站群-部署\\dep\\dep-server\\dep\\20190101\\";
        service.builder(templateFolder,ftlFile,ymlFolder,100);
       System.out.print("end....");
    }
}
