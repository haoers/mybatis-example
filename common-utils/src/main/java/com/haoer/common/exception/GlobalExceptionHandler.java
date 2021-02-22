package com.haoer.common.exception;

//import com.alibaba.fastjson.JSONObject;
//import com.putaoabc.phonics.common.entity.BizResult;
//import com.putaoabc.phonics.common.entity.ResultCode;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.BindException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 全局异常处理
// */
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    private Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//
//    /**
//     * 自定义异常处理
//     *
//     * @param req
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value = GlobalException.class)
//    @ResponseBody
//    public String jsonErrorHandler(HttpServletRequest req, GlobalException e) throws Exception {
//        LOG.error("jsonErrorHandler:", e);
//        return JSONObject.toJSONString(BizResult.error(e.getCode(), e.getMessage()));
//    }
//
//    @ExceptionHandler(value = GlobalRuntimeException.class)
//    @ResponseBody
//    public String jsonRuntimeErrorHandler(HttpServletRequest req, GlobalRuntimeException e) throws Exception {
//        LOG.error("jsonRuntimeErrorHandler:", e);
//        return JSONObject.toJSONString(BizResult.error(e.getCode(), e.getMessage()));
//    }
//
//    /**
//     * 系统异常处理，比如：4XX,5XX
//     *
//     * @param req
//     * @param e
//     * @return
//     * @throws Exception
//     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        BizResult bizResult;
//        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
//            bizResult = new BizResult(ResultCode.NOT_FOUND);
//        } else if (e instanceof BindException) {//参数绑定异常
//            bizResult = new BizResult(ResultCode.PARAMETER_ERROR);
//        } else if (e instanceof HttpMessageNotReadableException) {//参数绑定异常
//            bizResult = new BizResult(ResultCode.PARAMETER_ERROR);
//        } else {
//            bizResult = new BizResult(ResultCode.SERVER_ERROR_CODE);
//        }
//        LOG.error("defaultErrorHandler-API:{}, bizResult:{}, error:", req.getRequestURI(), bizResult, e);
//        return JSONObject.toJSONString(bizResult);
//    }
//}
