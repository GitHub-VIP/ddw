package com.dd.shop.portal.dao;


import com.dd.shop.portal.pojo.po.Contentcategory;
import com.dd.shop.portal.pojo.po.ContentcategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentcategoryMapper {
    int countByExample(ContentcategoryExample example);

    int deleteByExample(ContentcategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Contentcategory record);

    int insertSelective(Contentcategory record);

    List<Contentcategory> selectByExample(ContentcategoryExample example);

    Contentcategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Contentcategory record, @Param("example") ContentcategoryExample example);

    int updateByExample(@Param("record") Contentcategory record, @Param("example") ContentcategoryExample example);

    int updateByPrimaryKeySelective(Contentcategory record);

    int updateByPrimaryKey(Contentcategory record);
}