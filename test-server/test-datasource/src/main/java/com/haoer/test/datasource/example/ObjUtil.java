package com.haoer.test.datasource.example;

import com.haoer.common.condition.ConditionEnum;
import com.haoer.common.condition.IBaseParams;
import com.haoer.common.condition.ICondition;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjUtil {

    /**
     * 获取model的属性及值
     *
     * @param params model.getClass()
     * @throws Exception
     */
    public static List<ObjModel> getFields(IBaseParams params) throws Exception {
        if (ObjectUtils.isEmpty(params)) {
            return null;
        }
        List<ObjModel> fields = new ArrayList<>();
        Field[] f = params.getClass().getDeclaredFields();
        ObjModel model;
        for (Field field : f) {
            String fieldName = field.getName();
            //条件
            Annotation anno = field.getAnnotation(ICondition.class);
            if (ObjectUtils.isEmpty(anno)) {
                continue;
            }
            //是否返回null值的Field
            ICondition ianno = ((ICondition) anno);
            String name = ianno.name();
            boolean customKeyFlg = false;
            ConditionEnum condition = ianno.value();
            boolean isNull = ianno.isNull();
            String orName = ianno.orName();
            Object orValue = ObjectUtils.isEmpty(ianno.orValue()) ? (ianno.orIntValue() <= -100 ? null : ianno.orIntValue()) : ianno.orValue();
            boolean customOrKeyFlg = false;
            //value
            field.setAccessible(true);
            Object value = field.get(params);
            field.setAccessible(false);
            if (ObjectUtils.isEmpty(value) && !isNull) {
                continue;
            }
            if (isNull) {
                condition = ConditionEnum.IS_NULL;
            }
            if (!StringUtils.isEmpty(name)) {
                customKeyFlg = true;
                fieldName = name;
            }
            //or该有值，需要拼接
            if ((!StringUtils.isEmpty(orName) || !ObjectUtils.isEmpty(orValue)) && !ObjectUtils.isEmpty(value)) {
                if (StringUtils.isEmpty(orName)) {
                    orName = fieldName;
                } else {
                    customOrKeyFlg = true;
                }
                if (ObjectUtils.isEmpty(orValue)) {
                    orValue = value.toString();
                }
            }

            model = new ObjModel();
            model.setKey(fieldName);
            model.setCustomKeyFlg(customKeyFlg);
            model.setValue(value);
            model.setCondition(condition);
            model.setOrName(orName);
            model.setOrValue(orValue);
            model.setCustomOrKeyFlg(customOrKeyFlg);
            fields.add(model);
        }
        return fields;
    }

    public static boolean isOkStr(Object str) {
        if (ObjectUtils.isEmpty(str)) {
            return true;
        }
        String strs = str.toString();
        if (strs.length() > 20 || strs.contains("delete ") || strs.contains("update ") || strs.contains("alter ") || strs.contains(" or ") || strs.contains(" 0=0 ")) {
            return false;
        }
        return true;
    }


    /**
     * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
     * 例如：HelloWorld->HELLO_WORLD
     *
     * @param name 转换前的驼峰式命名的字符串
     * @return 转换后下划线大写方式命名的字符串
     */
    public static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            if (name.indexOf(".") < 1) {
                result.append(name.substring(0, 1).toUpperCase());
            } else {
                return name;
            }
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0)) && !s.equals(".") && !s.equals("_") && !s.equals(" ")) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。</br>
     * 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
        } else if (!name.contains("_")) {
            // 不含下划线，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}
