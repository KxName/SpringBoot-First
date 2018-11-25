package com.fh.brand.producers.biz;

import com.fh.ServerResponse;
import com.fh.brand.model.Brand;
import com.fh.brand.producers.mapper.IBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("brandService")
@Transactional(rollbackFor = Exception.class)
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandMapper brandMapper;


    @Override
    @Transactional(readOnly = true)
    public ServerResponse<List<Brand>> findBrandList() {
        List<Brand> brandList = brandMapper.findBrandList();
        ServerResponse<List<Brand>> success = ServerResponse.success(brandList);
        return success;
    }
    
    @Override
    @Transactional(readOnly = true)
    public ServerResponse<Brand> findBrand(Integer id) {
        Brand brand = brandMapper.findBrand(id);
        ServerResponse<Brand> success = ServerResponse.success(brand);
        return success;
    }

    @Override
    public void updateBrandAddStock(Integer id) {
        brandMapper.updateBrandAddStock(id);
    }


    @Override
    public ServerResponse addBrand(Brand brand) {
        brandMapper.addBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        return ServerResponse.success();
    }

    


}
