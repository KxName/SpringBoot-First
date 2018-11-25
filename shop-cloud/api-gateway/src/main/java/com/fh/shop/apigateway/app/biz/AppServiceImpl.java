package com.fh.shop.apigateway.app.biz;

import com.fh.RedisUtil;
import com.fh.shop.apigateway.app.mapper.IAppMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("appService")
public class AppServiceImpl implements IAppService {

    @Autowired
    private IAppMapper iAppMapper;

    @Override
    public String finAppScret(String appKey) {

        String appScret = RedisUtil.get(appKey);
        if(StringUtils.isNotEmpty(appScret)) {
            return appScret;
        }
        appScret = iAppMapper.finAppScret(appKey);
        if(StringUtils.isEmpty(appScret)) {
            return "";
        }
        return appScret;
    }
}
