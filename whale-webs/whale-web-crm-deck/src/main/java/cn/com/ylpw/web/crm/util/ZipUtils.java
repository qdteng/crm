package cn.com.ylpw.web.crm.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;


import oracle.sql.BLOB;

public class ZipUtils {
    /** 
     * 将多个Excel打包成zip文件 
     * @param srcfile 
     * @param zipfile 
     */  
    public static void zipFiles(List<File> srcfile, File zipfile) {    
        byte[] buf = new byte[1024];    
        try {    
            // Create the ZIP file    
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));    
            // Compress the files    
            for (int i = 0; i < srcfile.size(); i++) {    
                File file = srcfile.get(i);    
                FileInputStream in = new FileInputStream(file);    
                // Add ZIP entry to output stream.    
                out.putNextEntry(new ZipEntry(file.getName()));    
                // Transfer bytes from the file to the ZIP file    
                int len;    
                while ((len = in.read(buf)) > 0) {    
                    out.write(buf, 0, len);    
                }    
                // Complete the entry    
                out.closeEntry();    
                in.close();    
            }    
            // Complete the ZIP file    
            out.close();   
        } catch (IOException e) {    
           e.printStackTrace();  
        }    
    }    
  //filename为单个excel的路径和excel的名称，blob就是获取的blob数据
    public static int execute(String filename, BLOB blob)
    { 
      int success = 1;
      try
      {
        File              blobFile   = new File(filename); 
        FileOutputStream  outStream  = new FileOutputStream(blobFile); 
        InputStream       inStream   = blob.getBinaryStream(); 
        int     length  = -1; 
        int     size    = blob.getBufferSize(); 
        byte[]  buffer  = new byte[size]; 
        while ((length = inStream.read(buffer)) != -1) 
        { 
          outStream.write(buffer, 0, length); 
          outStream.flush(); 
        } 
        inStream.close(); 
        outStream.close(); 
      }
      catch (Exception e)
      {
        e.printStackTrace();
        success = 0;
      }
      finally
      {
        return success;
      }
   
    }  
    
    /**  
     * 删除目录下所有的文件;  
     * @param path  
     */    
    public static boolean deleteExcelPath(File file){    
        String[] files = null;    
        if(file != null){    
            files = file.list();    
        }    
            
        if(file.isDirectory()){    
            for(int i =0;i<files.length;i++){    
                boolean bol = deleteExcelPath(new File(file,files[i]));    
                if(bol){    
                    System.out.println("删除成功!");    
                }else{    
                    System.out.println("删除失败!");    
                }    
            }    
        }    
        return file.delete();    
    }   
    
   
    public static Boolean downFile(HttpServletResponse response,String serverPath, String str) {    
        //下面注释代码虽然少，但是慎用，如果使用，压缩包能下载，但是下载之后临时文件夹会被锁住被jvm占用，不能删除
//        response.setCharacterEncoding("utf-8");  
//         try {
//             File file=new File(serverPath,str);
//             response.setHeader("Content-Disposition",
//                        "attachment; filename="+ StringUtil.encodingFileName(str));
//                response.setContentType("application/octet-stream; charset=utf-8");
//                InputStream in1 =new FileInputStream(file.getPath());
//                IOUtils.copy(in1, response.getOutputStream());
//       
//          } 
//          catch (IOException ex) {
//             ex.printStackTrace();
//         }
        
        Boolean b = false;
        try {    
            File file = new File(serverPath);    
            if (file.exists()) {    
                InputStream ins = new FileInputStream(serverPath);    
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面    
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流    
                BufferedOutputStream bouts = new BufferedOutputStream(outs);   
                response.setContentType("application/ostet-stream");// 设置response内容的类型    
                response.setHeader(    
                        "Content-disposition",    
                        "attachment;filename="    
                                + URLEncoder.encode(str, "UTF-8"));// 设置头部信息    
                int bytesRead = 0;    
                byte[] buffer = new byte[8192];    
                 //开始向网络传输文件流    
                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {    
                   bouts.write(buffer, 0, bytesRead);    
               }    
                bouts.flush();// 这里一定要调用flush()方法    
                ins.close();    
                bins.close();    
                outs.close();    
                bouts.close(); 
                b = true;
            } else {    
                //b = false;
            	//response.sendRedirect("../error.jsp");    
            }    
        } catch (IOException e) {    
            e.printStackTrace();  
        }finally{
            //File file1=new File(serverPath);
            //deleteExcelPath(file1);  //删除临时目录
        	return b;
        }    
    }  
}
