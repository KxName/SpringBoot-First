package com.fh;

public interface SystemContext {
   
	int  LOG_SUCCESS=1;
	
	int  LOG_FAILURE=0;

	int  LOG_LOCK=1;

	int  LOG_ERROR_PASS=3;

	 String COOKIE="fhid";

	 String  IPLNUIX="192.168.1.11";


	//腾讯云的cos
	//secretId
	String  SECRETID="AKIDWt1va2YFzUlogImogIky1pPlskNnQ0nK";
	String  SECRETKEY ="UnqfEXdT5TfcPzPdbJl12oKdmjeLm47z";
	String  HTTP="ap-beijing";
	String  BUCKET="wan-gu-1257664014";
	String  COS_URL="https://wan-gu-1257664014.cos.ap-beijing.myqcloud.com/";

	String SMSURL="https://api.netease.im/sms/sendcode.action";
	String TEMPLATEID="9414294";
	String CODELEN="6";
	String APPKEY="19bb3e1d25483f48ed9c297590f0c96d";
	String APPSECRET= "87e76fcac5eb";


}

