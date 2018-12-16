package com.zn.sitegroup.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import static com.zn.sitegroup.utils.StringUtil.escapeSingleQuotes;

/**
 * Created by zn on 2018/12/13.
 */
@Entity
@Table(name = "lc_product_groups_values_info", schema = "litecart", catalog = "")
public class LcProductGroupsValuesInfoEntity {
    private int id;
    private int productGroupValueId;
    private String languageCode;
    private String name;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_group_value_id")
    public int getProductGroupValueId() {
        return productGroupValueId;
    }

    public void setProductGroupValueId(int productGroupValueId) {
        this.productGroupValueId = productGroupValueId;
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
    @Column(name = "name")
    public String getName() {
        return escapeSingleQuotes(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcProductGroupsValuesInfoEntity that = (LcProductGroupsValuesInfoEntity) o;

        if (id != that.id) return false;
        if (productGroupValueId != that.productGroupValueId) return false;
        if (languageCode != null ? !languageCode.equals(that.languageCode) : that.languageCode != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productGroupValueId;
        result = 31 * result + (languageCode != null ? languageCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
