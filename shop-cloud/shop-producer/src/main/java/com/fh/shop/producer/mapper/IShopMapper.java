package com.fh.shop.producer.mapper;

import com.fh.shop.producer.po.Shop;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IShopMapper {



    @Insert("insert into t_shop (shopName, price, stock, shopPhoto, brandId, category1, category2, category3, cateName) values (#{shopName},#{price},#{stock},#{shopPhoto}, #{brandId}, #{category1}, #{category2}, #{category3}, #{cateName})")
    void addShop(Shop shop);

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "shopName", property = "shopName"),
            @Result(column = "price", property = "price"),
            @Result(column = "stock", property = "stock"),
            @Result(column = "brandId", property = "brandId")
    })
    @Select("select id,shopName,price,stock,brandId from t_shop")
    List<Shop> findShopList();
}
