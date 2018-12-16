package com.zn.sitegroup.utils;

/**
 * Created by zn on 2018/12/16.
 */
public class StringUtil extends jodd.util.StringUtil {

    /**
     * 转义单引号为 \'
     * @param value
     * @return
     */
    public static String escapeSingleQuotes(String value) {
        value = value.replaceAll("'","\\\\'");
        return value;
    }
}
