package com.dd.shop.manager.pojo.vo;


import com.dd.shop.manager.pojo.po.Product;

public class ProductCustom extends Product {

    //商品名称
    private String catName;

    //正常|下架
    private String statusName;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }



}
