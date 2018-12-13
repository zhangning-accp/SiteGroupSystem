package com.zn.sitegroup.entity;

import java.math.BigDecimal;
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
@Table(name = "lc_products_options_stock", schema = "litecart", catalog = "")
public class LcProductsOptionsStockEntity {
    private int id;
    private int productId;
    private String combination;
    private String sku;
    private BigDecimal weight;
    private String weightClass;
    private BigDecimal dimX;
    private BigDecimal dimY;
    private BigDecimal dimZ;
    private String dimClass;
    private BigDecimal quantity;
    private byte priority;
    private Timestamp dateUpdated;
    private Timestamp dateCreated;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "combination")
    public String getCombination() {
        return combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
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
    @Column(name = "quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "priority")
    public byte getPriority() {
        return priority;
    }

    public void setPriority(byte priority) {
        this.priority = priority;
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

        LcProductsOptionsStockEntity that = (LcProductsOptionsStockEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (priority != that.priority) return false;
        if (combination != null ? !combination.equals(that.combination) : that.combination != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (weightClass != null ? !weightClass.equals(that.weightClass) : that.weightClass != null) return false;
        if (dimX != null ? !dimX.equals(that.dimX) : that.dimX != null) return false;
        if (dimY != null ? !dimY.equals(that.dimY) : that.dimY != null) return false;
        if (dimZ != null ? !dimZ.equals(that.dimZ) : that.dimZ != null) return false;
        if (dimClass != null ? !dimClass.equals(that.dimClass) : that.dimClass != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productId;
        result = 31 * result + (combination != null ? combination.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (weightClass != null ? weightClass.hashCode() : 0);
        result = 31 * result + (dimX != null ? dimX.hashCode() : 0);
        result = 31 * result + (dimY != null ? dimY.hashCode() : 0);
        result = 31 * result + (dimZ != null ? dimZ.hashCode() : 0);
        result = 31 * result + (dimClass != null ? dimClass.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (int) priority;
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
