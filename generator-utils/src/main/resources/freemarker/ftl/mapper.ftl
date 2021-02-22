<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${daoUrl}.${entityName}Mapper">

    <resultMap id="BaseResultMap" type="${entityUrl}.${entityName}">
        <#list cis as ci>
            <id column="${ci.column}" property="${ci.property}"/>
        </#list>
    </resultMap>
    <sql id="Example_Where_Clause" >
        <where >
            <foreach collection="oredCriteria" item="criteria" separator="or" >
                <if test="criteria.valid" >
                    <trim prefix="(" suffix=")" prefixOverrides="and" >
                        <foreach collection="criteria.criteria" item="criterion" >
                            <choose >
                                <when test="criterion.noValue" >
                                    and ${HL1}criterion.condition${HR}
                                </when>
                                <when test="criterion.singleValue" >
                                    and ${HL1}criterion.condition${HR} ${HL}criterion.value${HR}
                                </when>
                                <when test="criterion.betweenValue" >
                                    and ${HL1}criterion.condition${HR} ${HL}criterion.value${HR} and ${HL}criterion.secondValue${HR}
                                </when>
                                <when test="criterion.listValue" >
                                    and ${HL1}criterion.condition${HR}
                                    <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                                        ${HL}listItem${HR}
                                    </foreach>
                                </when>
                            </choose>
                        </foreach>
                    </trim>
                </if>
            </foreach>
        </where>
    </sql>
    <sql id="Base_Column_List">
        ${agile}
    </sql>

    <select id="selectById" resultMap="BaseResultMap">
        select
        <include refid="Base_Column_List"/>
        from ${table}
        where id=${HL}id${HR}
    </select>

    <select id="selectByExample" resultMap="BaseResultMap">
        select
        <if test="distinct" >
            distinct
        </if>
        <include refid="Base_Column_List" />
        from ${table}
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
        <if test="orderByClauses != null and orderByClauses.size() > 0" >
            order by
            <foreach collection="orderByClauses" item="orders" separator=",">
                ${HL1}orders.sortName${HR} ${HL1}orders.desc${HR}
            </foreach>
        </if>
    </select>

    <select id="selectCountByExample" resultType="java.lang.Integer">
        select count(1)
        from ${table}
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
    </select>

    <insert id="insertSelective" useGeneratedKeys="true" keyProperty="id">
        insert into ${table}
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <#list cis as ci>
                <if test="${ci.property} != null">
                    ${ci.column},
                </if>
            </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <#list cis as ci>
                <if test="${ci.property} != null">
                    ${HL}${ci.property}${HR},
                </if>
            </#list>
        </trim>
    </insert>

    <insert id="insertBatch" useGeneratedKeys="true" keyProperty="id" parameterType="java.util.ArrayList">
        INSERT INTO ${table}
        (${agile})
        VALUES
        <foreach collection="list" item="item" index="index" separator=",">
            <trim prefix="(" suffix=")" suffixOverrides=",">
                <#list cis as ci>
                    ${HL}item.${ci.property}${HR},
                </#list>
            </trim>
        </foreach>
    </insert>

    <update id="updateById">
        update ${table}
        <set>
            <#list cis as ci>
                <if test="${ci.property} != null">
                    ${ci.column} = ${HL}${ci.property}${HR},
                </if>
            </#list>
        </set>
        where id = ${HL}id${HR}
    </update>

    <update id="updateByExample">
        update ${table}
        <set>
            <#list cis as ci>
                <if test="${ci.property} != null">
                    ${ci.column} = ${HL}${ci.property}${HR},
                </if>
            </#list>
        </set>
        <if test="_parameter != null" >
            <include refid="Example_Where_Clause" />
        </if>
    </update>

</mapper>