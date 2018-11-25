/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:SystemEnum.java 
 * 包名:com.fh.shop.admin.common 
 * 创建日期:2018年10月19日下午2:13:08 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.fh;

/**
 * @Author Ren
 * @Description
 * @Date 20:24 2018/11/25
 * @Param
 * @return
 **/
public enum SystemEnum implements IEnum{
	
	ERROR_USER_NAME(10001, "用户名不存在"),
    ERROR_USER_PWD(10002, "密码错误"),
	ERRPT_FAIL_LOGIN(20001,"非法登录"),
    ERROR_USER_CODE(10003, "验证码错误"),
    ERROR_NOT_EXIST(10000, "信息错误"),
	ERROR_USER_LOCK(1004,"用户已锁定"),

	SIGN_IS_ERROR(2004,"无效签名"),
	TIME_OUT(2002,"请求超时"),
	APPSCRECT_IS_EMPTY(2003,"appscrect为空"),
	NONCE_IS_TWO(2004,"请求被攻击"),
	CURRENT_LIMITING(2005,"请求被限流"),
	HEDERS_IS_EMPTY(2001,"请求头信息不完整");

	private  Integer code;
	
	private  String message;
	
	
	private SystemEnum() {

    }

    private SystemEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


	public Integer getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}
}
