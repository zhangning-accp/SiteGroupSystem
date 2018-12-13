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
@Table(name = "lc_customers", schema = "litecart", catalog = "")
public class LcCustomersEntity {
    private int id;
    private String code;
    private byte status;
    private String email;
    private String password;
    private String taxId;
    private String company;
    private String firstname;
    private String lastname;
    private String address1;
    private String address2;
    private String postcode;
    private String city;
    private String countryCode;
    private String zoneCode;
    private String phone;
    private byte differentShippingAddress;
    private String shippingCompany;
    private String shippingFirstname;
    private String shippingLastname;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingCity;
    private String shippingPostcode;
    private String shippingCountryCode;
    private String shippingZoneCode;
    private String shippingPhone;
    private byte newsletter;
    private String notes;
    private String passwordResetToken;
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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "tax_id")
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "address1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "address2")
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Basic
    @Column(name = "zone_code")
    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "different_shipping_address")
    public byte getDifferentShippingAddress() {
        return differentShippingAddress;
    }

    public void setDifferentShippingAddress(byte differentShippingAddress) {
        this.differentShippingAddress = differentShippingAddress;
    }

    @Basic
    @Column(name = "shipping_company")
    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    @Basic
    @Column(name = "shipping_firstname")
    public String getShippingFirstname() {
        return shippingFirstname;
    }

    public void setShippingFirstname(String shippingFirstname) {
        this.shippingFirstname = shippingFirstname;
    }

    @Basic
    @Column(name = "shipping_lastname")
    public String getShippingLastname() {
        return shippingLastname;
    }

    public void setShippingLastname(String shippingLastname) {
        this.shippingLastname = shippingLastname;
    }

    @Basic
    @Column(name = "shipping_address1")
    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    @Basic
    @Column(name = "shipping_address2")
    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    @Basic
    @Column(name = "shipping_city")
    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    @Basic
    @Column(name = "shipping_postcode")
    public String getShippingPostcode() {
        return shippingPostcode;
    }

    public void setShippingPostcode(String shippingPostcode) {
        this.shippingPostcode = shippingPostcode;
    }

    @Basic
    @Column(name = "shipping_country_code")
    public String getShippingCountryCode() {
        return shippingCountryCode;
    }

    public void setShippingCountryCode(String shippingCountryCode) {
        this.shippingCountryCode = shippingCountryCode;
    }

    @Basic
    @Column(name = "shipping_zone_code")
    public String getShippingZoneCode() {
        return shippingZoneCode;
    }

    public void setShippingZoneCode(String shippingZoneCode) {
        this.shippingZoneCode = shippingZoneCode;
    }

    @Basic
    @Column(name = "shipping_phone")
    public String getShippingPhone() {
        return shippingPhone;
    }

    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    @Basic
    @Column(name = "newsletter")
    public byte getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(byte newsletter) {
        this.newsletter = newsletter;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "password_reset_token")
    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
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

        LcCustomersEntity that = (LcCustomersEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (differentShippingAddress != that.differentShippingAddress) return false;
        if (newsletter != that.newsletter) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (taxId != null ? !taxId.equals(that.taxId) : that.taxId != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (address1 != null ? !address1.equals(that.address1) : that.address1 != null) return false;
        if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (zoneCode != null ? !zoneCode.equals(that.zoneCode) : that.zoneCode != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (shippingCompany != null ? !shippingCompany.equals(that.shippingCompany) : that.shippingCompany != null)
            return false;
        if (shippingFirstname != null ? !shippingFirstname.equals(that.shippingFirstname) : that.shippingFirstname != null)
            return false;
        if (shippingLastname != null ? !shippingLastname.equals(that.shippingLastname) : that.shippingLastname != null)
            return false;
        if (shippingAddress1 != null ? !shippingAddress1.equals(that.shippingAddress1) : that.shippingAddress1 != null)
            return false;
        if (shippingAddress2 != null ? !shippingAddress2.equals(that.shippingAddress2) : that.shippingAddress2 != null)
            return false;
        if (shippingCity != null ? !shippingCity.equals(that.shippingCity) : that.shippingCity != null) return false;
        if (shippingPostcode != null ? !shippingPostcode.equals(that.shippingPostcode) : that.shippingPostcode != null)
            return false;
        if (shippingCountryCode != null ? !shippingCountryCode.equals(that.shippingCountryCode) : that.shippingCountryCode != null)
            return false;
        if (shippingZoneCode != null ? !shippingZoneCode.equals(that.shippingZoneCode) : that.shippingZoneCode != null)
            return false;
        if (shippingPhone != null ? !shippingPhone.equals(that.shippingPhone) : that.shippingPhone != null)
            return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (passwordResetToken != null ? !passwordResetToken.equals(that.passwordResetToken) : that.passwordResetToken != null)
            return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (int) status;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (taxId != null ? taxId.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (zoneCode != null ? zoneCode.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (int) differentShippingAddress;
        result = 31 * result + (shippingCompany != null ? shippingCompany.hashCode() : 0);
        result = 31 * result + (shippingFirstname != null ? shippingFirstname.hashCode() : 0);
        result = 31 * result + (shippingLastname != null ? shippingLastname.hashCode() : 0);
        result = 31 * result + (shippingAddress1 != null ? shippingAddress1.hashCode() : 0);
        result = 31 * result + (shippingAddress2 != null ? shippingAddress2.hashCode() : 0);
        result = 31 * result + (shippingCity != null ? shippingCity.hashCode() : 0);
        result = 31 * result + (shippingPostcode != null ? shippingPostcode.hashCode() : 0);
        result = 31 * result + (shippingCountryCode != null ? shippingCountryCode.hashCode() : 0);
        result = 31 * result + (shippingZoneCode != null ? shippingZoneCode.hashCode() : 0);
        result = 31 * result + (shippingPhone != null ? shippingPhone.hashCode() : 0);
        result = 31 * result + (int) newsletter;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (passwordResetToken != null ? passwordResetToken.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
