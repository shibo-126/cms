package com.briup.cms.service;

import com.briup.cms.bean.Category;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ICategoryService {
    void saveAndUpdate(Category category) throws CustomerException;
    void deleteById(int id) throws CustomerException;
    Category selectById(int id) throws CustomerException;
    List<Category> selectAll() throws CustomerException;
}
