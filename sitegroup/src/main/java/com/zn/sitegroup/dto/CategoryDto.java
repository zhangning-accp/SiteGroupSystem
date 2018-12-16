package com.zn.sitegroup.dto;

import com.zn.sitegroup.entity.LcCategoriesEntity;
import com.zn.sitegroup.entity.LcCategoriesInfoEntity;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 * Created by zn on 2018/12/16.
 */
@Data
public class CategoryDto {
    private int categoryId;
    private int parentId;
    private int googleTaxonomyId;
    private byte status;
    private String code;
    private String listStyle;
    private String dock;
    private String keywords;
    private String image;
    private byte priority;
    private Date dateUpdated;
    private Date dateCreated;

    private int categoryInfoId;
    private String languageCode;
    private String name;
    private String shortDescription;
    private String description;
    private String headTitle;
    private String h1Title;
    private String metaDescription;

}
