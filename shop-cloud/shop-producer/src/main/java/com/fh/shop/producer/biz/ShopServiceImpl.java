package com.fh.shop.producer.biz;

import com.fh.ServerResponse;
import com.fh.brand.BrandApiFeignClient;
import com.fh.brand.model.Brand;
import com.fh.shop.producer.mapper.IShopMapper;
import com.fh.shop.producer.po.Shop;
import com.fh.shop.producer.vo.ShopVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("shopService")
@Transactional(rollbackFor = Exception.class)
public class ShopServiceImpl implements IShopService {

    @Autowired
    private IShopMapper shopMapper;
    @Autowired
    private BrandApiFeignClient brandApiFeignClient;

    @Override
    public ServerResponse addShop(Shop shop) {
        shopMapper.addShop(shop);
        Integer id = shop.getBrandId();
        brandApiFeignClient.addBrandStock(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse findShopList() {
        List<Shop> shopList = shopMapper.findShopList();
        List<ShopVo> shopVoList = new ArrayList<ShopVo>();
        for (Shop shop:shopList) {
            ShopVo shopVo = new ShopVo();
            shopVo.setId(shop.getId());
            shopVo.setShopName(shop.getShopName());
            shopVo.setPrice(shop.getPrice());
            ServerResponse<Brand> brand = brandApiFeignClient.findBrand(shop.getBrandId());
            shopVo.setBrandName(brand.getData().getBrandName());
            System.out.println(shopVo);
            shopVoList.add(shopVo);
            //shopVo.setBrandName();
        }
        ServerResponse<List<ShopVo>> success = ServerResponse.success(shopVoList);
        return success;
    }
}
