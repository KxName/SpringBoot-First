package com.fh.shop.apigateway.sysenum;

import com.fh.IEnum;

public enum TokenEnum implements IEnum {

    SIGN_IS_MISS(2004,"签名失效"),
    APPKKEY_IS_MISS(2003,"appKey无效"),
    URL_IS_ATTACK(2002,"被攻击了"),
    HEADER_TIME_OUT(2001,"请求超时"),
    HEADER_IS_MISS(2000,"头信息丢失");

    private Integer code;
    private String message;

    private TokenEnum(){

    }
    private TokenEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
