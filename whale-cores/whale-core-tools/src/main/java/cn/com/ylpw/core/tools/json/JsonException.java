/**
 * <p>Title: JsonException.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017, zj7687362@gmail.com All Rights Reserved. </p>
 * <p>Company: www.jcore.cn</p>
 * @author 张嘉杰
 * @date 2017年2月18日 下午2:21:51
 */
package cn.com.ylpw.core.tools.json;

/**
 * <p>Title: JsonException.java</p>
 * <p>Description: Json异常</p>
 * @author 张嘉杰
 * @date 2017年2月18日 下午2:21:51
 */
public class JsonException extends RuntimeException {
	
	private static final long serialVersionUID = -6976807387869528376L;

	public JsonException() {
        super();
    }

    public JsonException(String message) {
        super(message);
    }

    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonException(Throwable cause) {
        super(cause);
    }

    protected JsonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}