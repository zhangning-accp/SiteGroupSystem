package com.zn.sitegroup.dto;

import com.zn.sitegroup.entity.LcProductGroupsEntity;
import com.zn.sitegroup.entity.LcProductGroupsInfoEntity;
import com.zn.sitegroup.entity.LcProductGroupsValuesEntity;
import com.zn.sitegroup.entity.LcProductGroupsValuesInfoEntity;
import com.zn.sitegroup.entity.LcProductsOptionsEntity;
import java.util.List;
import lombok.Data;

/**
 * Created by zn on 2019/1/24.
 */
@Data
public class ProductGroupDto {
    private long id;
    private String name;
    private List<ProductGroupDto> values;

}
