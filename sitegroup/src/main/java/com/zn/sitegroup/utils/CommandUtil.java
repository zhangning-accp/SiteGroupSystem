package com.zn.sitegroup.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;

/**
 * Created by zn on 2018/12/19.
 * Process system command util
 */
@Slf4j
public class CommandUtil {
    /**
     * Not test
     *
     * @param commandStr
     * @return
     */
    public static String execute(String commandStr){
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
               process = runtime.exec(new String[]{"/bin/sh","-c",cmdarray[0]});
            }
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            int exitCode = process.waitFor();
            sb.append("exitCode:"+exitCode);
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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


    private String callCmd(String cmd) throws InterruptedException {
        if(SystemUtils.IS_OS_LINUX) {
            try {
                // 使用Runtime来执行command，生成Process对象
                Process process = Runtime.getRuntime().exec(
                        new String[]{"/bin/sh", "-c", cmd});
                int exitCode = process.waitFor();
                // 取得命令结果的输出流
                InputStream is = process.getInputStream();
                // 用一个读输出流类去读
                InputStreamReader isr = new InputStreamReader(is);
                // 用缓冲器读行
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    sb.append(line);
                }
                is.close();
                isr.close();
                br.close();
                return sb.toString();
            } catch (java.lang.NullPointerException e) {
                log.error(cmd, e);
            } catch (java.io.IOException e) {
                System.err.println("IOException " + e.getMessage());
            }
        }
        if(SystemUtils.IS_OS_WINDOWS){
            Process process;
            try {
                String[] param_array = cmd.split("[\\s]+");
                ProcessBuilder pb = new ProcessBuilder(param_array);
                process = pb.start();
                int exitCode = process.waitFor();
                InputStream is = process.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    sb.append(line);
                }
                is.close();
                isr.close();
                br.close();
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
