package cn.com.ylpw.web.crm.entity;

import java.io.Serializable;

public    class Enums {
		
		 public enum isDel implements Serializable{
			   
			   /**
			    * 0,已删除
			    */
			 	TRUE("已删除"),
			   
			   /**
			    * 1，未删除
			    */
			   FALSE("未删除");
			   
			   private String  text;  
		        
			   isDel(String text){  
		            this.text = text;  
		        }
				public String getText() {
					return text;
				}
	
				public void setText(String text) {
					this.text = text;
				}
		   }  
		 
		 
		 	
			
		  public enum orderStatus  implements Serializable{
		 		 未审核("未审核"),
				 已审核("已审核"),
				 配票中("配票中"),
				 发货中("发货中"),
				 已发货("已发货"),
				 已完成("已完成"),
				 无效("无效"),
				 已退票("已退票"),
				 已处理("已处理"),
				 用户已删除("用户已删除"),
				 审核至前台("审核至前台"),
				 无票("无票"),
				 退票中("退票中"),
				 退款中("退款中"),
				 退款已审核("退款已审核"),
				 已退款("已退款"),
				 退票_退款中("退票、退款中"),
				 已退票_退款中("已退票、退款中"),
				 已退票_退款已审核("已退票、退款已审核"),
				 已退票_已退款("已退票、已退款"),
				 其他("其他") ;
			   
			    private String  text;  
		        
			    orderStatus(String text){  
		            this.text = text;  
		        }
			    
				public String getText() {
					return text;
				}
				
		   } 
		  
		  public enum payStatus  implements Serializable{
			  未支付("未支付"),
			  部分支付("部分支付"),
			  已支付("已支付"),
			  已退款("已退款"),
			  等待付款("等待付款"),
			  其他("其他") ;
			  
			  private String  text;  
			  
			  payStatus(String text){  
				  this.text = text;  
			  }
			  
			  public String getText() {
				  return text;
			  }
			  
		  } 
		 
}
