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
@Table(name = "lc_translations", schema = "litecart", catalog = "")
public class LcTranslationsEntity {
    private int id;
    private String code;
    private String textEn;
    private byte html;
    private byte frontend;
    private byte backend;
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
    @Column(name = "text_en")
    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    @Basic
    @Column(name = "html")
    public byte getHtml() {
        return html;
    }

    public void setHtml(byte html) {
        this.html = html;
    }

    @Basic
    @Column(name = "frontend")
    public byte getFrontend() {
        return frontend;
    }

    public void setFrontend(byte frontend) {
        this.frontend = frontend;
    }

    @Basic
    @Column(name = "backend")
    public byte getBackend() {
        return backend;
    }

    public void setBackend(byte backend) {
        this.backend = backend;
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

        LcTranslationsEntity that = (LcTranslationsEntity) o;

        if (id != that.id) return false;
        if (html != that.html) return false;
        if (frontend != that.frontend) return false;
        if (backend != that.backend) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (textEn != null ? !textEn.equals(that.textEn) : that.textEn != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (textEn != null ? textEn.hashCode() : 0);
        result = 31 * result + (int) html;
        result = 31 * result + (int) frontend;
        result = 31 * result + (int) backend;
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
