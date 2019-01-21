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
@Table(name = "dc_assgin_logs", schema = "litecart", catalog = "")
public class DcAssginLogsEntity {
    private long id;
    private long assginId;
    private String site;
    private String log;
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
    @Column(name = "assgin_id")
    public long getAssginId() {
        return assginId;
    }

    public void setAssginId(long assginId) {
        this.assginId = assginId;
    }

    @Basic
    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Basic
    @Column(name = "log")
    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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

        DcAssginLogsEntity that = (DcAssginLogsEntity) o;

        if (id != that.id) return false;
        if (assginId != that.assginId) return false;
        if (site != null ? !site.equals(that.site) : that.site != null) return false;
        if (log != null ? !log.equals(that.log) : that.log != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (assginId ^ (assginId >>> 32));
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (log != null ? log.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
