package com.zn.sitegroup.entity;

import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zn on 2018/12/13.
 */
@Entity
@Table(name = "lc_orders_items", schema = "litecart", catalog = "")
public class LcOrdersItemsEntity {
    private int id;
    private String orderId;
    private int productId;
    private String optionStockCombination;
    private String options;
    private String name;
    private String sku;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal tax;
    private BigDecimal weight;
    private String weightClass;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "option_stock_combination")
    public String getOptionStockCombination() {
        return optionStockCombination;
    }

    public void setOptionStockCombination(String optionStockCombination) {
        this.optionStockCombination = optionStockCombination;
    }

    @Basic
    @Column(name = "options")
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
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
    @Column(name = "sku")
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "tax")
    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "weight")
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "weight_class")
    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LcOrdersItemsEntity that = (LcOrdersItemsEntity) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (optionStockCombination != null ? !optionStockCombination.equals(that.optionStockCombination) : that.optionStockCombination != null)
            return false;
        if (options != null ? !options.equals(that.options) : that.options != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (tax != null ? !tax.equals(that.tax) : that.tax != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (weightClass != null ? !weightClass.equals(that.weightClass) : that.weightClass != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + (optionStockCombination != null ? optionStockCombination.hashCode() : 0);
        result = 31 * result + (options != null ? options.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (tax != null ? tax.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (weightClass != null ? weightClass.hashCode() : 0);
        return result;
    }
}
