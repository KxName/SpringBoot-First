package com.fh.brand.producers.biz;

import com.fh.ServerResponse;
import com.fh.brand.model.Brand;

import java.util.List;

public interface IBrandService {

    public ServerResponse<List<Brand>> findBrandList();

    ServerResponse addBrand(Brand brand) ;

    ServerResponse deleteBrand(Integer id);

    ServerResponse updateBrand(Brand brand);

    ServerResponse<Brand> findBrand(Integer id);

    void updateBrandAddStock(Integer id);
}
