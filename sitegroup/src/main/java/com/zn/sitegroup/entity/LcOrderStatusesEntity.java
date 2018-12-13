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
@Table(name = "lc_order_statuses", schema = "litecart", catalog = "")
public class LcOrderStatusesEntity {
    private int id;
    private String icon;
    private String color;
    private byte isSale;
    private byte isArchived;
    private byte notify;
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
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "is_sale")
    public byte getIsSale() {
        return isSale;
    }

    public void setIsSale(byte isSale) {
        this.isSale = isSale;
    }

    @Basic
    @Column(name = "is_archived")
    public byte getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(byte isArchived) {
        this.isArchived = isArchived;
    }

    @Basic
    @Column(name = "notify")
    public byte getNotify() {
        return notify;
    }

    public void setNotify(byte notify) {
        this.notify = notify;
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

        LcOrderStatusesEntity that = (LcOrderStatusesEntity) o;

        if (id != that.id) return false;
        if (isSale != that.isSale) return false;
        if (isArchived != that.isArchived) return false;
        if (notify != that.notify) return false;
        if (priority != that.priority) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (int) isSale;
        result = 31 * result + (int) isArchived;
        result = 31 * result + (int) notify;
        result = 31 * result + (int) priority;
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
