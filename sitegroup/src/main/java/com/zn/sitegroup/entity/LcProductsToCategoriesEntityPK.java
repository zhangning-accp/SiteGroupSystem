package com.zn.sitegroup.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by zn on 2018/12/13.
 */
public class LcProductsToCategoriesEntityPK implements Serializable {
    private int productId;
    private int categoryId;

    @Column(name = "product_id")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "category_id")
    @Id
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcProductsToCategoriesEntityPK that = (LcProductsToCategoriesEntityPK) o;

        if (productId != that.productId) return false;
        if (categoryId != that.categoryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + categoryId;
        return result;
    }
}
