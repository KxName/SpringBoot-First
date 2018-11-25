package com.fh.category.producer.controller;

/**
 *
 * @ProjectName:
 * @Package:        com.fh.category.producer.controller
 * @ClassName:      CategoryController
 * @Description:    商品类型  controller
 * @Author:         liupeng mll0616@163.com
 * @CreateDate:     2018/11/23 12:18
 * @UpdateUser:     刘鹏 mll0616@163.com
 * @UpdateDate:     2018/11/23 12:18
 * @UpdateRemark:
 * @Version:        1.0
 */

import com.fh.ServerResponse;
import com.fh.category.producer.biz.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CategoryController {

    @Resource(name = "categoryService")
    private ICategoryService categoryService;

    /**
     *  商品类型 查询
     * @param id
     * @return
     */
    @GetMapping("category/list/{id}")
    public ServerResponse findCategoryByFatherId(@PathVariable Integer id){

        return categoryService.findCategoryByFatherId(id);
    }

}
