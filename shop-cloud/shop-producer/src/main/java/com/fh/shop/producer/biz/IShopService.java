package com.fh.shop.producer.biz;

import com.fh.ServerResponse;
import com.fh.shop.producer.po.Shop;

public interface IShopService {
    ServerResponse addShop(Shop shop);

    ServerResponse findShopList();
}
