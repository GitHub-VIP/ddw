package com.dd.shop.portal.service;

import com.dd.shop.portal.pojo.po.Content;

import java.util.List;

/**
 * User: DHC
 * Date: 2018/9/11
 * Time: 16:16
 * Version:V1.0
 */
public interface ContentService {

    List<Content> listContentsByCid(Integer cid);
}
