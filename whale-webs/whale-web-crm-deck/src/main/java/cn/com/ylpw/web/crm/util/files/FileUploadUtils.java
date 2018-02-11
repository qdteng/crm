package cn.com.ylpw.web.crm.util.files;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import cn.com.ylpw.web.crm.util.PropertyFiles;
import cn.com.ylpw.web.crm.util.SpringUtils;


/**
 * @ClassName: FileUploadUtils
 * @Description:文件上传工具类-后台
 * @author LT
 * @date 2016年9月15日 上午11:20:31
 */
public class FileUploadUtils {
	private static final Logger log = LoggerFactory.getLogger(FileUploadUtils.class);
	public FileUploadUtils() {}
	
	
	/**
	 * 图片
	 */
	private static final String uploadImageExtension= "jpg,jpeg,bmp,gif,png," ;
	/**
	 * flash
	 */
	private static final String uploadFlashExtension= "swf,flv," ;
	/**
	 * 多媒体
	 */
	private static final String uploadMediaExtension= "swf,flv,mp3,mp4,mov,wav,avi,rm,rmvb," ;
	/**
	 * 其他
	 */
	private static final String uploadFileExtension= "zip,rar,7z,doc,docx,xls,xlsx,ppt,pptx," ;
	
	/**
	 * 文件上传根目录名
	 */
	public static final String fileUploadRootFiled="/upload/";
	
	/**
	 * @ClassName: uploadPath
	 * @Description:文件上传目录
	 * @author LT
	 * @date 2016年9月15日 下午1:37:21
	 */
   public  enum UploadPath {  
	    
    	/**
    	 * web工程根目录
    	 */
        webRoot,
        /**
         * 硬盘目录
         */
        disk,
	   /**
        * game目录
        */
       game;
	   
	   UploadPath(){ 
		   
       }


    }
   /**
    * <p>文件上传,限制文件上传大小</p>
    * @author LT
    * @date 2016年9月19日 上午9:31:10
    * @return FileUploadEntity
    * @param multipartFile
    * @param path
    * @param request
    * @param util
    * @param maxFileSize 
    * @return
    * @throws Exception
    */
   public static  FileUploadEntity uploadFile( MultipartFile multipartFile, UploadPath path ,
		   HttpServletRequest request , FileUploadConvertUtil<?>  util , long maxFileSize ) throws Exception {
	   FileUploadEntity file = new FileUploadEntity();
	   long fileSize = multipartFile.getSize();
		if (fileSize > maxFileSize) {
			file.setErrorMsg("上传文件大小超过限制。");
			log.error("上传文件大小超过限制。");
			throw new Exception("上传文件大小超过限制。") ;
		}
	   
	   return FileUploadUtils.uploadFile(multipartFile, path, request, util);
   }
   
   /***
    * <p>文件上传,限制文件上传大小、类型</p>
    * @author LT
    * @date 2016年11月2日 下午1:14:59
    * @return FileUploadEntity
    * @param multipartFile
    * @param path
    * @param request
    * @param util
    * @param maxFileSize ， 文件上传大小
    * @param type 文件上传类型
    * @return
    * @throws Exception
    */
   public static  FileUploadEntity uploadFile( MultipartFile multipartFile, UploadPath path ,
		   HttpServletRequest request , FileUploadConvertUtil<?>  util , long maxFileSize ,int type) throws Exception {
	   
	   exitsFile(type,multipartFile);
	   
	   return FileUploadUtils.uploadFile(multipartFile, path, request, util,maxFileSize);
   }
   
   
   
   
   
   
   /***
    * <p>文件上传,限制文件上传类型</p>
    * @author LT
    * @date 2016年11月2日 下午1:14:59
    * @return FileUploadEntity
    * @param multipartFile
    * @param path
    * @param request
    * @param util
    * @param type 文件上传类型
    * @return
    * @throws Exception
    */
   public static  FileUploadEntity uploadFile( MultipartFile multipartFile, UploadPath path ,
		   HttpServletRequest request , FileUploadConvertUtil<?>  util , int type) throws Exception {
	   
	   exitsFile(type,multipartFile);
	   
	   return FileUploadUtils.uploadFile(multipartFile, path, request, util);
   }

   
   /***
    * <p>校验文件格式</p>
    * @author LT
    * @date 2016年11月2日 下午1:30:27
    * @return void
    * @param type
    * @param multipartFile
    * @throws Exception
    */
   private static void exitsFile(int type,MultipartFile multipartFile) throws Exception {
	   String ext= FilenameUtils.getExtension(multipartFile.getOriginalFilename())+","; 
	   switch (type) {
		   case 0: //图片
			   if (!uploadImageExtension.contains(ext)){
				   log.error("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]");
				   throw new Exception("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]") ;
			   }
			   break;
		   case 1: //flash
			   if (!uploadFlashExtension.contains(ext)){
				   log.error("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]");
				   throw new Exception("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]") ;
			   }
			   break;
		   case 2: //多媒体
			   if (!uploadMediaExtension.contains(ext)){
				   log.error("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]");
				   throw new Exception("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]") ;
			   } 
			   break;
		   case 3: //其他
			   if (!uploadFileExtension.contains(ext)){
				   log.error("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]");
				   throw new Exception("未知的上传文件类型["+multipartFile.getOriginalFilename()+"]") ;
			   } 
			   break;
	   }
   }
   
   
    private static  String  filePathForDisk = null ;
   

