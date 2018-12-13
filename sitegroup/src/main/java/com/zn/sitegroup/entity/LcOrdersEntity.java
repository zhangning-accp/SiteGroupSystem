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
@Table(name = "lc_orders", schema = "litecart", catalog = "")
public class LcOrdersEntity {
    private String id;
    private String uid;
    private String orderNumber;
    private int orderStatusId;
    private int customerId;
    private String customerCompany;
    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;
    private String customerPhone;
    private String customerTaxId;
    private String customerAddress1;
    private String customerAddress2;
    private String customerCity;
    private String customerPostcode;
    private String customerCountryCode;
    private String customerZoneCode;
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
    private String shippingOptionId;
    private String shippingOptionName;
    private String shippingTrackingId;
    private String paymentOptionId;
    private String paymentOptionName;
    private String paymentTransactionId;
    private String languageCode;
    private BigDecimal weightTotal;
    private String weightClass;
    private String currencyCode;
    private BigDecimal currencyValue;
    private BigDecimal paymentDue;
    private BigDecimal taxTotal;
    private String clientIp;
    private Timestamp dateUpdated;
    private Timestamp dateCreated;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "order_number")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "order_status_id")
    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_company")
    public String getCustomerCompany() {
        return customerCompany;
    }

    public void setCustomerCompany(String customerCompany) {
        this.customerCompany = customerCompany;
    }

    @Basic
    @Column(name = "customer_firstname")
    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    @Basic
    @Column(name = "customer_lastname")
    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    @Basic
    @Column(name = "customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Basic
    @Column(name = "customer_phone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "customer_tax_id")
    public String getCustomerTaxId() {
        return customerTaxId;
    }

    public void setCustomerTaxId(String customerTaxId) {
        this.customerTaxId = customerTaxId;
    }

    @Basic
    @Column(name = "customer_address1")
    public String getCustomerAddress1() {
        return customerAddress1;
    }

    public void setCustomerAddress1(String customerAddress1) {
        this.customerAddress1 = customerAddress1;
    }

    @Basic
    @Column(name = "customer_address2")
    public String getCustomerAddress2() {
        return customerAddress2;
    }

    public void setCustomerAddress2(String customerAddress2) {
        this.customerAddress2 = customerAddress2;
    }

    @Basic
    @Column(name = "customer_city")
    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    @Basic
    @Column(name = "customer_postcode")
    public String getCustomerPostcode() {
        return customerPostcode;
    }

    public void setCustomerPostcode(String customerPostcode) {
        this.customerPostcode = customerPostcode;
    }

    @Basic
    @Column(name = "customer_country_code")
    public String getCustomerCountryCode() {
        return customerCountryCode;
    }

    public void setCustomerCountryCode(String customerCountryCode) {
        this.customerCountryCode = customerCountryCode;
    }

    @Basic
    @Column(name = "customer_zone_code")
    public String getCustomerZoneCode() {
        return customerZoneCode;
    }

    public void setCustomerZoneCode(String customerZoneCode) {
        this.customerZoneCode = customerZoneCode;
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
    @Column(name = "shipping_option_id")
    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    @Basic
    @Column(name = "shipping_option_name")
    public String getShippingOptionName() {
        return shippingOptionName;
    }

    public void setShippingOptionName(String shippingOptionName) {
        this.shippingOptionName = shippingOptionName;
    }

    @Basic
    @Column(name = "shipping_tracking_id")
    public String getShippingTrackingId() {
        return shippingTrackingId;
    }

    public void setShippingTrackingId(String shippingTrackingId) {
        this.shippingTrackingId = shippingTrackingId;
    }

    @Basic
    @Column(name = "payment_option_id")
    public String getPaymentOptionId() {
        return paymentOptionId;
    }

    public void setPaymentOptionId(String paymentOptionId) {
        this.paymentOptionId = paymentOptionId;
    }

    @Basic
    @Column(name = "payment_option_name")
    public String getPaymentOptionName() {
        return paymentOptionName;
    }

    public void setPaymentOptionName(String paymentOptionName) {
        this.paymentOptionName = paymentOptionName;
    }

    @Basic
    @Column(name = "payment_transaction_id")
    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
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
    @Column(name = "weight_total")
    public BigDecimal getWeightTotal() {
        return weightTotal;
    }

    public void setWeightTotal(BigDecimal weightTotal) {
        this.weightTotal = weightTotal;
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
    @Column(name = "currency_code")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Basic
    @Column(name = "currency_value")
    public BigDecimal getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        this.currencyValue = currencyValue;
    }

    @Basic
    @Column(name = "payment_due")
    public BigDecimal getPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(BigDecimal paymentDue) {
        this.paymentDue = paymentDue;
    }

    @Basic
    @Column(name = "tax_total")
    public BigDecimal getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(BigDecimal taxTotal) {
        this.taxTotal = taxTotal;
    }

    @Basic
    @Column(name = "client_ip")
    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
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

        LcOrdersEntity that = (LcOrdersEntity) o;

        if (orderStatusId != that.orderStatusId) return false;
        if (customerId != that.customerId) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (customerCompany != null ? !customerCompany.equals(that.customerCompany) : that.customerCompany != null)
            return false;
        if (customerFirstname != null ? !customerFirstname.equals(that.customerFirstname) : that.customerFirstname != null)
            return false;
        if (customerLastname != null ? !customerLastname.equals(that.customerLastname) : that.customerLastname != null)
            return false;
        if (customerEmail != null ? !customerEmail.equals(that.customerEmail) : that.customerEmail != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(that.customerPhone) : that.customerPhone != null)
            return false;
        if (customerTaxId != null ? !customerTaxId.equals(that.customerTaxId) : that.customerTaxId != null)
            return false;
        if (customerAddress1 != null ? !customerAddress1.equals(that.customerAddress1) : that.customerAddress1 != null)
            return false;
        if (customerAddress2 != null ? !customerAddress2.equals(that.customerAddress2) : that.customerAddress2 != null)
            return false;
        if (customerCity != null ? !customerCity.equals(that.customerCity) : that.customerCity != null) return false;
        if (customerPostcode != null ? !customerPostcode.equals(that.customerPostcode) : that.customerPostcode != null)
            return false;
        if (customerCountryCode != null ? !customerCountryCode.equals(that.customerCountryCode) : that.customerCountryCode != null)
            return false;
        if (customerZoneCode != null ? !customerZoneCode.equals(that.customerZoneCode) : that.customerZoneCode != null)
            return false;
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
        if (shippingOptionId != null ? !shippingOptionId.equals(that.shippingOptionId) : that.shippingOptionId != null)
            return false;
        if (shippingOptionName != null ? !shippingOptionName.equals(that.shippingOptionName) : that.shippingOptionName != null)
            return false;
        if (shippingTrackingId != null ? !shippingTrackingId.equals(that.shippingTrackingId) : that.shippingTrackingId != null)
            return false;
        if (paymentOptionId != null ? !paymentOptionId.equals(that.paymentOptionId) : that.paymentOptionId != null)
            return false;
        if (paymentOptionName != null ? !paymentOptionName.equals(that.paymentOptionName) : that.paymentOptionName != null)
            return false;
        if (paymentTransactionId != null ? !paymentTransactionId.equals(that.paymentTransactionId) : that.paymentTransactionId != null)
            return false;
        if (languageCode != null ? !languageCode.equals(that.languageCode) : that.languageCode != null) return false;
        if (weightTotal != null ? !weightTotal.equals(that.weightTotal) : that.weightTotal != null) return false;
        if (weightClass != null ? !weightClass.equals(that.weightClass) : that.weightClass != null) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (currencyValue != null ? !currencyValue.equals(that.currencyValue) : that.currencyValue != null)
            return false;
        if (paymentDue != null ? !paymentDue.equals(that.paymentDue) : that.paymentDue != null) return false;
        if (taxTotal != null ? !taxTotal.equals(that.taxTotal) : that.taxTotal != null) return false;
        if (clientIp != null ? !clientIp.equals(that.clientIp) : that.clientIp != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (uid != null ? uid.hashCode() : 0);
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + orderStatusId;
        result = 31 * result + customerId;
        result = 31 * result + (customerCompany != null ? customerCompany.hashCode() : 0);
        result = 31 * result + (customerFirstname != null ? customerFirstname.hashCode() : 0);
        result = 31 * result + (customerLastname != null ? customerLastname.hashCode() : 0);
        result = 31 * result + (customerEmail != null ? customerEmail.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (customerTaxId != null ? customerTaxId.hashCode() : 0);
        result = 31 * result + (customerAddress1 != null ? customerAddress1.hashCode() : 0);
        result = 31 * result + (customerAddress2 != null ? customerAddress2.hashCode() : 0);
        result = 31 * result + (customerCity != null ? customerCity.hashCode() : 0);
        result = 31 * result + (customerPostcode != null ? customerPostcode.hashCode() : 0);
        result = 31 * result + (customerCountryCode != null ? customerCountryCode.hashCode() : 0);
        result = 31 * result + (customerZoneCode != null ? customerZoneCode.hashCode() : 0);
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
        result = 31 * result + (shippingOptionId != null ? shippingOptionId.hashCode() : 0);
        result = 31 * result + (shippingOptionName != null ? shippingOptionName.hashCode() : 0);
        result = 31 * result + (shippingTrackingId != null ? shippingTrackingId.hashCode() : 0);
        result = 31 * result + (paymentOptionId != null ? paymentOptionId.hashCode() : 0);
        result = 31 * result + (paymentOptionName != null ? paymentOptionName.hashCode() : 0);
        result = 31 * result + (paymentTransactionId != null ? paymentTransactionId.hashCode() : 0);
        result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
        result = 31 * result + (weightTotal != null ? weightTotal.hashCode() : 0);
        result = 31 * result + (weightClass != null ? weightClass.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (currencyValue != null ? currencyValue.hashCode() : 0);
        result = 31 * result + (paymentDue != null ? paymentDue.hashCode() : 0);
        result = 31 * result + (taxTotal != null ? taxTotal.hashCode() : 0);
        result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
