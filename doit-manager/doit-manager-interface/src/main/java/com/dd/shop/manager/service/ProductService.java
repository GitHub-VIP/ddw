package com.dd.shop.manager.service;

import com.dd.shop.common.pojo.dto.PageInfo;
import com.dd.shop.common.pojo.dto.ProductResult;
import com.dd.shop.manager.pojo.po.Product;
import com.dd.shop.manager.pojo.vo.ProductCustom;
import com.dd.shop.manager.pojo.vo.ProductQuery;

import java.util.List;

public interface ProductService {

    /**
     * 处理商品的服务层相关接口
     * 分页查询
     * @param   page 分页条件
     * @return 返回的JSON格式
     */
    ProductResult<ProductCustom> listProductsByPage(PageInfo page, ProductQuery query);

    //批量修改状态
    int updateProductsByIds(List<Integer> ids);

    //增加商品
    int insertProducts(Product product);

    //修改状态值
    int updateProductStatus(Product product);

    Product findProduct(Integer id);

    //修改商品
    int modifyProduct(Product product);


}
