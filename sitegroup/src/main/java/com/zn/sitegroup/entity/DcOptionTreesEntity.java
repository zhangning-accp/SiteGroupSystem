package com.zn.sitegroup.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zn on 2019/1/19.
 */
@Entity
@Table(name = "dc_option_trees", schema = "litecart", catalog = "")
public class DcOptionTreesEntity {
    private long id;
    private long groupId;
    private long groupValueId;
    private long parentGroupId;
    private long parentGroupValueId;
    private String links;
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
    @Column(name = "group_id")
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_value_id")
    public long getGroupValueId() {
        return groupValueId;
    }

    public void setGroupValueId(long groupValueId) {
        this.groupValueId = groupValueId;
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
    @Column(name = "parent_group_value_id")
    public long getParentGroupValueId() {
        return parentGroupValueId;
    }

    public void setParentGroupValueId(long parentGroupValueId) {
        this.parentGroupValueId = parentGroupValueId;
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

        DcOptionTreesEntity that = (DcOptionTreesEntity) o;

        if (id != that.id) return false;
        if (groupId != that.groupId) return false;
        if (groupValueId != that.groupValueId) return false;
        if (parentGroupId != that.parentGroupId) return false;
        if (parentGroupValueId != that.parentGroupValueId) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (groupId ^ (groupId >>> 32));
        result = 31 * result + (int) (groupValueId ^ (groupValueId >>> 32));
        result = 31 * result + (int) (parentGroupId ^ (parentGroupId >>> 32));
        result = 31 * result + (int) (parentGroupValueId ^ (parentGroupValueId >>> 32));
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
