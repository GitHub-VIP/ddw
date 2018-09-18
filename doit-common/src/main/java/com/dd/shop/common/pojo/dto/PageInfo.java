package com.dd.shop.common.pojo.dto;

import java.io.Serializable;

public class PageInfo implements Serializable {

    //当前页
    private int page;
    //每页最大记录数
    private int limit;

    public int getOffset() {
        return (page - 1) * limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
