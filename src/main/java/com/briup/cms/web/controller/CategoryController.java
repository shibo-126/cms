package com.briup.cms.web.controller;

import com.briup.cms.bean.Category;
import com.briup.cms.service.ICategoryService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Category")
@Api(description = "栏目管理")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/add")
    @ApiOperation("添加栏目")
    public Message saveAndUpdate (Category category){
        categoryService.saveAndUpdate(category);
        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据ID删除栏目")
    @ApiImplicitParam(name = "id",value = "栏目Id",paramType = "query",dataType = "int",required = true)
    public Message deleteById(int id){
        categoryService.deleteById(id);
        return MessageUtil.success();
    }

    @GetMapping("/selectById")
    @ApiOperation("根据ID查询栏目")
    @ApiImplicitParam(name = "id",value = "栏目Id",paramType = "query",dataType = "int",required = true)
    public Message<Category> selectById(int id){
        Category category = categoryService.selectById(id);
        return MessageUtil.success(category);
    }

    @PostMapping("/update")
    @ApiOperation("修改栏目")
    public Message update(Category category){
        categoryService.saveAndUpdate(category);
        return MessageUtil.success();
    }

    @GetMapping("/selectAll")
    @ApiOperation("查询所有栏目")
    public Message<List<Category>> selectAll(){
        List<Category> categories = categoryService.selectAll();
        return MessageUtil.success(categories);
    }
}
