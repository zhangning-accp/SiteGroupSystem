package com.zn.sitegroup.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zn on 2018/12/13.
 */
@Entity
@Table(name = "lc_categories", schema = "litecart", catalog = "")
public class LcCategoriesEntity {
    private long id;
    private long parentId;
    private long googleTaxonomyId;
    private byte status;
    private String code;
    private String listStyle;
    private String dock;
    private String keywords;
    private String image;
    private byte priority;
    private Date dateUpdated;
    private Date dateCreated;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id")
    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "google_taxonomy_id")
    public long getGoogleTaxonomyId() {
        return googleTaxonomyId;
    }

    public void setGoogleTaxonomyId(long googleTaxonomyId) {
        this.googleTaxonomyId = googleTaxonomyId;
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
    @Column(name = "list_style")
    public String getListStyle() {
        return listStyle;
    }

    public void setListStyle(String listStyle) {
        this.listStyle = listStyle;
    }

    @Basic
    @Column(name = "dock")
    public String getDock() {
        return dock;
    }

    public void setDock(String dock) {
        this.dock = dock;
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
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Basic
    @Column(name = "date_created")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcCategoriesEntity that = (LcCategoriesEntity) o;

        if (id != that.id) return false;
        if (parentId != that.parentId) return false;
        if (googleTaxonomyId != that.googleTaxonomyId) return false;
        if (status != that.status) return false;
        if (priority != that.priority) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (listStyle != null ? !listStyle.equals(that.listStyle) : that.listStyle != null) return false;
        if (dock != null ? !dock.equals(that.dock) : that.dock != null) return false;
        if (keywords != null ? !keywords.equals(that.keywords) : that.keywords != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + parentId;
        result = 31 * result + googleTaxonomyId;
        result = 31 * result + (int) status;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (listStyle != null ? listStyle.hashCode() : 0);
        result = 31 * result + (dock != null ? dock.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (int) priority;
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return (int)result;
    }
}
