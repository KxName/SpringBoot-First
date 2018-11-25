package com.fh;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class HttpUilt {

    public static Map<String,String> getHeader(){
        HashMap<String,String> header = new HashMap<String,String>();
        header.put("appkey","663fc1a7-1f44-4729-8bc2-6729a446102a");
        String time = new Date().getTime()+"";
        header.put("time",time);
        String nonce = UUID.randomUUID().toString().replace("-","0").toLowerCase()+RandomStringUtils.randomNumeric(6)+System.currentTimeMillis();
        header.put("nonce",nonce);
        String sign = CheckSumBuilder.getCheckSum("ee441cd0-7ff9-43c0-a73e-baaa6cc8d699",nonce,time);
        header.put("sign",sign);
        return header;
    }


    public static String sendPost(String url, Map<String,String> params, Map<String, String> headers){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        if(null!=headers && headers.size()>0) {
            //设置请求头
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> map = iterator.next();
                String key = map.getKey();
                String value = map.getValue();
                httpPost.addHeader(key, value);
            }
        }

        if(null!=params && params.size()>0) {
            //设置请求体
            List<NameValuePair> pairs = new ArrayList();
            Iterator<Map.Entry<String, String>> headersIterator = params.entrySet().iterator();
            while (headersIterator.hasNext()) {
                Map.Entry<String, String> map = headersIterator.next();
                String key = map.getKey();
                String value = map.getValue();
                pairs.add(new BasicNameValuePair(key, value));
            }
            UrlEncodedFormEntity entity = null;
            try {
                entity = new UrlEncodedFormEntity(pairs, "utf-8");
                httpPost.setEntity(entity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }

        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != response) {
                    response.close();
                    response=null;
                }
                if(null != httpPost) {
                    httpPost.releaseConnection();
                }
                if(null != httpClient) {
                    httpClient.close();
                    httpClient=null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static String sendGet(String url, Map<String,String> params, Map<String, String> headers){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = null;

        if(null!=params && params.size()>0) {
            //设置请求体
            List<NameValuePair> pairs = new ArrayList();
            Iterator<Map.Entry<String, String>> headersIterator = params.entrySet().iterator();
            while (headersIterator.hasNext()) {
                Map.Entry<String, String> map = headersIterator.next();
                String key = map.getKey();
                String value = map.getValue();
                pairs.add(new BasicNameValuePair(key, value));
            }

            try {
                String str = EntityUtils.toString(new UrlEncodedFormEntity(pairs, "utf-8"));
                url = url+"?"+str;


            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        httpGet = new HttpGet(url);

        if(null!=headers && headers.size()>0) {
            //设置请求头
            Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> map = iterator.next();
                String key = map.getKey();
                String value = map.getValue();
                httpGet.addHeader(key, value);
            }
        }

        CloseableHttpResponse response = null;
        String result = "";
        try {
            response = httpClient.execute(httpGet);
            result = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != response) {
                    response.close();
                    response=null;
                }
                if(null != httpGet) {
                    httpGet.releaseConnection();
                }
                if(null != httpClient) {
                    httpClient.close();
                    httpClient=null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static String httpPost(String s, Map parmas, Object o) {
        return null;
    }
}
