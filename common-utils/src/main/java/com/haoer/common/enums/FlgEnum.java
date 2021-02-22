package com.haoer.common.enums;

import org.springframework.util.ObjectUtils;

/**
 * @program: course-centre
 * @description: 课程类型
 * @author: zeng hao
 * @create: 2019-08-26 15:34
 */
public enum FlgEnum {

    FALSE(0, false),
    TRUE(1, true);


    private int value;

    private boolean flg;


    FlgEnum(Integer value, boolean flg) {
        this.value = value;
        this.flg = flg;
    }

    public int getValue() {
        return value;
    }

    public boolean isFlg() {
        return flg;
    }

    public static FlgEnum getEnum(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (FlgEnum e : values()) {
            if (e.getValue() == value) {
                return e;
            }
        }
        return null;
    }

    public static FlgEnum getEnum(Boolean flg) {
        if (ObjectUtils.isEmpty(flg)) {
            return null;
        }
        for (FlgEnum e : values()) {
            if (e.isFlg() == flg) {
                return e;
            }
        }
        return null;
    }

    public static boolean getFlg(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return false;
        }
        for (FlgEnum e : values()) {
            if (e.getValue() == value) {
                return e.isFlg();
            }
        }
        return false;
    }
}
