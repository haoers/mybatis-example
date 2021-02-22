package com.haoer.test.controller;

import com.haoer.common.entity.BizResult;
import com.haoer.common.utils.JsonUtils;
import com.haoer.test.VO.UserInfoVO;
import com.haoer.test.datasource.entity.User;
import com.haoer.test.datasource.example.EntityExample;
import com.haoer.test.datasource.mapper.UserMapper;
import com.haoer.test.param.UserInfoParam;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户api(无需登陆校验)
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "user", produces = "application/json")
public class UserApi {
    private static final Logger LOG = LoggerFactory.getLogger(UserApi.class);
    private static String DESC = "用户-";

    private final UserMapper userMapper;

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping(value = "/info")
    public BizResult<UserInfoVO> getUserInfo(@Valid UserInfoParam param) {
        List<User> userList = userMapper.selectByExample(new EntityExample(param));
        if (CollectionUtils.isEmpty(userList)) {
            LOG.info("{}get info fail. param:{}", DESC, JsonUtils.objectToString(param));
            return BizResult.errorParam();
        }
        UserInfoVO VO = new UserInfoVO();
        BeanUtils.copyProperties(userList.get(0), VO);
        return BizResult.success(VO);
    }


}
