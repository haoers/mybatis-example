package com.haoer.test.datasource.example;


import com.haoer.common.condition.ConditionEnum;
import com.haoer.common.condition.IBaseParams;
import com.haoer.common.condition.OrderByClause;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityExample {
    protected List<OrderByClause> orderByClauses;

    protected boolean distinct = false;

    protected List<Criteria> oredCriteria;

    private Map<String, Object> customData;

    public EntityExample() {
        oredCriteria = new ArrayList<>();
    }

    public EntityExample(IBaseParams baseParams) {
        oredCriteria = new ArrayList<>();
        this.createCriteria(baseParams);
    }

    //TODO 检测字段是否合法(与实体类比较)
    public void setOrderByClauses(List<OrderByClause> orderByClauses) {
        this.orderByClauses = orderByClauses;
    }

    public List<OrderByClause> getOrderByClauses() {
        return orderByClauses;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public Map<String, Object> getCustomData() {
        return customData;
    }

    public void setCustomData(Map<String, Object> customData) {
        this.customData = customData;
    }

    public void addCustomData(String key, Object value) {
        if (CollectionUtils.isEmpty(customData)) {
            this.customData = new HashMap<>();
        }
        this.customData.put(key, value);
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or(IBaseParams baseParams) {
        Criteria criteria = createCriteriaInternal(baseParams);
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria(IBaseParams baseParams) {
        Criteria criteria = createCriteriaInternal(baseParams);
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal(IBaseParams baseParams) {
        Criteria criteria = new Criteria();
        if (ObjectUtils.isEmpty(baseParams)) {
            return criteria;
        }
        List<ObjModel> fields;
        try {
            fields = ObjUtil.getFields(baseParams);
        } catch (Exception e) {
            return null;
        }
        if (CollectionUtils.isEmpty(fields)) {
            return criteria;
        }
        fields.forEach(model -> {
            ConditionEnum conditionEnum = model.getCondition();
            String name = model.getKey();
            Object value = model.getValue();
            String orName = model.getOrName();
            Object orValue = model.getOrValue();
            if (ObjectUtils.isEmpty(conditionEnum)) {
                return;
            }
            if (!model.getCustomKeyFlg() && !StringUtils.isEmpty(conditionEnum.getSuffix())) {
                int lastIndex = name.lastIndexOf(conditionEnum.getSuffix());
                if (lastIndex > 1) {
                    name = name.substring(0, lastIndex);
                }
            }
            if (!ObjectUtils.isEmpty(value)) {
                if (!StringUtils.isEmpty(conditionEnum.getPre())) {
                    value = conditionEnum.getPre() + value;
                }
                if (!StringUtils.isEmpty(conditionEnum.getAppend())) {
                    value = value + conditionEnum.getAppend();
                }
            }
            if (!ObjectUtils.isEmpty(orValue)) {
                if (!StringUtils.isEmpty(conditionEnum.getPre())) {
                    orValue = conditionEnum.getPre() + orValue;
                }
                if (!StringUtils.isEmpty(conditionEnum.getAppend())) {
                    orValue = orValue + conditionEnum.getAppend();
                }
            }

            String condition = ObjUtil.underscoreName(name) + conditionEnum.getValue();
            if (ObjectUtils.isEmpty(value)) {
                criteria.addCriterion(condition);
            } else if (!ObjectUtils.isEmpty(orValue) && ObjUtil.isOkStr(value)) {
                String orCriterion = conditionEnum.equals(ConditionEnum.LIKE) ? conditionEnum.getValue() : ConditionEnum.EQ.getValue();
                //list
                if (value instanceof List) {
                    StringBuffer valueStr = new StringBuffer("(");
                    List valueList = ((List) value);
                    int i = 1, size = valueList.size();
                    for (Object v : valueList) {
                        if (v instanceof String) {
                            valueStr.append("'" + v + "'");
                        }
                        if (v instanceof Integer) {
                            valueStr.append(v);
                        }
                        if (i < size) {
                            valueStr.append(",");
                        }
                        i++;
                    }
                    valueStr.append(")");
                    value = valueStr.toString();
                } else if (value instanceof String) {
                    value = "'" + value + "'";
                }
                if (orValue instanceof String && !model.getCustomOrKeyFlg()) {
                    orValue = "'" + orValue + "'";
                }
                criteria.addCriterion(" ( " + condition + " " + value + " or " + ObjUtil.underscoreName(orName) + orCriterion + orValue + ")");
            } else {
                criteria.addCriterion(condition, value, model.getKey());
            }
        });
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClauses = null;
        distinct = false;
    }

}