package com.zn.sitegroup.entity;

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
@Table(name = "lc_countries", schema = "litecart", catalog = "")
public class LcCountriesEntity {
    private int id;
    private byte status;
    private String name;
    private String domesticName;
    private String isoCode1;
    private String isoCode2;
    private String isoCode3;
    private String taxIdFormat;
    private String addressFormat;
    private String postcodeFormat;
    private byte postcodeRequired;
    private String languageCode;
    private String currencyCode;
    private String phoneCode;
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
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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
    @Column(name = "domestic_name")
    public String getDomesticName() {
        return domesticName;
    }

    public void setDomesticName(String domesticName) {
        this.domesticName = domesticName;
    }

    @Basic
    @Column(name = "iso_code_1")
    public String getIsoCode1() {
        return isoCode1;
    }

    public void setIsoCode1(String isoCode1) {
        this.isoCode1 = isoCode1;
    }

    @Basic
    @Column(name = "iso_code_2")
    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    @Basic
    @Column(name = "iso_code_3")
    public String getIsoCode3() {
        return isoCode3;
    }

    public void setIsoCode3(String isoCode3) {
        this.isoCode3 = isoCode3;
    }

    @Basic
    @Column(name = "tax_id_format")
    public String getTaxIdFormat() {
        return taxIdFormat;
    }

    public void setTaxIdFormat(String taxIdFormat) {
        this.taxIdFormat = taxIdFormat;
    }

    @Basic
    @Column(name = "address_format")
    public String getAddressFormat() {
        return addressFormat;
    }

    public void setAddressFormat(String addressFormat) {
        this.addressFormat = addressFormat;
    }

    @Basic
    @Column(name = "postcode_format")
    public String getPostcodeFormat() {
        return postcodeFormat;
    }

    public void setPostcodeFormat(String postcodeFormat) {
        this.postcodeFormat = postcodeFormat;
    }

    @Basic
    @Column(name = "postcode_required")
    public byte getPostcodeRequired() {
        return postcodeRequired;
    }

    public void setPostcodeRequired(byte postcodeRequired) {
        this.postcodeRequired = postcodeRequired;
    }

    @Basic
    @Column(name = "language_code")
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @Basic
    @Column(name = "currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "phone_code")
    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
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

        LcCountriesEntity that = (LcCountriesEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (postcodeRequired != that.postcodeRequired) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (domesticName != null ? !domesticName.equals(that.domesticName) : that.domesticName != null) return false;
        if (isoCode1 != null ? !isoCode1.equals(that.isoCode1) : that.isoCode1 != null) return false;
        if (isoCode2 != null ? !isoCode2.equals(that.isoCode2) : that.isoCode2 != null) return false;
        if (isoCode3 != null ? !isoCode3.equals(that.isoCode3) : that.isoCode3 != null) return false;
        if (taxIdFormat != null ? !taxIdFormat.equals(that.taxIdFormat) : that.taxIdFormat != null) return false;
        if (addressFormat != null ? !addressFormat.equals(that.addressFormat) : that.addressFormat != null)
            return false;
        if (postcodeFormat != null ? !postcodeFormat.equals(that.postcodeFormat) : that.postcodeFormat != null)
            return false;
        if (languageCode != null ? !languageCode.equals(that.languageCode) : that.languageCode != null) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (phoneCode != null ? !phoneCode.equals(that.phoneCode) : that.phoneCode != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) status;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (domesticName != null ? domesticName.hashCode() : 0);
        result = 31 * result + (isoCode1 != null ? isoCode1.hashCode() : 0);
        result = 31 * result + (isoCode2 != null ? isoCode2.hashCode() : 0);
        result = 31 * result + (isoCode3 != null ? isoCode3.hashCode() : 0);
        result = 31 * result + (taxIdFormat != null ? taxIdFormat.hashCode() : 0);
        result = 31 * result + (addressFormat != null ? addressFormat.hashCode() : 0);
        result = 31 * result + (postcodeFormat != null ? postcodeFormat.hashCode() : 0);
        result = 31 * result + (int) postcodeRequired;
        result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (phoneCode != null ? phoneCode.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
