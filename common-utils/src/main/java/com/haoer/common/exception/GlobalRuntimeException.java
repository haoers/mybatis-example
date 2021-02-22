package com.haoer.common.exception;

import com.haoer.common.entity.ResultCode;

public class GlobalRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -5701182284190108797L;

    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public GlobalRuntimeException(GlobalRuntimeException e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public GlobalRuntimeException(String message) {
        super(message);
    }

    public GlobalRuntimeException(String message, int code) {
        super(message);
        this.code = code;
    }

    public GlobalRuntimeException(ResultCode resultCode) {
        this(resultCode.getMsg(), resultCode.getCode());
    }

}
