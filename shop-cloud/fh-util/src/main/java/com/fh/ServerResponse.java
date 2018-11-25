/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:ServerResponse.java 
 * 包名:com.fh.shop.admin.common 
 * 创建日期:2018年10月18日下午7:10:56 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.fh;

import java.io.Serializable;


public class ServerResponse<T> implements Serializable{
	
	private static final long serialVersionUID = 8760105021905215735L;

	private Integer code;
	
	private String message;
	
	private T data;

	public ServerResponse() {

	}

	public static ServerResponse error(){
		return new ServerResponse(-1, "error", null);
	}
	
	public static ServerResponse error(Integer code, String message){
		return new ServerResponse(code, message, null);
	}
	
	public static ServerResponse error(IEnum systemEnum) {
	     return  new ServerResponse(systemEnum.getCode(), systemEnum.getMessage(), null);
	}
	
	public static ServerResponse success(){
		return new ServerResponse(200, "ok", null);
	}
	
	public static <T> ServerResponse<T> success(T data){
		return new ServerResponse<T>(200, "ok", data);
	}
	
	private ServerResponse(Integer code, String message, T data){
		this.code=code;
		this.message=message;
		this.data=data;
	}
	

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
	
	
	
	
	

}
