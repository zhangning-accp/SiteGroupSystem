package com.zn.sitegroup.utils;

import java.lang.reflect.Field;

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
       value = value.replaceAll("\\\\'","'");
       value = value.replaceAll("'","\\\\'");
       return value;
    }

    /**
     * 处理对象里所有字符串属性的值。把但引号转义为\'。
     * @param obj 将原对象返回，实际方法已经将元对象的数据进行了修改，所以不接收返回，元对象也是被改变了的。
     * 该方法会使用反射遍历对象所有属性，如果明确要修改的是字符串，请使用public static String escapeSingleQuotes(String value)方法。
     */
    public static Object escapeSingleQuotes(Object obj) {
        Class clazz = obj.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            String type = field.getType().getName();
            if(type.equals("java.lang.String")) {
                field.setAccessible(true);
                try {
//                    String oldValue = field.get(obj).toString();
                    String oldValue = field.get(obj) != null ? field.get(obj).toString() : "";
                    String newValue = oldValue.replaceAll("\\\\'","'");
                    newValue = newValue.replaceAll("'","\\\\'");
                    field.set(obj,newValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }
        return obj;
    }
}
