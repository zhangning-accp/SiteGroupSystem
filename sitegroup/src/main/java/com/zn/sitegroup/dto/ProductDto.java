package com.zn.sitegroup.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by zn on 2019/1/15.
 * 产品信息dto类，包含了产品的基础信息。
 */
@Data
public class ProductDto {
    private int productId;
    private byte status;
    private int manufacturerId;
    private int supplierId;
    private int deliveryStatusId;
    private int soldOutStatusId;
    private int defaultCategoryId;
    private String productGroups;
    private String keywords;
    private String code;
    private String sku;
    private String mpn;
    private String upc;
    private String gtin;
    private String taric;
    private BigDecimal quantity;
    private int quantityUnitId;
    private BigDecimal weight;
    private String weightClass;
    private BigDecimal dimX;
    private BigDecimal dimY;
    private BigDecimal dimZ;
    private String dimClass;
    private BigDecimal purchasePrice;
    private String purchasePriceCurrencyCode;
    private int taxClassId;
    private String image;
    private int views;
    private int purchases;
    private Date dateValidFrom;
    private Date dateValidTo;
    private Timestamp dateUpdated;
    private Timestamp dateCreated;

    private int productInfoId;
    private String languageCode;
    private String name;
    private String shortDescription;
    private String description;
    private String headTitle;
    private String metaDescription;
    private String attributes;

}
