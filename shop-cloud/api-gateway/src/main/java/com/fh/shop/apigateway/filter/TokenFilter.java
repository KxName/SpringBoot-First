package com.fh.shop.apigateway.filter;

import com.fh.CheckSumBuilder;
import com.fh.RedisUtil;
import com.fh.ServerResponse;
import com.fh.shop.apigateway.app.biz.AppServiceImpl;
import com.fh.shop.apigateway.sysenum.TokenEnum;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //filter的类型 pre routing post error
    }

    @Override
    public int filterOrder() {
        return 0; //顺序 数量越小优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; //是否执行该filter true或false
    }

    private static final long EXPIER = 60*1000;
    @Autowired
    private AppServiceImpl appService;

    @Override
    public Object run() throws ZuulException {
        //获取request
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //验证头信息
        String appKey = request.getHeader("appKey");
        String time = request.getHeader("time");
        String nonce = request.getHeader("nonce");
        String sign = request.getHeader("sign");
        if (StringUtils.isEmpty(appKey) || StringUtils.isEmpty(time) || StringUtils.isEmpty(nonce) || StringUtils.isEmpty(sign)){

            ServerResponse error = ServerResponse.error(TokenEnum.HEADER_IS_MISS);
            buildResponse(currentContext, error);
            return null;
        }
        //验证是否超时 [请求时间 + 指定时间 < 服务器接收时间则超时]
        long parseTime = Long.parseLong(time);
        if (parseTime + EXPIER < System.currentTimeMillis()){
            ServerResponse error = ServerResponse.error(TokenEnum.HEADER_TIME_OUT);
            buildResponse(currentContext,error);
            return null;
        }
        //验证nonce
        boolean success = RedisUtil.setNxExpire(nonce, "1", 60);
        if (!success){
            ServerResponse error = ServerResponse.error(TokenEnum.URL_IS_ATTACK);
            buildResponse(currentContext,error);
            return null;
        }
        //验证sign
        String appScret = appService.finAppScret(appKey);
        if (StringUtils.isEmpty(appScret)){
            ServerResponse error = ServerResponse.error(TokenEnum.APPKKEY_IS_MISS);
            buildResponse(currentContext,error);
            return null;
        }
        String checkSum = CheckSumBuilder.getCheckSum(appScret, nonce, time);
        if (StringUtils.isEmpty(checkSum)){
            ServerResponse error = ServerResponse.error(TokenEnum.SIGN_IS_MISS);
            buildResponse(currentContext,error);
            return null;
        }
        return null;
    }

    private void buildResponse(RequestContext currentContext, ServerResponse error) {
        Gson gson = new Gson();
        String result = gson.toJson(error);
        currentContext.setResponseBody(result);
        currentContext.getResponse().setContentType("application/json;charset=utf-8");
        currentContext.setSendZuulResponse(false);
    }
}
