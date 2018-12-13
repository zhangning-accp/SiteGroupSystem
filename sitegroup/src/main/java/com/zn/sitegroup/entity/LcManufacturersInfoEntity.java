package com.zn.sitegroup.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zn on 2018/12/13.
 */
@Entity
@Table(name = "lc_manufacturers_info", schema = "litecart", catalog = "")
public class LcManufacturersInfoEntity {
    private int id;
    private int manufacturerId;
    private String languageCode;
    private String shortDescription;
    private String description;
    private String h1Title;
    private String headTitle;
    private String metaDescription;
    private String link;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "manufacturer_id")
    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
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
    @Column(name = "short_description")
    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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
    @Column(name = "h1_title")
    public String getH1Title() {
        return h1Title;
    }

    public void setH1Title(String h1Title) {
        this.h1Title = h1Title;
    }

    @Basic
    @Column(name = "head_title")
    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(String headTitle) {
        this.headTitle = headTitle;
    }

    @Basic
    @Column(name = "meta_description")
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcManufacturersInfoEntity that = (LcManufacturersInfoEntity) o;

        if (id != that.id) return false;
        if (manufacturerId != that.manufacturerId) return false;
        if (languageCode != null ? !languageCode.equals(that.languageCode) : that.languageCode != null) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (h1Title != null ? !h1Title.equals(that.h1Title) : that.h1Title != null) return false;
        if (headTitle != null ? !headTitle.equals(that.headTitle) : that.headTitle != null) return false;
        if (metaDescription != null ? !metaDescription.equals(that.metaDescription) : that.metaDescription != null)
            return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + manufacturerId;
        result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (h1Title != null ? h1Title.hashCode() : 0);
        result = 31 * result + (headTitle != null ? headTitle.hashCode() : 0);
        result = 31 * result + (metaDescription != null ? metaDescription.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
}
