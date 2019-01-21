package com.zn.sitegroup.jsonbean;

import java.util.List;
import lombok.Data;

/**
 * Created by zn on 2019/1/21.
 */
@Data
public class ProductGroupJsonBean {
    private String name;
    private long id;
    private List<ProductGroupJsonBean> values;
}
