package com.fh.shop.protal.controller;


import com.fh.HttpUilt;
import com.fh.ServerResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@PropertySource("classpath:fh.properties")
public class ShopController {

    @Value("${category.list.url}")
    private String cateListUrl;
    @Value("${brand.list.url}")
    private String brandListUrl;
    @Value("${shop.add.url}")
    private String shopAddUrl;
    @Value("${shop.list.url}")
    private String shopListUrl;
    /**
     * 类型 列表
     * @param id
     * @return
     */
    @GetMapping("category/list")
    public ServerResponse findCateList(Integer id){
        String result = HttpUilt.sendGet(cateListUrl + id, null, HttpUilt.getHeader());
        Gson gson=new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     *  品牌 查询
     * @return
     */
    @GetMapping("brand/list")
    public ServerResponse findBrandList(){
        String result = HttpUilt.sendGet(brandListUrl, null, HttpUilt.getHeader());
        Gson gson=new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }

    /**
     * 商品 新增
     * @param shop
     * @return
     */
    @PostMapping("shop/add")
    public ServerResponse addShop(@RequestParam Map shop){
        System.out.println(shop);
        String result = HttpUilt.sendPost(shopAddUrl,shop,HttpUilt.getHeader());
        return ServerResponse.success();
    }

    @GetMapping("/shops")
    public ServerResponse productList() {
        String result = HttpUilt.sendGet(shopListUrl,null,HttpUilt.getHeader());
        Gson gson = new Gson();
        ServerResponse response = gson.fromJson(result, ServerResponse.class);
        return response;
    }


}
