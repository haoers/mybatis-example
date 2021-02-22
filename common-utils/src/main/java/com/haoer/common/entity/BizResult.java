package com.haoer.common.entity;

import java.io.Serializable;

/**
 * 业务返回结果
 * @param <T>
 * @author chongtian.xiao
 */
public class BizResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 【Biz】处理状态*/
    private Integer code;
    /** 【Biz】返回消息 */
    private String msg;
    /** 【Biz】业务数据 */
    private T data;

    public BizResult() {
    }

    public BizResult(T data) {
        this(ResultCode.SUCCESS, data, (String)null);
    }

    public BizResult(Integer code) {
        this(code, null, (String)null);
    }

    public BizResult(Integer code, String msg) {
        this(code,null, msg);
    }

    public BizResult(ResultCode resultCode) {
        this(resultCode.getCode(), null, resultCode.getMsg());
    }

    public BizResult(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    
    //	成功   
	public static <T> BizResult<T> success() {
        return new BizResult(ResultCode.SUCCESS);
    }

    public static <T> BizResult<T> success(T data) {
        return new BizResult(data);
    }
    public static <T> BizResult<T> success(T data,String msg) {
        return new BizResult(ResultCode.SUCCESS,data,msg);
    }
    
    //	失败
    public static <T> BizResult<T> error() {
        return new BizResult(ResultCode.ERROR);
    }

    public static <T> BizResult<T> error(ResultCode resultCode) {
        return new BizResult(resultCode.getCode(), resultCode.getMsg());
    }
    
    //	失败+message
    public static <T> BizResult<T> error(String msg) {
        return new BizResult(ResultCode.ERROR, msg);
    }
    //	失败+message
    public static <T> BizResult<T> error(Integer code , String msg) {
        return new BizResult(code, msg);
    }

    //	缺参失败
    public static <T> BizResult<T> errorParam() {
        return new BizResult(ResultCode.PARAMETER_ERROR);
    }

    //	缺参失败+message
    public static <T> BizResult<T> errorParam(String msg) {
        return new BizResult(ResultCode.PARAMETER_ERROR.getCode(), msg);
    }

    public boolean hasData() {
        return this.data != null;
    }

    @Override
    public String toString() {
        return "BizResult [code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + "]";
    }

	public boolean isSuccess() {
        return this.code == ResultCode.OK.getCode();
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

    
}
