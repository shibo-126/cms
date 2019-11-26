package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.service.ILinkService;
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
@RequestMapping("/link")
@Api(description = "链接管理")
public class LinkController {

    @Autowired
    private ILinkService linkSerivice;

    @PostMapping("/add")
    @ApiOperation("添加链接")
    public Message addLink(Link link){
        linkSerivice.saveOrUpdateLink(link);
        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation("根据id删除链接")
    @ApiImplicitParam(name = "id",value = "链接Id",paramType = "query",dataType = "int",required = true)
    public Message deleteById(int id){
        linkSerivice.deleteById(id);
        return MessageUtil.success();
    }

    @GetMapping("/queryById")
    @ApiOperation("根据id查询链接")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public Message<Link> selectById(int id){
        Link link = linkSerivice.selectById(id);
        return MessageUtil.success(link);
    }

    @PostMapping("/update")
    @ApiOperation("修改链接")
    public Message update(Link link){
        linkSerivice.saveOrUpdateLink(link);
        return MessageUtil.success();
    }

    @GetMapping("/selectAll")
    @ApiOperation("查询所有链接")
    public Message<List<Link>> selectAll(){
        List<Link> list = linkSerivice.selectAll();
        return MessageUtil.success(list);
    }

}
