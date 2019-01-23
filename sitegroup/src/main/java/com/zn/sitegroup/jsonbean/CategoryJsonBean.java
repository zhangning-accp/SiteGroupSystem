package com.zn.sitegroup.jsonbean;

import java.util.List;
import lombok.Data;
import lombok.ToString;

/**
 * Created by zn on 2019/1/20.
 */
@Data
@ToString
public class CategoryJsonBean {
    private String text;
    private long id;
    private long parentId;
//    boolean isChildren;
//    private List<CategoryJsonBean> childrens;
}
