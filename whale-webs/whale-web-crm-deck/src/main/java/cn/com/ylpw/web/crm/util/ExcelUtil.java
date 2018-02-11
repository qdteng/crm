package cn.com.ylpw.web.crm.util;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.imports.ExcelImportServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);
	
	public  interface callback {
		public String   excute();
		public Boolean  isReload();
		public WritableCell reload(int j, int rows, String value, String[] titles);
	}
	
	/**
	 * 
	 */
	public static <T> List<T> importExcel(InputStream inputStream, Class<?> pojoClass, ImportParams params) throws Exception {
		return new ExcelImportServer().importExcelByIs(inputStream, pojoClass, params).getList();
	}
	
	
	public static <T> List<T> exportExcel(InputStream inputStream, Class<?> pojoClass, ImportParams params) throws Exception {
		return new ExcelImportServer().importExcelByIs(inputStream, pojoClass, params).getList();
	}
	
	/**
	 * <p>扩展的导出</p>
	 * @author LT
	 * @date 2017年1月25日 上午10:09:46
	 * @return void
	 * @param fileName
	 * @param encoding
	 * @param titles
	 * @param contents
	 * @param pagingSize
	 * @param response
	 * @param callback 回调方法 ，用户列合并 重写excel 等 ，详见引用
	 * @param timestr
	 */
	public static void exportExcel2(String fileName,String encoding,
			String[] titles, List<String[]> contents, int pagingSize,HttpServletResponse response, ExcelUtil.callback callback ,  String   timestr){
		
		Map<String,Object>  param = new HashMap<String,Object>();
		param.put("timestr", timestr);
		
		ExcelUtil.exportExcel3(fileName, encoding, titles, contents, pagingSize, response ,  callback ,  param);
	}
	
	/**
	 * 
	 * User:T.L
	 * Description:导出Excel工具类,文件标题必须有,且内容数组要与标题数组下标对应.分页标志为0时表示不分页
	 * @param fileName 文件名称
	 * @param encoding 文件名称编码(可传null或空,默认为GB2312)
	 * @param titles excel标题数组
	 * @param contents excel内容数组,内容必须与标题对应.
	 * @param pagingSize 分页(每页显示多少条,参数为 0 时不分页.)
	 * @param response
	 *
	 */
	@SafeVarargs
	public static void exportExcel3(String fileName,String encoding,
			String[] titles, List<String[]> contents, int pagingSize,
			HttpServletResponse response,ExcelUtil.callback callback ,  Map<String,Object>... param){
		if(null==fileName || "".equals(fileName)){
			fileName="excel";
		}
		if(null==encoding || "".equals(encoding)){
			encoding = "GB2312";
		}
		String value = "";
		String[] cs = null;
		OutputStream os=null;
		int page = 1;
		int rows = 1;//行数
		try {
			os = response.getOutputStream();
			response.reset();
			
			
			if (null!=param&&param.length>0&&null!=param[0].get("timestr")){
				
				response.setHeader("Content-disposition","attachment; filename=" 
						+ new String(fileName.getBytes(encoding),"ISO-8859-1")+"_"+param[0].get("timestr").toString()+".xls");
			}else {
				response.setHeader("Content-disposition","attachment; filename=" 
						+ new String(fileName.getBytes(encoding),"ISO-8859-1")+"_"+DateFormatUtils.format(new Date(), "yyyyMMdd")+".xls");
			}
			response.setContentType("aplication/msexcel");
			
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet("第"+page+"页", (page-1));
			Label label = null;
			for(int i=0; i<titles.length; i++){
				label = new Label(i,0,titles[i]);
				ws.addCell(label);
			}
			
			for(int i=0; i<contents.size(); i++){
				if(pagingSize!=0 && i%pagingSize==0 && i>0){
					page++;
					rows=1;
					ws = wwb.createSheet("第"+page+"页", (page-1));
					for(int ii=0; ii<titles.length; ii++){
						label = new Label(ii,0,titles[ii]);
						ws.addCell(label);
					}
				}
				
				
				
				for(int j=0; j<titles.length; j++){
					cs = contents.get(i);
					value = cs[j];
					if(null==value || "".equals(value) || "null".equals(value)){
						value="";
					}
//					if(titles[j].equals("号码簿编号") || titles[j].equals("快递单号") || titles[j].equals("保险单号") || titles[j].equals("证件信息") ){
					
					if (null!=callback&&callback.isReload()){
						//重写
						ws.addCell(callback.reload(j,rows,value,titles));
					}else {
						//不合并的列判断
						if(null!=callback&&callback.excute().contains(titles[j]+",") ){
							label = new Label(j,rows,value);
							ws.addCell(label);
						}else {
							if(NumberUtils.isNumber(value)){//是数值形式，则转换成数值形式，方便财务导出报表后统计
			       				jxl.write.Number number  =   new  jxl.write.Number( j ,  rows , NumberUtils.toDouble(value.toString()));
			       				ws.addCell(number);
			       			}else{
			       				label = new Label(j,rows,value);
								ws.addCell(label);
			       			}
						}
					}
					
				}
				
				rows++;
			}
			
			wwb.write();
			wwb.close();
			os.flush();
			os.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * User:T.L
	 * Description:导出Excel工具类,文件标题必须有,且内容数组要与标题数组下标对应.分页标志为0时表示不分页，生成后放在服务器上
	 * @param fileName 文件名称
	 * @param encoding 文件名称编码(可传null或空,默认为GB2312)
	 * @param titles excel标题数组
	 * @param contents excel内容数组,内容必须与标题对应.
	 * @param pagingSize 分页(每页显示多少条,参数为 0 时不分页.)
	 * @param response
	 *
	 */
	@SafeVarargs
	public static void exportExcel4(String fileName,String encoding,
			String[] titles, List<String[]> contents, int pagingSize,
			HttpServletResponse response,ExcelUtil.callback callback ,  Map<String,Object>... param){
		if(null==fileName || "".equals(fileName)){
			fileName="excel";
		}
		if(null==encoding || "".equals(encoding)){
			encoding = "GB2312";
		}
		String value = "";
		String[] cs = null;
		File file = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static/"+param[0].get("path").toString()+fileName+".xls"); 
		File fileParent = file.getParentFile();  
		if(!fileParent.exists()){  
		    fileParent.mkdirs();  
		}  
		
//        OutputStream os = null;
		int page = 1;
		int rows = 1;//行数
		try {
			file.createNewFile();
			
//			os = response.getOutputStream();
//			response.reset();
//			
//			
//			if (null!=param&&param.length>0&&null!=param[0].get("timestr")){
//				
//				response.setHeader("Content-disposition","attachment; filename=" 
//						+ new String(fileName.getBytes(encoding),"ISO-8859-1")+"_"+param[0].get("timestr").toString()+".xls");
//			}else {
//				response.setHeader("Content-disposition","attachment; filename=" 
//						+ new String(fileName.getBytes(encoding),"ISO-8859-1")+"_"+DateFormatUtils.format(new Date(), "yyyyMMdd")+".xls");
//			}
//			response.setContentType("aplication/msexcel");
			
			WritableWorkbook wwb = Workbook.createWorkbook(file);
			WritableSheet ws = wwb.createSheet("第"+page+"页", (page-1));
			Label label = null;
			for(int i=0; i<titles.length; i++){
				label = new Label(i,0,titles[i]);
				ws.addCell(label);
			}
			
			for(int i=0; i<contents.size(); i++){
				if(pagingSize!=0 && i%pagingSize==0 && i>0){
					page++;
					rows=1;
					ws = wwb.createSheet("第"+page+"页", (page-1));
					for(int ii=0; ii<titles.length; ii++){
						label = new Label(ii,0,titles[ii]);
						ws.addCell(label);
					}
				}
				
				
				
				for(int j=0; j<titles.length; j++){
					cs = contents.get(i);
					value = cs[j];
					if(null==value || "".equals(value) || "null".equals(value)){
						value="";
					}
//					if(titles[j].equals("号码簿编号") || titles[j].equals("快递单号") || titles[j].equals("保险单号") || titles[j].equals("证件信息") ){
					
					if (null!=callback&&callback.isReload()){
						//重写
						ws.addCell(callback.reload(j,rows,value,titles));
					}else {
						//不合并的列判断
						if(null!=callback&&callback.excute().contains(titles[j]+",") ){
							label = new Label(j,rows,value);
							ws.addCell(label);
						}else {
							if(NumberUtils.isNumber(value)){//是数值形式，则转换成数值形式，方便财务导出报表后统计
			       				jxl.write.Number number  =   new  jxl.write.Number( j ,  rows , NumberUtils.toDouble(value.toString()));
			       				ws.addCell(number);
			       			}else{
			       				label = new Label(j,rows,value);
								ws.addCell(label);
			       			}
						}
					}
					
				}
				
				rows++;
			}
			
			wwb.write();
			wwb.close();
//			os.flush();
//			os.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
}
