package com.fh.shop.producer.controller;


import com.fh.ServerResponse;
import com.fh.shop.producer.biz.IShopService;
import com.fh.shop.producer.po.Shop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ShopController {

    @Resource(name = "shopService")
    private IShopService shopService;

    @GetMapping("shop/list")
    public ServerResponse findShopList(){

        return shopService.findShopList();
    }

    @PostMapping("/shop/add")
    public ServerResponse addShop(Shop shop){
        System.out.println(shop);
        return shopService.addShop(shop);
    }


}