   	public static String getFilePathForDisk() {
   		if (null==filePathForDisk){
   			filePathForDisk=SpringUtils.getBean(PropertyFiles.class).getFilePathForDisk(); 
   		}
		return filePathForDisk;
	}
	
	
   /**
    * <p>文件上传</p>
    * @author LT
    * @date 2016年9月19日 上午9:25:18
    * @return FileUploadEntity
    * @param multipartFile
    * @param path
    * @param request
    * @param util
    * @return
    * @throws Exception
    */
	private static  FileUploadEntity uploadFile( MultipartFile multipartFile, UploadPath path , HttpServletRequest request , FileUploadConvertUtil<?>  util  ) throws Exception {
		
		if (multipartFile == null||StringUtils.isBlank(multipartFile.getOriginalFilename()))
			return null;
		FileUploadEntity file = new FileUploadEntity();
		//文件存储根路径
		String rootPath = "" ;
		
		//文件存储相对路径（相对根目录第一级）
		String relativePath = fileUploadRootFiled+DateFormatUtils.format( new Date(), "yyyyMMdd")+"/";
		String relativePathGame = "";
		//设置文件上传根目录
		switch (path) {
			case disk:
				file.setIsweblod(false);
				rootPath= getFilePathForDisk();
				break;
			case webRoot:
				file.setIsweblod(true);
				rootPath=getFilePathForDisk()+"static/web";
				break;
			case game:
				file.setIsweblod(true);
				rootPath=getFilePathForDisk()+"static/game";
				relativePathGame = "/game";
				break;
		}
		File tempFile = null;
		//临时文件目录
		String tempRoot = ((new StringBuilder(String.valueOf(System.getProperty("java.io.tmpdir"))))
				.append("/upload_").append(UUID.randomUUID()).append(".tmp").toString()) ;     // this.getClass().getResource("/").getFile().toString() ; 
		try {
				// 创建上传临时目录
				tempFile = new File(tempRoot);
				if (!tempFile.getParentFile().exists())
					tempFile.getParentFile().mkdirs();
				multipartFile.transferTo(tempFile);
				
				//重命名文件的文件名
				String newFileName =(new StringBuilder("")).append(UUID.randomUUID()).append(".")
						.append(FilenameUtils.getExtension(multipartFile.getOriginalFilename())).toString();
				
				relativePath += newFileName;
				
			    File localFile = new File(rootPath+relativePath);
			    //移动上传文件到存储的目录
			    FileUtils.moveFile(tempFile, localFile);
			    FileUtils.deleteQuietly(tempFile);
		
				file.setSize(multipartFile.getSize());
				//存储的文件名
				file.setName(newFileName);
				//文件全路径
				file.setPath(rootPath+relativePath);
				//相对路径
				file.setRelativePath(relativePathGame+relativePath);
				//原文件名
				file.setRefName(multipartFile.getOriginalFilename());
				//文件后缀
				file.setSuffix(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
				int type = 1 ;
				//判断文件类型
				if (uploadImageExtension.contains(multipartFile.getOriginalFilename()+",")){
					type=0;
				} 
				file.setType(type);
				
				util.convertEntity(file);
			    return file;
		} catch (Exception e) {
				log.error("文件上传失败!");
				FileUtils.deleteQuietly(tempFile);
				e.printStackTrace();
				throw new Exception("上传文件创建失败");
		}
	
		
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}

	
	
}
