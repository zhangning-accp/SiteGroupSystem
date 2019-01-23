package com.zn.sitegroup.jsonbean;

import java.util.List;
import lombok.Data;

/**
 * Created by zn on 2019/1/21.
 */
@Data
public class OptionGroupJsonBean {
    private long groupId;
    private String groupName;
    private long valueId;
    private String valueName;
    private String valueAlias;
    private String links;
    private List<OptionGroupJsonBean> children;
}
