package com.zn.sitegroup.entity;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zn on 2018/12/13.
 */
@Entity
@Table(name = "lc_products_prices", schema = "litecart", catalog = "")
public class LcProductsPricesEntity {
    private int id;
    private int productId;
    private BigDecimal usd;
    private BigDecimal eur;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcProductsPricesEntity that = (LcProductsPricesEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (usd != null ? !usd.equals(that.usd) : that.usd != null) return false;
        if (eur != null ? !eur.equals(that.eur) : that.eur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productId;
        result = 31 * result + (usd != null ? usd.hashCode() : 0);
        result = 31 * result + (eur != null ? eur.hashCode() : 0);
        return result;
    }
}
