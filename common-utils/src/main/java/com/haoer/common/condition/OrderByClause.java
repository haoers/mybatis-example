package com.haoer.common.condition;


import com.haoer.common.enums.OrderByDescEnum;

public class OrderByClause {

    private String sortName;

    private String desc;

    public OrderByClause() {
    }

    public OrderByClause(String sortName, OrderByDescEnum descEnum) {
        this.sortName = sortName;
        this.desc = descEnum.getDesc();
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
