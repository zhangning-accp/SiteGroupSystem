package com.zn.sitegroup.entity;

import java.sql.Timestamp;
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
@Table(name = "lc_product_option_trees", schema = "litecart", catalog = "")
public class LcProductOptionTreesEntity {
    private long id;
    private long productId;
    private long groupId;
    private long valueId;
    private long parentGroupId;
    private long parentValueId;
    private String links;
    private Date dateUpdate;
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
    @Column(name = "product_id")
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "group_id")
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "value_id")
    public long getValueId() {
        return valueId;
    }

    public void setValueId(long valueId) {
        this.valueId = valueId;
    }

    @Basic
    @Column(name = "parent_group_id")
    public long getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(long parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    @Basic
    @Column(name = "parent_value_id")
    public long getParentValueId() {
        return parentValueId;
    }

    public void setParentValueId(long parentValueId) {
        this.parentValueId = parentValueId;
    }

    @Basic
    @Column(name = "links")
    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    @Basic
    @Column(name = "date_update")
    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
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

        LcProductOptionTreesEntity that = (LcProductOptionTreesEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (groupId != that.groupId) return false;
        if (valueId != that.valueId) return false;
        if (parentGroupId != that.parentGroupId) return false;
        if (parentValueId != that.parentValueId) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;
        if (dateUpdate != null ? !dateUpdate.equals(that.dateUpdate) : that.dateUpdate != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long result = id;
        result = 31 * result + productId;
        result = 31 * result + groupId;
        result = 31 * result + valueId;
        result = 31 * result + parentGroupId;
        result = 31 * result + parentValueId;
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (dateUpdate != null ? dateUpdate.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return (int)result;
    }
}
