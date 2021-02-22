package com.haoer.common.page;

import java.io.Serializable;
import java.util.List;

public class PageResultVO<T> implements Serializable {
    private static final long serialVersionUID = -8182090377693982269L;

    private List<T> data;

    private long total = 0;

    //自定义返回数据(json/array)
    private Object customVO;

    private PageResultVO() {
    }

    private PageResultVO(List<T> data, long total) {
        this.data = data;
        this.total = total;
    }

    public static PageResultVO getPageResultVO(List<?> data, long total) {
        return new PageResultVO(data, total);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Object getCustomVO() {
        return customVO;
    }

    public void setCustomVO(Object customVO) {
        this.customVO = customVO;
    }
}
