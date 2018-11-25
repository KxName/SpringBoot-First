package com.fh.shop.producer.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ProjectName: shop-cloud
 * @Package: com.fh.shop.producer.vo
 * @ClassName: Shopvo
 * @Description: java类作用描述
 * @Author: LiuPeng mll0616@163.com
 * @CreateDate: 2018/11/23 18:37
 * @UpdateUser: LiuPeng mll0616@163.com
 * @UpdateDate: 2018/11/23 18:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ShopVo implements Serializable {
    private Integer id;
    private String shopName;
    private BigDecimal price;
    private String brandName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
