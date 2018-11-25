package com.fh.category.producer.mapper;

import com.fh.category.producer.po.Category;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ICategoryMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "categoryName", property = "categoryName"),
            @Result(column = "fatherId", property = "fatherId")
    })
    @Select("select id, categoryName, fatherId from t_category where fatherId=#{id}")
    List<Category> findCategoryByFatherId(Integer id);
}
