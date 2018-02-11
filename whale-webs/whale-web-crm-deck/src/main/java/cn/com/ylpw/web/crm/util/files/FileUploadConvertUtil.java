package cn.com.ylpw.web.crm.util.files;

/**
 * @ClassName: FileUploadConvertUtil
 * @Description:对文件上传返回VO进行 转换
 * @author LT
 * @date 2016年9月15日 下午5:12:51
 * @param <T>
 */
public interface FileUploadConvertUtil<T> {
	public T convertEntity(FileUploadEntity uploadFile) throws Exception;
	
} ;
