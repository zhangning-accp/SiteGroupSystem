package com.zn.sitegroup.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zn on 2018/12/13.
 */
@Entity
@Table(name = "lc_products", schema = "litecart", catalog = "")
public class LcProductsEntity {
    private long id;
    private byte status;
    private long manufacturerId;
    private long supplierId;
    private long deliveryStatusId;
    private long soldOutStatusId;
    private long defaultCategoryId;
    private String productGroups;
    private String keywords;
    private String code;
    private String sku;
    private String mpn;
    private String upc;
    private String gtin;
    private String taric;
    private BigDecimal quantity;
    private long quantityUnitId;
    private BigDecimal weight;
    private String weightClass;
    private BigDecimal dimX;
    private BigDecimal dimY;
    private BigDecimal dimZ;
    private String dimClass;
    private BigDecimal purchasePrice;
    private String purchasePriceCurrencyCode;
    private long taxClassId;
    private String image;
    private long views;
    private long purchases;
    private Date dateValidFrom;
    private Date dateValidTo;
    private Timestamp dateUpdated;
    private Timestamp dateCreated;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "manufacturer_id")
    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    @Basic
    @Column(name = "supplier_id")
    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "delivery_status_id")
    public long getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(long deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
    }

    @Basic
    @Column(name = "sold_out_status_id")
    public long getSoldOutStatusId() {
        return soldOutStatusId;
    }

    public void setSoldOutStatusId(long soldOutStatusId) {
        this.soldOutStatusId = soldOutStatusId;
    }

    @Basic
    @Column(name = "default_category_id")
    public long getDefaultCategoryId() {
        return defaultCategoryId;
    }

    public void setDefaultCategoryId(long defaultCategoryId) {
        this.defaultCategoryId = defaultCategoryId;
    }

    @Basic
    @Column(name = "product_groups")
    public String getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(String productGroups) {
        this.productGroups = productGroups;
    }

    @Basic
    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "sku")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "mpn")
    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    @Basic
    @Column(name = "upc")
    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @Basic
    @Column(name = "gtin")
    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    @Basic
    @Column(name = "taric")
    public String getTaric() {
        return taric;
    }

    public void setTaric(String taric) {
        this.taric = taric;
    }

    @Basic
    @Column(name = "quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "quantity_unit_id")
    public long getQuantityUnitId() {
        return quantityUnitId;
    }

    public void setQuantityUnitId(long quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
    }

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "weight_class")
    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    @Basic
    @Column(name = "dim_x")
    public BigDecimal getDimX() {
        return dimX;
    }

    public void setDimX(BigDecimal dimX) {
        this.dimX = dimX;
    }

    @Basic
    @Column(name = "dim_y")
    public BigDecimal getDimY() {
        return dimY;
    }

    public void setDimY(BigDecimal dimY) {
        this.dimY = dimY;
    }

    @Basic
    @Column(name = "dim_z")
    public BigDecimal getDimZ() {
        return dimZ;
    }

    public void setDimZ(BigDecimal dimZ) {
        this.dimZ = dimZ;
    }

    @Basic
    @Column(name = "dim_class")
    public String getDimClass() {
        return dimClass;
    }

    public void setDimClass(String dimClass) {
        this.dimClass = dimClass;
    }

    @Basic
    @Column(name = "purchase_price")
    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Basic
    @Column(name = "purchase_price_currency_code")
    public String getPurchasePriceCurrencyCode() {
        return purchasePriceCurrencyCode;
    }

    public void setPurchasePriceCurrencyCode(String purchasePriceCurrencyCode) {
        this.purchasePriceCurrencyCode = purchasePriceCurrencyCode;
    }

    @Basic
    @Column(name = "tax_class_id")
    public long getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(long taxClassId) {
        this.taxClassId = taxClassId;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "views")
    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    @Basic
    @Column(name = "purchases")
    public long getPurchases() {
        return purchases;
    }

    public void setPurchases(long purchases) {
        this.purchases = purchases;
    }

    @Basic
    @Column(name = "date_valid_from")
    public Date getDateValidFrom() {
        return dateValidFrom;
    }

    public void setDateValidFrom(Date dateValidFrom) {
        this.dateValidFrom = dateValidFrom;
    }

    @Basic
    @Column(name = "date_valid_to")
    public Date getDateValidTo() {
        return dateValidTo;
    }

    public void setDateValidTo(Date dateValidTo) {
        this.dateValidTo = dateValidTo;
    }

    @Basic
    @Column(name = "date_updated")
    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcProductsEntity that = (LcProductsEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (manufacturerId != that.manufacturerId) return false;
        if (supplierId != that.supplierId) return false;
        if (deliveryStatusId != that.deliveryStatusId) return false;
        if (soldOutStatusId != that.soldOutStatusId) return false;
        if (defaultCategoryId != that.defaultCategoryId) return false;
        if (quantityUnitId != that.quantityUnitId) return false;
        if (taxClassId != that.taxClassId) return false;
        if (views != that.views) return false;
        if (purchases != that.purchases) return false;
        if (productGroups != null ? !productGroups.equals(that.productGroups) : that.productGroups != null)
            return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
        if (mpn != null ? !mpn.equals(that.mpn) : that.mpn != null) return false;
        if (upc != null ? !upc.equals(that.upc) : that.upc != null) return false;
        if (gtin != null ? !gtin.equals(that.gtin) : that.gtin != null) return false;
        if (taric != null ? !taric.equals(that.taric) : that.taric != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (weightClass != null ? !weightClass.equals(that.weightClass) : that.weightClass != null) return false;
        if (dimX != null ? !dimX.equals(that.dimX) : that.dimX != null) return false;
        if (dimY != null ? !dimY.equals(that.dimY) : that.dimY != null) return false;
        if (dimZ != null ? !dimZ.equals(that.dimZ) : that.dimZ != null) return false;
        if (dimClass != null ? !dimClass.equals(that.dimClass) : that.dimClass != null) return false;
        if (purchasePrice != null ? !purchasePrice.equals(that.purchasePrice) : that.purchasePrice != null)
            return false;
        if (purchasePriceCurrencyCode != null ? !purchasePriceCurrencyCode.equals(that.purchasePriceCurrencyCode) : that.purchasePriceCurrencyCode != null)
            return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (dateValidFrom != null ? !dateValidFrom.equals(that.dateValidFrom) : that.dateValidFrom != null)
            return false;
        if (dateValidTo != null ? !dateValidTo.equals(that.dateValidTo) : that.dateValidTo != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + (long) status;
        result = 31 * result + manufacturerId;
        result = 31 * result + supplierId;
        result = 31 * result + deliveryStatusId;
        result = 31 * result + soldOutStatusId;
        result = 31 * result + defaultCategoryId;
        result = 31 * result + (productGroups != null ? productGroups.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (mpn != null ? mpn.hashCode() : 0);
        result = 31 * result + (upc != null ? upc.hashCode() : 0);
        result = 31 * result + (gtin != null ? gtin.hashCode() : 0);
        result = 31 * result + (taric != null ? taric.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + quantityUnitId;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (weightClass != null ? weightClass.hashCode() : 0);
        result = 31 * result + (dimX != null ? dimX.hashCode() : 0);
        result = 31 * result + (dimY != null ? dimY.hashCode() : 0);
        result = 31 * result + (dimZ != null ? dimZ.hashCode() : 0);
        result = 31 * result + (dimClass != null ? dimClass.hashCode() : 0);
        result = 31 * result + (purchasePrice != null ? purchasePrice.hashCode() : 0);
        result = 31 * result + (purchasePriceCurrencyCode != null ? purchasePriceCurrencyCode.hashCode() : 0);
        result = 31 * result + taxClassId;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + views;
        result = 31 * result + purchases;
        result = 31 * result + (dateValidFrom != null ? dateValidFrom.hashCode() : 0);
        result = 31 * result + (dateValidTo != null ? dateValidTo.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return (int)result;
    }
}
