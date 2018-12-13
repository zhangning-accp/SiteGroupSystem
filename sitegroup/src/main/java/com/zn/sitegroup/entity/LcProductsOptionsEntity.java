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
@Table(name = "lc_products_options", schema = "litecart", catalog = "")
public class LcProductsOptionsEntity {
    private int id;
    private int productId;
    private int groupId;
    private int valueId;
    private String priceOperator;
    private BigDecimal usd;
    private BigDecimal eur;
    private String links;
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
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "value_id")
    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    @Basic
    @Column(name = "price_operator")
    public String getPriceOperator() {
        return priceOperator;
    }

    public void setPriceOperator(String priceOperator) {
        this.priceOperator = priceOperator;
    }

    @Basic
    @Column(name = "USD")
    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    @Basic
    @Column(name = "EUR")
    public BigDecimal getEur() {
        return eur;
    }

    public void setEur(BigDecimal eur) {
        this.eur = eur;
    }

    @Basic
    @Column(name = "links")
    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
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

        LcProductsOptionsEntity that = (LcProductsOptionsEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (groupId != that.groupId) return false;
        if (valueId != that.valueId) return false;
        if (priority != that.priority) return false;
        if (priceOperator != null ? !priceOperator.equals(that.priceOperator) : that.priceOperator != null)
            return false;
        if (usd != null ? !usd.equals(that.usd) : that.usd != null) return false;
        if (eur != null ? !eur.equals(that.eur) : that.eur != null) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productId;
        result = 31 * result + groupId;
        result = 31 * result + valueId;
        result = 31 * result + (priceOperator != null ? priceOperator.hashCode() : 0);
        result = 31 * result + (usd != null ? usd.hashCode() : 0);
        result = 31 * result + (eur != null ? eur.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (int) priority;
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
