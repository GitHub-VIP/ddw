package com.dd.shop.manager.dao;

import com.dd.shop.manager.pojo.po.Product;
import com.dd.shop.manager.pojo.vo.ProductCustom;

import java.util.List;
import java.util.Map;

public interface ProductCustomMapper {

    //long countItems(@Param("query") TbItemQuery query);
    //List<TbItemCustom> listItemsByPage(@Param("page") PageInfo page, @Param("query") TbItemQuery query);

    long countProducts(Map<String, Object> map);
    List<ProductCustom> listProductsByPage(Map<String, Object> map);

    //增
    int insert(Product product);

    //修改状态
    int updateByStatus(Product product);
    //修改商品
    Product selectById(Integer id);

    void updateProduct(Product product);


}
