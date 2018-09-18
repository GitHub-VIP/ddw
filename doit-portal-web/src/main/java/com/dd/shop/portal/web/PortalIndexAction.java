package com.dd.shop.portal.web;

import com.dd.shop.common.core.PropKit;
import com.dd.shop.portal.pojo.po.Content;
import com.dd.shop.portal.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: DHC
 * Date: 2018/4/24
 * Time: 15:23
 * Version:V1.0
 */
@Controller
public class PortalIndexAction {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        //0 读取配置文件
        Integer cid = PropKit.use("index.properties").getInt("lunbo.cid");//89
        //1 调用业务逻辑层进行查询
        List<Content> list = contentService.listContentsByCid(cid);
        //2 将列表存放request范围之内
        request.setAttribute("contentList",list);
        //3 转发到下一个页面
        return "index";

    }
}
