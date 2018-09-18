package com.dd.shop.portal.service.impl;

import com.dd.shop.common.core.JsonUtils;
import com.dd.shop.common.core.StrKit;
import com.dd.shop.common.jedis.JedisClient;
import com.dd.shop.portal.dao.ContentMapper;
import com.dd.shop.portal.pojo.po.Content;
import com.dd.shop.portal.pojo.po.ContentExample;
import com.dd.shop.portal.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * User: DHC
 * Date: 2018/9/11
 * Time: 16:18
 * Version:V1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ContentMapper contentDao;
    @Autowired
    private JedisClient jedisClient;

    @Override
    public List<Content> listContentsByCid(Integer cid) {
        List<Content> contentList = null;
        //1 去缓存服务器中查询
        try {
            String jsonString = jedisClient.hget("CONTENTLIST", cid + "");
            if(StrKit.notBlank(jsonString)){
                //缓存中有数据
                contentList = JsonUtils.jsonToList(jsonString, Content.class);
                return contentList;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        //2 真实的业务逻辑，去数据库中查询
        ContentExample example = new ContentExample();
        ContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        contentList = contentDao.selectByExample(example);
        //3 存放一份到缓存服务器
        try {
            jedisClient.hset("CONTENTLIST", cid + "", JsonUtils.objectToJson(contentList));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return contentList;
    }
}
