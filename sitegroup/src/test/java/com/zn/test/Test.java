package com.zn.test;

import com.zn.sitegroup.utils.SequenceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

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


        final long total = 0;
        System.out.print("start....");
//        BuilderDockerComposeYmlService service = new BuilderDockerComposeYmlService();
//        String templateFolder = "D:\\project\\idea\\SiteGroupSystem\\sitegroup\\src\\main\\resources";
//        String ftlFile = "docker-compose.ftl";
//        String ymlFolder = "D:\\跨境电商\\站群-部署\\dep\\dep-server\\dep\\20190101\\";
//        service.builder(templateFolder,ftlFile,ymlFolder,100);
        Set<Long> set = new ConcurrentSkipListSet();
        Map<String,Long> map = new ConcurrentHashMap<>();
        map.put("total",0l);
        for(int i = 0; i < 100; i ++) {
            Thread thread = new Thread(){
                public void run() {
                    long start = System.currentTimeMillis();
                    for(int i = 0; i < 300000; i ++) {
                        long id = SequenceUtil.sequence();
                        if(set.contains(id)) {
                            System.out.println("id" + id + " 在" + i + "次重复");
                            break;
                        }else {
                            set.add(id);
                        }
                    }
                    long end = System.currentTimeMillis();
                    map.put("total",(end - start));
                    System.out.println(this.getName() + "运行完成，size:" + set.size()
                            + "耗时：" + (end - start) + "ms,总耗时:" + map.get("total"));
                }
            };
            thread.start();
        }
//       System.out.print("end.... 耗时:" + (total) + " ms,set.size():" + set.size());
    }
}
