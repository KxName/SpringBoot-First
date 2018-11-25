package com.fh.brand;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @ProjectName: shop-cloud
 * @Package: com.fh.brand
 * @ClassName: BrandFeignClient
 * @Description: java类作用描述
 * @Author: LiuPeng mll0616@163.com
 * @CreateDate: 2018/11/23 20:29
 * @UpdateUser: LiuPeng mll0616@163.com
 * @UpdateDate: 2018/11/23 20:29
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@FeignClient("fh-shop-brand-producer")
public interface BrandApiFeignClient extends BrandApi{
}
