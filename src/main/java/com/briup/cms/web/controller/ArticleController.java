package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
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
@RequestMapping("/article")
@Api(description = "信息管理")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @PostMapping("/add")
    @ApiOperation(value = "添加信息",notes = "category.code category.name 不需要输入")
    public Message saveAndUpdate(Article article){
        articleService.addArticle(article);
        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据id删除信息")
    @ApiImplicitParam(name = "id",value = "信息id",paramType = "query",dataType = "int",required = true)
    public Message deleteById(int id){
        articleService.deleteById(id);
        return MessageUtil.success();
    }

    @GetMapping("/selectById")
    @ApiOperation("根据Id查询信息")
    @ApiImplicitParam(name = "id",value = "信息Id",paramType = "query",dataType = "int",required = true)
    public Message<Article> selectById(int id){
        Article article = articleService.selectById(id);
        return MessageUtil.success(article);
    }
    @GetMapping("/selectAll")
    @ApiOperation("查询所有信息")
    public Message<List<Article>> selectAll (){
        List<Article> articles = articleService.selectAll();
        return MessageUtil.success(articles);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改信息",notes = "article.id必须填写")
    public Message update(Article article){
        articleService.addArticle(article);
        return MessageUtil.success();
    }

}
