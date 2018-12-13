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
@Table(name = "lc_languages", schema = "litecart", catalog = "")
public class LcLanguagesEntity {
    private int id;
    private byte status;
    private String code;
    private String code2;
    private String name;
    private String locale;
    private String charset;
    private String rawDate;
    private String rawTime;
    private String rawDatetime;
    private String formatDate;
    private String formatTime;
    private String formatDatetime;
    private String decimalPoint;
    private String thousandsSep;
    private String currencyCode;
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
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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
    @Column(name = "code2")
    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
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
    @Column(name = "locale")
    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Basic
    @Column(name = "charset")
    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Basic
    @Column(name = "raw_date")
    public String getRawDate() {
        return rawDate;
    }

    public void setRawDate(String rawDate) {
        this.rawDate = rawDate;
    }

    @Basic
    @Column(name = "raw_time")
    public String getRawTime() {
        return rawTime;
    }

    public void setRawTime(String rawTime) {
        this.rawTime = rawTime;
    }

    @Basic
    @Column(name = "raw_datetime")
    public String getRawDatetime() {
        return rawDatetime;
    }

    public void setRawDatetime(String rawDatetime) {
        this.rawDatetime = rawDatetime;
    }

    @Basic
    @Column(name = "format_date")
    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }

    @Basic
    @Column(name = "format_time")
    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }

    @Basic
    @Column(name = "format_datetime")
    public String getFormatDatetime() {
        return formatDatetime;
    }

    public void setFormatDatetime(String formatDatetime) {
        this.formatDatetime = formatDatetime;
    }

    @Basic
    @Column(name = "decimal_point")
    public String getDecimalPoint() {
        return decimalPoint;
    }

    public void setDecimalPoint(String decimalPoint) {
        this.decimalPoint = decimalPoint;
    }

    @Basic
    @Column(name = "thousands_sep")
    public String getThousandsSep() {
        return thousandsSep;
    }

    public void setThousandsSep(String thousandsSep) {
        this.thousandsSep = thousandsSep;
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

        LcLanguagesEntity that = (LcLanguagesEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (priority != that.priority) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (code2 != null ? !code2.equals(that.code2) : that.code2 != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;
        if (charset != null ? !charset.equals(that.charset) : that.charset != null) return false;
        if (rawDate != null ? !rawDate.equals(that.rawDate) : that.rawDate != null) return false;
        if (rawTime != null ? !rawTime.equals(that.rawTime) : that.rawTime != null) return false;
        if (rawDatetime != null ? !rawDatetime.equals(that.rawDatetime) : that.rawDatetime != null) return false;
        if (formatDate != null ? !formatDate.equals(that.formatDate) : that.formatDate != null) return false;
        if (formatTime != null ? !formatTime.equals(that.formatTime) : that.formatTime != null) return false;
        if (formatDatetime != null ? !formatDatetime.equals(that.formatDatetime) : that.formatDatetime != null)
            return false;
        if (decimalPoint != null ? !decimalPoint.equals(that.decimalPoint) : that.decimalPoint != null) return false;
        if (thousandsSep != null ? !thousandsSep.equals(that.thousandsSep) : that.thousandsSep != null) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) status;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (code2 != null ? code2.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (charset != null ? charset.hashCode() : 0);
        result = 31 * result + (rawDate != null ? rawDate.hashCode() : 0);
        result = 31 * result + (rawTime != null ? rawTime.hashCode() : 0);
        result = 31 * result + (rawDatetime != null ? rawDatetime.hashCode() : 0);
        result = 31 * result + (formatDate != null ? formatDate.hashCode() : 0);
        result = 31 * result + (formatTime != null ? formatTime.hashCode() : 0);
        result = 31 * result + (formatDatetime != null ? formatDatetime.hashCode() : 0);
        result = 31 * result + (decimalPoint != null ? decimalPoint.hashCode() : 0);
        result = 31 * result + (thousandsSep != null ? thousandsSep.hashCode() : 0);
        result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
        result = 31 * result + (int) priority;
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
