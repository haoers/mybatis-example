package com.haoer.test.datasource.entity;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>说明： 用户实体类</P>
 * @version: V1.0
 * @author: zengHao
 * 
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1613965451075L;
	
	private Integer id;
    
	private String phoneNum;
    
	private Integer delFlg;
    
	private Date createTime;
    
	private Date updateTime;
    


}
