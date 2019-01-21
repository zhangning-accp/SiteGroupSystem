package com.zn.sitegroup.entity;

import java.math.BigDecimal;
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
@Table(name = "dc_rules", schema = "litecart", catalog = "")
public class DcRulesEntity {
    private long id;
    private String categories;
    private String productGroups;
    private String optionGroups;
    private Integer ruleType;
    private String seoInfo;
    private BigDecimal productPrice;
    private String filterName;
    private Integer mathingRule;
    private BigDecimal quantity;
    private Date dateUpdated;
    private Date dateCreated;
    private String description;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "categories")
    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Basic
    @Column(name = "product_groups")
    public String getProductGroups() {
        return productGroups;
    }

    public void setProductGroups(String productGroups) {
        this.productGroups = productGroups;
    }

    @Basic
    @Column(name = "option_groups")
    public String getOptionGroups() {
        return optionGroups;
    }

    public void setOptionGroups(String optionGroups) {
        this.optionGroups = optionGroups;
    }

    @Basic
    @Column(name = "rule_type")
    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    @Basic
    @Column(name = "seo_info")
    public String getSeoInfo() {
        return seoInfo;
    }

    public void setSeoInfo(String seoInfo) {
        this.seoInfo = seoInfo;
    }

    @Basic
    @Column(name = "product_price")
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "filter_name")
    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    @Basic
    @Column(name = "mathing_rule")
    public Integer getMathingRule() {
        return mathingRule;
    }

    public void setMathingRule(Integer mathingRule) {
        this.mathingRule = mathingRule;
    }

    @Basic
    @Column(name = "quantity")
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DcRulesEntity that = (DcRulesEntity) o;

        if (id != that.id) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (productGroups != null ? !productGroups.equals(that.productGroups) : that.productGroups != null)
            return false;
        if (optionGroups != null ? !optionGroups.equals(that.optionGroups) : that.optionGroups != null) return false;
        if (ruleType != null ? !ruleType.equals(that.ruleType) : that.ruleType != null) return false;
        if (seoInfo != null ? !seoInfo.equals(that.seoInfo) : that.seoInfo != null) return false;
        if (productPrice != null ? !productPrice.equals(that.productPrice) : that.productPrice != null) return false;
        if (filterName != null ? !filterName.equals(that.filterName) : that.filterName != null) return false;
        if (mathingRule != null ? !mathingRule.equals(that.mathingRule) : that.mathingRule != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (dateUpdated != null ? !dateUpdated.equals(that.dateUpdated) : that.dateUpdated != null) return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (productGroups != null ? productGroups.hashCode() : 0);
        result = 31 * result + (optionGroups != null ? optionGroups.hashCode() : 0);
        result = 31 * result + (ruleType != null ? ruleType.hashCode() : 0);
        result = 31 * result + (seoInfo != null ? seoInfo.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (filterName != null ? filterName.hashCode() : 0);
        result = 31 * result + (mathingRule != null ? mathingRule.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (dateUpdated != null ? dateUpdated.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
