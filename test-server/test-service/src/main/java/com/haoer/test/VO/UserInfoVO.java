package com.haoer.test.VO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户
 */
@Data
public class UserInfoVO {

    //id
    private Integer id;

    private String phoneNum;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

}
