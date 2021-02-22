package com.haoer.common.exception;

import com.haoer.common.entity.ResultCode;

public class GlobalException extends Exception {
    private static final long serialVersionUID = -5701182284190108797L;

    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public GlobalException(GlobalException e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, int code) {
        super(message);
        this.code = code;
    }

    public GlobalException(ResultCode resultCode) {
        this(resultCode.getMsg(), resultCode.getCode());
    }

}
