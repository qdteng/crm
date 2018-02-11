/**
 * <p>Title: Jsons.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月18日 下午2:19:33
 */
package cn.com.ylpw.core.tools.json;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.ylpw.core.tools.StringTool;

/**
 * <p>Title: Jsons.java</p>
 * <p>Description: Json解析</p>
 * @author 张嘉杰
 * @date 2017年2月18日 下午2:19:33
 */
@SuppressWarnings("unchecked")
public class Jsons {
	
	/**
     * 忽略对象中值为NULL或""的属性
     */
    public static final Jsons EXCLUDE_EMPTY = new Jsons(JsonInclude.Include.NON_EMPTY);

    /**
     * 忽略对象中值为默认值的属性
     */
    public static final Jsons EXCLUDE_DEFAULT = new Jsons(JsonInclude.Include.NON_DEFAULT);

    /**
     * 默认不排除任何属性
     */
    public static final Jsons DEFAULT = new Jsons();

    private ObjectMapper mapper;

    private Jsons() {
        mapper = new ObjectMapper();
        // ignore attributes exists in json string, but not in java object when deserialization
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    private Jsons(JsonInclude.Include include) {
        mapper = new ObjectMapper();
        // set serialization feature
        mapper.setSerializationInclusion(include);
        // ignore attributes exists in json string, but not in java object when deserialization
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    /**
     * 实体转换为json
     * @param target 目标实体
     * @return json字符串
     */
    public String toJson(Object target) {
        try {
            return mapper.writeValueAsString(target);
        } catch (IOException e) {
            throw new JsonException(e);
        }
    }

    /**
     * 序列号json为实体
     * @param json json字符串
     * @param target 目标对象class
     * @return 符合规则的实体对象
     */
    public <T> T fromJson(String json, Class<T> target) {
        if (StringTool.isNullOrEmpty(json)) {
            return null;
        }
        try {
            return mapper.readValue(json, target);
        } catch (IOException e) {
            throw new JsonException(e);
        }
    }

    /**
     * 反序列化
     * @param javaType JavaType
     * @param jsonString json string
     * @param <T> the generic type
     * @see #createCollectionType(Class, Class...)
     * @return the javaType's object
     * @throws JsonException the exception for json
     */
    
    /**
     * 反序列化
     * @param jsonString json字符串
     * @param javaType java类型
     * @return 符合规则的java类型对象
     */
	public <T> T fromJson(String jsonString, JavaType javaType) {
        if (StringTool.isNullOrEmpty(jsonString)) {
            return null;
        }
        try {
            return (T) mapper.readValue(jsonString, javaType);
        } catch (Exception e) {
            throw new JsonException(e);
        }
    }

	/**
	 * 创建集合类型
	 * @param collectionClass ArrayList, HashMap, ...
	 * @param elementClasses 节点Class
	 * @return 符合类型的 JavaType
	 */
    public JavaType createCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
	
}
