package com.haoer.test.param;


import com.haoer.common.condition.ConditionEnum;
import com.haoer.common.condition.IBaseParams;
import com.haoer.common.condition.ICondition;
import com.haoer.common.enums.OrderByDescEnum;
import com.haoer.common.condition.OrderByClause;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户状态
 */
@Data
public class UserInfoParam implements IBaseParams {

    private static final long serialVersionUID = 3532151324660143176L;

    //用户id
    @NotNull
    @ICondition(name = "id", value = ConditionEnum.EQ)
    private Integer id;

    @ICondition(value = ConditionEnum.EQ)
    private Integer delFlg;

    public List<OrderByClause> getOrderByClauses() {
        List<OrderByClause> orderByClauses = new ArrayList<>();
        orderByClauses.add(new OrderByClause("create_time", OrderByDescEnum.ASC));
        return orderByClauses;
    }

}
