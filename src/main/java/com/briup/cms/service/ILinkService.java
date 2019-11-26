package com.briup.cms.service;

import com.briup.cms.bean.Link;
import com.briup.cms.exception.CustomerException;

import java.util.List;

public interface ILinkService {
    void saveOrUpdateLink(Link link) throws CustomerException;
    void deleteById(int id) throws CustomerException;
    Link selectById(int id) throws CustomerException;
    List<Link> selectAll() throws CustomerException;
}
