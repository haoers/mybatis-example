package com.haoer.common.condition;

import org.springframework.util.ObjectUtils;

/**
 * @program: course-centre
 * @description: 课程类型
 * @author: zeng hao
 * @create: 2019-08-26 15:34
 */
public enum ConditionEnum {

    EQ(" = ", null, null, null),
    LIKE(" like ", null, "%", "%"),
    IN(" in ", "s", null, null),
    NOT_IN(" not in ", "NotIns", null, null),
    LT(" <= ", "LT", null, null),
    GT(" >= ", "GT", null, null),
    IS_NULL(" is null ", null, null, null);

    private String value;

    private String suffix;

    private String pre;

    private String append;

    ConditionEnum(String value, String suffix, String pre, String append) {
        this.value = value;
        this.suffix = suffix;
        this.pre = pre;
        this.append = append;
    }

    public String getValue() {
        return value;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPre() {
        return pre;
    }

    public String getAppend() {
        return append;
    }

    public static ConditionEnum getEnum(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (ConditionEnum e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        return null;
    }
}
