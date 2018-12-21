package com.zn.sitegroup.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zn on 2018/12/19.
 * Process system command util
 */
public class CommandUtil {
    /**
     * Not test
     *
     * @param commandStr
     * @return
     */
    public static String execute(String commandStr) {
        Runtime runtime = Runtime.getRuntime();
        String [] cmdarray = {commandStr};
        Process process = null;
        BufferedReader br = null;
        if(StringUtil.isBlank(commandStr)) {
            return "command is null or empty";
        }
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if(os.startsWith("win")) {
                // cmd之后执行数组的第一个条件进入数据库
                process = runtime.exec("cmd /c " + cmdarray[0]);
            } else {
               process = runtime.exec(cmdarray[0]);
            }
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
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
        return null;
    }
}
