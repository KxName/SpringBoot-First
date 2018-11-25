package com.fh.brand.producers.mapper;

import com.fh.ServerResponse;
import com.fh.brand.model.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBrandMapper {




    @Insert("insert into t_brand (id, brandName, logo, description, stock) values(#{id}, #{brandName}, #{logo}, #{description}, #{stock})")
    void addBrand(Brand brand);

    @Delete("delete from t_brand where id=#{value}")
    void deleteBrand(Integer id);

    @Update("update t_brand set brandName=#{brandName} , logo=#{logo}, description=#{description},stock=#{stock} where id=#{id}")
    void updateBrand(Brand brand);

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "brandName", property = "brandName"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "description", property = "description"),
            @Result(column = "stock", property = "stock")
    })
    @Select("select id, brandName, logo, description,stock from t_brand")
    List<Brand> findBrandList();

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "brandName", property = "brandName"),
            @Result(column = "logo", property = "logo"),
            @Result(column = "description", property = "description"),
            @Result(column = "stock", property = "stock")
    })
    @Select("select id, brandName, logo, description,stock from t_brand where id=#{value}")
    Brand findBrand(Integer id);

    @Update("update t_brand set stock=stock+1 where id=#{value}")
    void updateBrandAddStock(Integer id);
}
