package com.fh.brand;

import com.fh.ServerResponse;
import com.fh.brand.model.Brand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: shop-cloud
 * @Package: com.fh.brand
 * @ClassName: BrandApi
 * @Description: java类作用描述
 * @Author: LiuPeng mll0616@163.com
 * @CreateDate: 2018/11/23 20:12
 * @UpdateUser: LiuPeng mll0616@163.com
 * @UpdateDate: 2018/11/23 20:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface BrandApi {

    /**
     *  品牌 查询
     * @return
     */
    @GetMapping("/brand/list")
    public ServerResponse<List<Brand>> findBrandList();

    /**
     *  品牌 查询 (id)
     * @return
     */
    @GetMapping("/brand")
    public ServerResponse<Brand> findBrand(@RequestParam("id") Integer id);

    /**
     *  品牌 新增
     * @param brand
     * @return
     */
    @PostMapping("/brand/add")
    public ServerResponse addBrand(@RequestBody Brand brand);

    /**
     *  品牌 删除
     * @param id
     * @return
     */
    @DeleteMapping("/brand/{id}")
    public ServerResponse deleteBrand(@RequestParam("id") Integer id);


    /**
     * 品牌 修改
     * @param brand
     * @return
     */
    @PutMapping("/brand/update")
    public ServerResponse updateBrand(@RequestBody Brand brand);

    @PutMapping("/brand/addStock")
    void addBrandStock(@RequestParam("id")Integer id);
}
