package com.fh.shop.producer.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class Shop  implements Serializable {

    private  Integer id;

    private  String shopName;

    private String shopPhoto;

    private BigDecimal price;

    private Integer stock;

    private Integer brandId;

    private Double minPrice;

    private Double maxPrice;

    private Integer minStock;

    private Integer maxStock;

    private Integer category1;

    private Integer category2;

    private Integer category3;

    private String cateName;

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", shopPhoto='" + shopPhoto + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", brandId=" + brandId +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minStock=" + minStock +
                ", maxStock=" + maxStock +
                ", category1=" + category1 +
                ", category2=" + category2 +
                ", category3=" + category3 +
                ", cateName='" + cateName + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopPhoto() {
        return shopPhoto;
    }

    public void setShopPhoto(String shopPhoto) {
        this.shopPhoto = shopPhoto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getCategory1() {
        return category1;
    }

    public void setCategory1(Integer category1) {
        this.category1 = category1;
    }

    public Integer getCategory2() {
        return category2;
    }

    public void setCategory2(Integer category2) {
        this.category2 = category2;
    }

    public Integer getCategory3() {
        return category3;
    }

    public void setCategory3(Integer category3) {
        this.category3 = category3;
    }
}

