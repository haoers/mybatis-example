package com.haoer.common.enums;

import org.springframework.util.ObjectUtils;

public enum OrderByDescEnum {

    ASC("asc"),
    DESC("desc");

    private String desc;

    OrderByDescEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static OrderByDescEnum getEnum(String desc) {
        if (ObjectUtils.isEmpty(desc)) {
            return null;
        }
        for (OrderByDescEnum e : values()) {
            if (e.getDesc().equals(desc)) {
                return e;
            }
        }
        return null;
    }
}
