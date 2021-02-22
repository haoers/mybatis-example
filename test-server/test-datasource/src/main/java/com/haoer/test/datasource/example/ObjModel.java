package com.haoer.test.datasource.example;

import com.haoer.common.condition.ConditionEnum;

public class ObjModel {

    //属性
    private String key;
    private Boolean customKeyFlg;

    //条件
    private ConditionEnum condition;

    //值
    private Object value;

    //或值
    private String orName;
    private Object orValue;
    private Boolean customOrKeyFlg;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getCustomKeyFlg() {
        return customKeyFlg;
    }

    public void setCustomKeyFlg(Boolean customKeyFlg) {
        this.customKeyFlg = customKeyFlg;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getOrName() {
        return orName;
    }

    public void setOrName(String orName) {
        this.orName = orName;
    }

    public Object getOrValue() {
        return orValue;
    }

    public void setOrValue(Object orValue) {
        this.orValue = orValue;
    }

    public Boolean getCustomOrKeyFlg() {
        return customOrKeyFlg;
    }

    public void setCustomOrKeyFlg(Boolean customOrKeyFlg) {
        this.customOrKeyFlg = customOrKeyFlg;
    }
}
