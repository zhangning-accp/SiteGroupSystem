package com.zn.sitegroup.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zn.sitegroup.jsonbean.CategoryJsonBean;
import java.io.IOException;
import java.util.List;

/**
 * Created by zn on 2019/1/21.
 */
public class JsonUtil {
    public static <T> T getArrayByJsonString(String jsonString, TypeReference<?> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
