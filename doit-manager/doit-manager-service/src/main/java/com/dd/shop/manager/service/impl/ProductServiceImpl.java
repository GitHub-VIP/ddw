package com.dd.shop.manager.service.impl;

import com.dd.shop.common.pojo.dto.PageInfo;
import com.dd.shop.common.pojo.dto.ProductResult;
import com.dd.shop.manager.dao.ProductCustomMapper;
import com.dd.shop.manager.dao.ProductMapper;
import com.dd.shop.manager.pojo.po.Product;
import com.dd.shop.manager.pojo.po.ProductExample;
import com.dd.shop.manager.pojo.vo.ProductCustom;
import com.dd.shop.manager.pojo.vo.ProductQuery;
import com.dd.shop.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    //初始化logger
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //依赖注入DAO层接口(第一个缺少的分页查询,第二个缺少求数量)
    @Autowired
    private ProductCustomMapper productCustomDao;
    @Autowired
    private ProductMapper productDao;

    //分页查询
    @Override
    public ProductResult<ProductCustom> listProductsByPage(PageInfo page, ProductQuery query) {

        ProductResult<ProductCustom> result = new ProductResult<>();
        //c查询正确的情况下返回0,否则返回非0
        result.setCode(0);
        result.setMsg("success");

        try {
            //方法一:@Param("query")  @Param("page")
            //调用DAO层接口查询商品的总数量

            //方法二   解决DAO层多参数传递问题
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("page", page);
            map.put("query", query);
            //调用DAO层接口查询商品的总数量
            long count = productCustomDao.countProducts(map);
            //调用DAO层接口将符合条件的集合查询出来
            List<ProductCustom> list = productCustomDao.listProductsByPage(map);
            result.setCount(count);
            result.setData(list);

            /*long count = itemCustomDao.countItems(query);
            //调用DAO层接口将符合条件的集合查询出来
            List<TbItemCustom> list = itemCustomDao.listItemsByPage(page,query);
            result.setCount(count);
            result.setData(list);*/

        } catch (Exception e) {
            result.setCode(1);
            result.setMsg("failed");
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }


        return result;
    }

    //批量删除
    @Override
    public int updateProductsByIds(List<Integer> ids) {

        int i = 0;
        try {

            //封装一个商品对象,携带了删除状态
            Product record = new Product();
            record.setStatus(3);
            //使用example   创建模板
            ProductExample example = new ProductExample();
            ProductExample.Criteria criteria = example.createCriteria();

            //设值
            criteria.andIdIn(ids);
            //真正执行修改操作
            i = productDao.updateByExampleSelective(record, example);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();

        }

        return i;
    }

    //增
    @Override
    public int insertProducts(Product product) {

        int i = 0;

        try {

            product.setStatus(1);

            product.setPicture("手机.jpg");

            //product.setInventory();

            Date date = new Date();
            product.setCreatedate(date);
            product.setModifytime(date);

            i = productCustomDao.insert(product);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }

        return i;
    }

    //修改状态
    @Override
    public int updateProductStatus(Product product) {

        int i = 0;
        try {

            product = productDao.selectByPrimaryKey(product.getId());

            if(product.getStatus() == 1){

                product.setStatus(2);
            }else{
                product.setStatus(1);
            }

            //record.setStatus(3);
            //使用example   创建模板
            /*ProductExample example = new ProductExample();
            ProductExample.Criteria criteria = example.createCriteria();

            //设值
            criteria.andIdEqualTo(record.getId());*/
            //真正执行修改操作
            i = productCustomDao.updateByStatus(product);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();

        }


        return i;
    }

    @Override
    public Product findProduct(Integer id) {

        Product product = null;
        try {
            product = productCustomDao.selectById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return product;
    }

    //修改商品
    @Override
    public int modifyProduct(Product product) {

       try {

           productCustomDao.updateProduct(product);

        } catch (Exception e) {

            logger.error(e.getMessage(), e);
            e.printStackTrace();

        }

        return 1;
    }


}
