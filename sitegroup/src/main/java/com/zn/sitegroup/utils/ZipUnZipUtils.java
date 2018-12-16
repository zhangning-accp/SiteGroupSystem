package com.zn.sitegroup.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import jodd.util.StringUtil;

/**
 * Created by zn on 2018/12/15.
 */
public class ZipUnZipUtils {

    /**
     * 将多文件压缩到一个zip文件里
     * @param descFile
     * @param srcFile  需要压缩的文件
     */
    public static void zip(String descFile, String... srcFile) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(descFile));) {
            for (String file : srcFile) {
                File src = new File(file);
                String fileName = file.substring(file.lastIndexOf(File.separator) + 1);
                zipOutputStream.putNextEntry(new ZipEntry(fileName));
                try (FileInputStream inputStream = new FileInputStream(src);) {
                    byte[] data = new byte[(int)src.length()];
                    while (inputStream.read(data) != -1) {
                        zipOutputStream.write(data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 未实现
     * @param descFile
     * @param zipFile
     */
    public static void unZip(String descFile, String zipFile) {

    }
}
