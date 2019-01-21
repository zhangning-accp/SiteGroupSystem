package com.zn.sitegroup.dto;

import com.zn.sitegroup.entity.DcAssginEntity;
import com.zn.sitegroup.entity.DcRulesEntity;
import lombok.Data;

/**
 * Created by zn on 2019/1/19.
 * 分发时的数据对象
 */
@Data
public class AssginDto {
    private DcAssginEntity assginEntity;
    private DcRulesEntity rulesEntity;
}
