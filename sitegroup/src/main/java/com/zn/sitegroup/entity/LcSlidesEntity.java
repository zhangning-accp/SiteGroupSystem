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
@Table(name = "lc_slides", schema = "litecart", catalog = "")
public class LcSlidesEntity {
    private int id;
    private byte status;
    private String languages;
    private String name;
    private String image;
    private byte priority;
    private Timestamp dateValidFrom;
    private Timestamp dateValidTo;
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
    @Column(name = "languages")
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
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
    @Column(name = "date_valid_from")
    public Timestamp getDateValidFrom() {
        return dateValidFrom;
    }

    public void setDateValidFrom(Timestamp dateValidFrom) {
        this.dateValidFrom = dateValidFrom;
    }

    @Basic
    @Column(name = "date_valid_to")
    public Timestamp getDateValidTo() {
        return dateValidTo;
    }

    public void setDateValidTo(Timestamp dateValidTo) {
        this.dateValidTo = dateValidTo;
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

        LcSlidesEntity that = (LcSlidesEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (priority != that.priority) return false;
        if (languages != null ? !languages.equals(that.languages) : that.languages != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (dateValidFrom != null ? !dateValidFrom.equals(that.dateValidFrom) : that.dateValidFrom != null)
            return false;
        if (dateValidTo != null ? !dateValidTo.equals(that.dateValidTo) : that.dateValidTo != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) status;
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (int) priority;
        result = 31 * result + (dateValidFrom != null ? dateValidFrom.hashCode() : 0);
        result = 31 * result + (dateValidTo != null ? dateValidTo.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
