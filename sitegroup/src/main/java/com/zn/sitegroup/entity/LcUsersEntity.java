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
@Table(name = "lc_users", schema = "litecart", catalog = "")
public class LcUsersEntity {
    private int id;
    private byte status;
    private String username;
    private String password;
    private String permissions;
    private String lastIp;
    private String lastHost;
    private int loginAttempts;
    private int totalLogins;
    private Timestamp dateBlocked;
    private Timestamp dateExpires;
    private Timestamp dateActive;
    private Timestamp dateLogin;
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
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "permissions")
    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Basic
    @Column(name = "last_ip")
    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Basic
    @Column(name = "last_host")
    public String getLastHost() {
        return lastHost;
    }

    public void setLastHost(String lastHost) {
        this.lastHost = lastHost;
    }

    @Basic
    @Column(name = "login_attempts")
    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    @Basic
    @Column(name = "total_logins")
    public int getTotalLogins() {
        return totalLogins;
    }

    public void setTotalLogins(int totalLogins) {
        this.totalLogins = totalLogins;
    }

    @Basic
    @Column(name = "date_blocked")
    public Timestamp getDateBlocked() {
        return dateBlocked;
    }

    public void setDateBlocked(Timestamp dateBlocked) {
        this.dateBlocked = dateBlocked;
    }

    @Basic
    @Column(name = "date_expires")
    public Timestamp getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Timestamp dateExpires) {
        this.dateExpires = dateExpires;
    }

    @Basic
    @Column(name = "date_active")
    public Timestamp getDateActive() {
        return dateActive;
    }

    public void setDateActive(Timestamp dateActive) {
        this.dateActive = dateActive;
    }

    @Basic
    @Column(name = "date_login")
    public Timestamp getDateLogin() {
        return dateLogin;
    }

    public void setDateLogin(Timestamp dateLogin) {
        this.dateLogin = dateLogin;
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

        LcUsersEntity that = (LcUsersEntity) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (loginAttempts != that.loginAttempts) return false;
        if (totalLogins != that.totalLogins) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (permissions != null ? !permissions.equals(that.permissions) : that.permissions != null) return false;
        if (lastIp != null ? !lastIp.equals(that.lastIp) : that.lastIp != null) return false;
        if (lastHost != null ? !lastHost.equals(that.lastHost) : that.lastHost != null) return false;
        if (dateBlocked != null ? !dateBlocked.equals(that.dateBlocked) : that.dateBlocked != null) return false;
        if (dateExpires != null ? !dateExpires.equals(that.dateExpires) : that.dateExpires != null) return false;
        if (dateActive != null ? !dateActive.equals(that.dateActive) : that.dateActive != null) return false;
        if (dateLogin != null ? !dateLogin.equals(that.dateLogin) : that.dateLogin != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) status;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (permissions != null ? permissions.hashCode() : 0);
        result = 31 * result + (lastIp != null ? lastIp.hashCode() : 0);
        result = 31 * result + (lastHost != null ? lastHost.hashCode() : 0);
        result = 31 * result + loginAttempts;
        result = 31 * result + totalLogins;
        result = 31 * result + (dateBlocked != null ? dateBlocked.hashCode() : 0);
        result = 31 * result + (dateExpires != null ? dateExpires.hashCode() : 0);
        result = 31 * result + (dateActive != null ? dateActive.hashCode() : 0);
        result = 31 * result + (dateLogin != null ? dateLogin.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }
}
