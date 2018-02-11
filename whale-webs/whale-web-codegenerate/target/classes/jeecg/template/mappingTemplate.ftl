<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${bussiPackage}.mapper.${entityPackage}.${entityName}EntityMapper" >
  <resultMap id="BaseResultMap" type="${bussiPackage}.entity.${entityPackage}.${entityName}Entity" >
			<id column="ID" property="id" jdbcType="BIGINT" />
	<#list originalColumns as po>
		<#if po.fieldDbName!="ID" >
			<result column="${po.fieldDbName}" property="${po.fieldName}"  />
		</#if>
	</#list>
  </resultMap>
  
  <sql id="Base_Column_List" >
     <#list originalColumns as po>
		${po.fieldDbName}<#if po_has_next>,</#if>
	</#list>
  </sql>
  
  <insert id="insertSelective" parameterType="${bussiPackage}.entity.${entityPackage}.${entityName}Entity" >
    insert into ${tableName}
    <trim prefix="(" suffix=")" suffixOverrides="," >
      <#list originalColumns as po>
	      <if test="${po.fieldName} != null" >
	        ${po.fieldDbName},
	      </if>
      </#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
     <#list originalColumns as po>
	      <if test="${po.fieldName} != null" >
	        ${'#'}{${po.fieldName}},
	      </if>
      </#list>
    </trim>
  </insert>
  
  
   <delete id="deleteByPrimaryKey" parameterType="java.lang.Long" flushCache="true"  >
    delete from ${tableName}
    where ID = ${'#'}{id,jdbcType=BIGINT}
  </delete>
  
   <update id="updateByPrimaryKeySelective" parameterType="${bussiPackage}.entity.${entityPackage}.${entityName}Entity" flushCache="true" >
    update ${tableName}
    <set >
     	<#list originalColumns as po>
	      <if test="${po.fieldName} != null" >
	        ${po.fieldDbName} = ${'#'}{${po.fieldName}},
	      </if>
       </#list>
    </set>
    where ID = ${'#'}{id,jdbcType=BIGINT}
  </update>
  
  <select id="selectByPrimaryKey" resultMap="BaseResultMap" parameterType="java.lang.Long" >
    select 
    <include refid="Base_Column_List" />
    from ${tableName}
    where ID = ${'#'}{id,jdbcType=BIGINT}
  </select>
  
  <select id="pageFind" resultType="java.util.HashMap" parameterType="java.util.Map">
  	 SELECT <include refid="Base_Column_List" />  FROM  ${tableName}    WHERE  1=1 
  	 <if test="id != null and id != '' ">
	   	  AND  ID =${'#'}{id}
   	 </if>
  </select>
  
  <delete id="batchDel" parameterType="java.lang.Long" flushCache="true" >
        DELETE FROM ${tableName} WHERE ID in
        <foreach item="id" collection="ids" open="(" separator="," close=")">
            ${'#'}{id}
        </foreach>
   </delete>
  
</mapper>