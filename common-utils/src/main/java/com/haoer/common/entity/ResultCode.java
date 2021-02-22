package com.haoer.common.entity;

public enum ResultCode {

	/**
	 * 正确
	 **/
	OK(200, "成功"),
	/**
	 * 失败
	 **/
	FAILED_TMP(400, ""),
	/**
	 * 失败
	 */
	FAILED(401, ""),
	/**
	 * 资源没找到
	 **/
	NOT_FOUND(404, "资源没找到"),
	/**
	 * 服务器错误
	 **/
	SERVER_ERROR_CODE(500, "服务器错误"),
	/**
	 * 请求服务超时(触发fallback: 服务超时 )
	 **/
	ERROR_FALLBACK(501, "请求服务器错误"),
	/**
	 * 服务降级中
	 **/
	DOWNGRADE(502, "服务降级中"),
	/**
	 * -101至-199 是学情服务定义code
	 * 未参与相应活动
	 */
	NO_JOIN_ACTION(-101, "未参与相应活动"),

	/**
	 * 插入失败
	 */
	INSERT_FAILED(-1003, "系统异常"),
	/**
	 * 删除失败
	 */
	DELETE_FAILED(-1004, "系统异常"),
	/**
	 * 修改失败
	 */
	UPDATE_FAILED(-1005, "系统异常"),
	/**
	 * 查询失败
	 */
	SELECT_FAILED(-1006, "系统异常"),
	/**
	 * 填写参数错误
	 */
	PARAMETER_ERROR(-1007, "参数输入异常"),
	/**
	 * 对外宣称系统维护中，实际上接口已下线
	 */
	API_OFFLINE(-1008, "系统维护中"),
	/**
	 * 上传失败
	 */
	UPLOAD_FAILED(-1009, "系统异常"),
	/**
	 * 异常发生，进入fallback方法
	 */
	API_FALLBACK(-1010, "系统异常"),
	/**
	 * 异常发生，无api权限
	 */
	NO_API_CODE(-1011, "系统异常"),
	/**
	 * 异常发生，无api权限
	 */
	NO_DATA_CODE(-1012, "无数据"),
	/**
	 * 数据库内错误数据
	 */
	DATA_ERROR_CODE(-1012, "系统异常"),
	/**
	 * 触发限流
	 */
	LIMIT_ERROR_CODE(-1013, "触发限流"),

	/**
	 * 验签失败（目前是用户不存在，需要注册-登陆）
	 */
	TOKEN_ERROR_CODE( 499, "验签失败"),
	/**
	 * 参数错误
	 **/
	PARAMERROR(401, "参数错误");

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 返回结果描述
	 */
	private String msg;

	ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public final static Integer SUCCESS = 200;
	public final static Integer NODATA = 404;
	//public final static Integer PARAMERROR = 401;
	public final static Integer DATAREPEAT= 402;
	public final static Integer ERROR = 400;
}
