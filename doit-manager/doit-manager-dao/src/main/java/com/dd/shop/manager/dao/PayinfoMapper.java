package com.dd.shop.manager.dao;

import com.dd.shop.manager.pojo.po.Payinfo;
import com.dd.shop.manager.pojo.po.PayinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayinfoMapper {
    int countByExample(PayinfoExample example);

    int deleteByExample(PayinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Payinfo record);

    int insertSelective(Payinfo record);

    List<Payinfo> selectByExample(PayinfoExample example);

    Payinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Payinfo record, @Param("example") PayinfoExample example);

    int updateByExample(@Param("record") Payinfo record, @Param("example") PayinfoExample example);

    int updateByPrimaryKeySelective(Payinfo record);

    int updateByPrimaryKey(Payinfo record);
}