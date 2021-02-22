package com.haoer.common.page;

import com.haoer.common.condition.OrderByClause;
import org.springframework.util.ObjectUtils;

public class PageParam extends OrderByClause {

    //分页pageNum最大数
    public static final int PAGE_MAX_NUM = 1000;

    //分页pageSize最大数
    public static final int PAGE_MAX_SIZE = 50;

    //第几页
    private Integer pageNum;

    //每页几条
    private Integer pageSize;

    public Integer getPageNum() {
        pageNum = (ObjectUtils.isEmpty(pageNum) || pageNum < 1) ? 1 : pageNum;
        if (pageNum > PAGE_MAX_NUM) {
            pageNum = PAGE_MAX_NUM;
        }
        return pageNum;
    }

    public Integer getPageSize() {
        pageSize = (ObjectUtils.isEmpty(pageSize) || pageNum < 1) ? 10 : pageSize;
        if (pageSize > PAGE_MAX_SIZE) {
            pageSize = PAGE_MAX_SIZE;
        }
        return pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
