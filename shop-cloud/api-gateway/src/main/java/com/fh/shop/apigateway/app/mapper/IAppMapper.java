package com.fh.shop.apigateway.app.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IAppMapper {

    @Results({
            @Result(column = "appscrect",property = "appscrect")
    })

    @Select("select appscrect from t_app where appkey = #{value}")
    String finAppScret(String appKey);


}
