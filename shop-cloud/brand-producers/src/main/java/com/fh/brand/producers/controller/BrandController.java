package com.fh.brand.producers.controller;


import com.fh.ServerResponse;
import com.fh.brand.BrandApi;
import com.fh.brand.model.Brand;
import com.fh.brand.producers.biz.IBrandService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @ProjectName:
 * @Package:        com.fh.brand.producers.controller
 * @ClassName:      BrandController
 * @Description:    品牌的Controller
 * @Author:         liupeng mll0616@163.com
 * @CreateDate:     2018/11/23 12:01
 * @UpdateUser:     刘鹏 mll0616@163.com
 * @UpdateDate:     2018/11/23 12:01
 * @UpdateRemark:
 * @Version:        1.0
 */
@RestController
public class BrandController implements BrandApi {

    @Resource
    private IBrandService brandService;

    @Override
    public ServerResponse<List<Brand>> findBrandList() {
        return brandService.findBrandList();
    }

    @Override
    public ServerResponse<Brand> findBrand(Integer id) {
        return brandService.findBrand(id);
    }

    @Override
    public ServerResponse addBrand(Brand brand) {
        return brandService.addBrand(brand);
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        return brandService.deleteBrand(id);
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        return brandService.updateBrand(brand);
    }

    @Override
    public void addBrandStock(Integer id) {
        brandService.updateBrandAddStock(id);
    }
}
