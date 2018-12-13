package com.zn.sitegroup.entity;

import java.io.Serializable;
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
@Table(name = "lc_tax_rates", schema = "litecart", catalog = "")
public class LcTaxRatesEntity {
    private int id;
    private int taxClassId;
    private int geoZoneId;
    private String code;
    private String name;
    private String description;
    private BigDecimal rate;
    private Serializable type;
    private Serializable addressType;
    private Serializable customerType;
    private Serializable taxIdRule;
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
    @Column(name = "tax_class_id")
    public int getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(int taxClassId) {
        this.taxClassId = taxClassId;
    }

    @Basic
    @Column(name = "geo_zone_id")
    public int getGeoZoneId() {
        return geoZoneId;
    }

    public void setGeoZoneId(int geoZoneId) {
        this.geoZoneId = geoZoneId;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "rate")
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "type")
    public Serializable getType() {
        return type;
    }

    public void setType(Serializable type) {
        this.type = type;
    }

    @Basic
    @Column(name = "address_type")
    public Serializable getAddressType() {
        return addressType;
    }

    public void setAddressType(Serializable addressType) {
        this.addressType = addressType;
    }

    @Basic
    @Column(name = "customer_type")
    public Serializable getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Serializable customerType) {
        this.customerType = customerType;
    }

    @Basic
    @Column(name = "tax_id_rule")
    public Serializable getTaxIdRule() {
        return taxIdRule;
    }

    public void setTaxIdRule(Serializable taxIdRule) {
        this.taxIdRule = taxIdRule;
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

        LcTaxRatesEntity that = (LcTaxRatesEntity) o;

        if (id != that.id) return false;
        if (taxClassId != that.taxClassId) return false;
        if (geoZoneId != that.geoZoneId) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (addressType != null ? !addressType.equals(that.addressType) : that.addressType != null) return false;
        if (customerType != null ? !customerType.equals(that.customerType) : that.customerType != null) return false;
        if (taxIdRule != null ? !taxIdRule.equals(that.taxIdRule) : that.taxIdRule != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + taxClassId;
        result = 31 * result + geoZoneId;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (addressType != null ? addressType.hashCode() : 0);
        result = 31 * result + (customerType != null ? customerType.hashCode() : 0);
        result = 31 * result + (taxIdRule != null ? taxIdRule.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
