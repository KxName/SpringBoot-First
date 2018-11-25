package com.fh.category.producer.biz;

import com.fh.ServerResponse;
import com.fh.category.producer.po.Category;

public interface ICategoryService {
    ServerResponse findCategoryByFatherId(Integer id);
}
