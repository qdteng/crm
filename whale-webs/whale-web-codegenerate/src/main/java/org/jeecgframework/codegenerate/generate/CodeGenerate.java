 package org.jeecgframework.codegenerate.generate;
 
 import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jeecgframework.codegenerate.database.JeecgReadTable;
import org.jeecgframework.codegenerate.pojo.Columnt;
import org.jeecgframework.codegenerate.pojo.CreateFileProperty;
import org.jeecgframework.codegenerate.util.CodeDateUtils;
import org.jeecgframework.codegenerate.util.CodeResourceUtil;
import org.jeecgframework.codegenerate.util.NonceUtils;
import org.jeecgframework.codegenerate.util.def.FtlDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
 
 public class CodeGenerate
   implements ICallBack
 {
	 
   private static final Logger logger = LoggerFactory.getLogger(CodeGenerate.class);
   private static String entityPackage = "test";
   private static String entityName = "Person";
   private static String tableName = "person";
   private static String ftlDescription = "公告";
   private static String primaryKeyPolicy = "uuid";
   private static String sequenceCode = "";
   
   private static String[] foreignKeys;
 
   private List<Columnt> originalColumns = new ArrayList();
   public static int FIELD_ROW_NUM = 1;
   private static CreateFileProperty createFileProperty = new CreateFileProperty();
   
   static { createFileProperty.setActionFlag(true);
     createFileProperty.setServiceIFlag(true);
     createFileProperty.setJspFlag(true);
     createFileProperty.setServiceImplFlag(true);
     createFileProperty.setJspMode("01");
     createFileProperty.setPageFlag(true);
     createFileProperty.setEntityFlag(true);
   }
   
 
 
 
 
 
   public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, int fieldRowNum, String primaryKeyPolicy, String sequenceCode)
   {
	 CodeGenerate.entityName = entityName;
	 CodeGenerate.entityPackage = entityPackage;
	 CodeGenerate.tableName = tableName;
	 CodeGenerate.ftlDescription = ftlDescription;
	 CodeGenerate.createFileProperty = createFileProperty;
     FIELD_ROW_NUM = fieldRowNum;
     CodeGenerate.primaryKeyPolicy = primaryKeyPolicy;
     CodeGenerate.sequenceCode = sequenceCode;
   }
   
   public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, String primaryKeyPolicy, String sequenceCode)
   {
	   CodeGenerate.entityName = entityName;
	   CodeGenerate.entityPackage = entityPackage;
	   CodeGenerate.tableName = tableName;
	   CodeGenerate.ftlDescription = ftlDescription;
	   CodeGenerate.createFileProperty = createFileProperty;
	   CodeGenerate.primaryKeyPolicy = primaryKeyPolicy;
	   CodeGenerate.sequenceCode = sequenceCode;
   }
   
   public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, String primaryKeyPolicy, String sequenceCode, String[] foreignKeys)
   {
	   CodeGenerate.entityName = entityName;
	   CodeGenerate.entityPackage = entityPackage;
	   CodeGenerate.tableName = tableName;
	   CodeGenerate.ftlDescription = ftlDescription;
	   CodeGenerate.createFileProperty = createFileProperty;
	   CodeGenerate.primaryKeyPolicy = primaryKeyPolicy;
	   CodeGenerate.sequenceCode = sequenceCode;
	   CodeGenerate.foreignKeys = foreignKeys;
   }
   
 
 
   private List<Columnt> columns = new ArrayList();
   private JeecgReadTable dbFiledUtil = new JeecgReadTable();
   
 
 
   public Map<String, Object> execute()
   {
     Map<String, Object> data = new HashMap();
     
 
     data.put("bussiPackage", CodeResourceUtil.bussiPackage);
     
     data.put("entityPackage", entityPackage);
     
     data.put("entityName", entityName);
     
     data.put("tableName", tableName);
     
     data.put("ftl_description", ftlDescription);
     
     data.put(FtlDef.JEECG_TABLE_ID, CodeResourceUtil.JEECG_GENERATE_TABLE_ID);
     
     data.put(FtlDef.JEECG_PRIMARY_KEY_POLICY, primaryKeyPolicy);
     data.put(FtlDef.JEECG_SEQUENCE_CODE, sequenceCode);
     
     data.put("ftl_create_time", CodeDateUtils.dateToString(new Date()));
     
     data.put("foreignKeys", foreignKeys);
     
 
 
     data.put(FtlDef.FIELD_REQUIRED_NAME, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.JEECG_UI_FIELD_REQUIRED_NUM) ? Integer.parseInt(CodeResourceUtil.JEECG_UI_FIELD_REQUIRED_NUM) : -1));
     
     data.put(FtlDef.SEARCH_FIELD_NUM, Integer.valueOf(StringUtils.isNotEmpty(CodeResourceUtil.JEECG_UI_FIELD_SEARCH_NUM) ? Integer.parseInt(CodeResourceUtil.JEECG_UI_FIELD_SEARCH_NUM) : -1));
     
     data.put(FtlDef.FIELD_ROW_NAME, Integer.valueOf(FIELD_ROW_NUM));
     
     try
     {
       this.columns = this.dbFiledUtil.readTableColumn(tableName);
       data.put("columns", this.columns);
       
 
       this.originalColumns = this.dbFiledUtil.readOriginalTableColumn(tableName);
       data.put("originalColumns", this.originalColumns);
       
 
       for (Columnt c : this.originalColumns) {
         if (c.getFieldName().toLowerCase().equals(CodeResourceUtil.JEECG_GENERATE_TABLE_ID.toLowerCase())) {
           data.put("primary_key_type", c.getFieldType());
         }
       }
     }
     catch (Exception e) {
       e.printStackTrace();
       System.exit(-1);
     }
     long serialVersionUID = NonceUtils.randomLong() + NonceUtils.currentMills();
     
     data.put("serialVersionUID", String.valueOf(serialVersionUID));
     return data;
   }
   
   public void generateToFile() {
     logger.info("----jeecg---Code----Generation----[单表模型:" + tableName + "]------- 生成中。。。");
     
     CodeFactory codeFactory = new CodeFactory();
     codeFactory.setCallBack(new CodeGenerate());
     
     if (createFileProperty.isJspFlag()) {
       if ("03".equals(createFileProperty.getJspMode())) {
         codeFactory.invoke("onetomany/jspSubTemplate.ftl", "jspList");
       } else {
         if ("01".equals(createFileProperty.getJspMode())) {
           codeFactory.invoke("jspTableTemplate.ftl", "jsp");
         }
         if ("02".equals(createFileProperty.getJspMode())) {
           codeFactory.invoke("jspDivTemplate.ftl", "jsp");
         }
         codeFactory.invoke("jspListTemplate.ftl", "jspList");
       }
     }
     if (createFileProperty.isServiceImplFlag()) {
       codeFactory.invoke("serviceImplTemplate.ftl", "serviceImpl");
     }
     if (createFileProperty.isServiceIFlag()) {
       codeFactory.invoke("serviceITemplate.ftl", "service");
     }
     if (createFileProperty.isActionFlag()) {
       codeFactory.invoke("controllerTemplate.ftl", "controller");
     }
     if (createFileProperty.isEntityFlag())
     {
       codeFactory.invoke("entityTemplate.ftl", "entity");
       codeFactory.invoke("mappingTemplate.ftl", "mapping");
       codeFactory.invoke("mapperTemplate.ftl", "mapper");
     }
     logger.info("----jeecg----Code----Generation-----[单表模型：" + tableName + "]------ 生成完成。。。");
   }
   
 
 
   public static void main(String[] args)
   {
     System.out.println("----jeecg--------- Code------------- Generation -----[单表模型]------- 生成中。。。");
     new CodeGenerate().generateToFile();
     System.out.println("----jeecg--------- Code------------- Generation -----[单表模型]------- 生成完成。。。");
   }
   
   public CodeGenerate() {}
 }
