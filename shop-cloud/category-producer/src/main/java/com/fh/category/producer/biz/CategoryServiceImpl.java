package com.fh.category.producer.biz;

import com.fh.ServerResponse;
import com.fh.category.producer.mapper.ICategoryMapper;
import com.fh.category.producer.po.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
@Transactional(rollbackFor = Exception.class)
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public ServerResponse findCategoryByFatherId(Integer id) {
        List<Category> categoryList=categoryMapper.findCategoryByFatherId(id);
        return ServerResponse.success(categoryList);
    }
}
