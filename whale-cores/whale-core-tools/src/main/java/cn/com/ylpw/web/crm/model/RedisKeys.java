package cn.com.ylpw.web.crm.model;

public class RedisKeys {
	
	/**
	 * 存储当前已推送的最大CUSTOMERID
	 */
	public static final String MAXCUSTOMERID="MAXCUSTOMERID"  ;
	
	/***
	 * 已推送的用户数量总计
	 */
	public static final String PUSH_CUSTOMER_TOTAL="PUSH_CUSTOMER_TOTAL"  ;
	
	
	
	/**
	 * 存储当前已推送的最大ORDERID
	 */
	public static final String MAXORDERID="MAXORDERID"  ;
	
	/***
	 * 已推送的订单信息 总计
	 */
	public static final String PUSH_ORDER_TOTAL="PUSH_ORDER_TOTAL"  ;

	
	/***
	 * 已推送的电子钱包消费信息 
	 */
	public static final String PUSH_EWALLET_TOTAL="PUSH_EWALLET_TOTAL";
	
	
	/**
	 * 存储当前已推送的最大Ewallet充值信息
	 */
	public static final String MAXEWALLET_ID="MAXEWALLET_ID";
	
	
	
	/***
	 * 已推送的乐通卡消费信息 
	 */
	public static final String PUSH_LETONGCARD_SUB_TOTAL="PUSH_LETONGCARD_SUB_TOTAL";
	
	/**
	 * 存储当前已推送的最大ID乐通卡消费信息
	 */
	public static final String MAXLETONGCARD_SUB_ID="MAXLETONGCARD_SUB_ID"  ;

	
	/***
	 * 已推送的配送地址 条数总计
	 */
	public static final String PUSH_ADDRESS_TOTAL="PUSH_ADDRESS_TOTAL";
	
	/**
	 * 存储当前已推送的最大ID配送地址
	 */
	public static final String MAXADDRESS_ID="MAXADDRESS_ID"  ;
	
	
	/***
	 * 已推送的支付方式  
	 */
	public static final String PUSH_PAYTYPES_TOTAL="PUSH_PAYTYPES_TOTAL";
	
	/**
	 * 存储当前已推送的最大ID支付方式
	 */
	public static final String MAXPAYTYPE_ID="MAXPAYTYPE_ID"  ;
	
	/***
	 * 已推送的缺货登记  
	 */
	public static final String PUSH_SHORTAGERECORD_TOTAL = "PUSH_SHORTAGERECORD_TOTAL";
	
	/**
	 * 存储当前已推送的最大ID缺货登记
	 */
	public static final String MAXSHORTAGERECORD_ID = "MAXSHORTAGERECORD_ID";

	/***
	 * 已推送的意见建议   
	 */
	public static final String PUSH_REPORT_TOTAL = "PUSH_REPORT_TOTAL";

	/**
	 * 存储当前已推送的最大ID意见建议
	 */
	public static final String MAXREPORT_ID = "MAXREPORT_ID";

	/**
	 * 首次推送时间
	 */
	public static final String FIRST_PUSH_TIME = "FIRST_PUSH_TIME";
	

	
	/***
	 * 已推送的用户更新信息  MAP  id + 推送时间
	 */
	public static final String PUSH_CUSTOMER_UPD_TOTAL="PUSH_CUSTOMER_UPD_TOTAL"  ;

	/**
	 * 最后一次更新customer的时间
	 */
	public static final String LAST_UPDATE_CUSTOMER_DATE ="LAST_UPDATE_CUSTOMER_DATE" ;

	
	/***
	 * 更新用户信息锁 Boolean
	 */
	public static final String LOCK_KEY_CUSTOMER="LOCK_KEY_CUSTOMER" ;
	
	/***
	 * 更新订单信息锁 Boolean
	 */
	public static final String LOCK_KEY_ORDERS="LOCK_KEY_ORDERS" ;
	
	
	/**
	 * 存储customer持久化错误的
	 */
	public static final String SAVECUSTOMERERROR="SAVECUSTOMERERROR"  ;
	/**
	 * 存储orders持久化错误的
	 */
	public static final String SAVEORDERSERROR = "SAVEORDERSERROR";
	
	/**
	 * 存储Ewalllet持久化错误的
	 */
	public static final String SAVEEWALLETERROR = "SAVEEWALLETERROR";
	
	/**
	 * 存储LeTong卡持久化错误的
	 */
	public static final String SAVELETONGCARDERROR = "SAVELETONGCARDERROR";
	
	/**
	 * 存储ADDRESS持久化错误的
	 */
	public static final String SAVEADDRESSERROR = "SAVEADDRESSERROR";
	/**
	 * 存储PAYMENTTYPES持久化错误的
	 */
	public static final String SAVEPAYMENTTYPESERROR = "SAVEPAYMENTTYPESERROR";
	
	
	/**
	 * 存储SHORTAGERECORD持久化错误的
	 */
	public static final String SAVESHORTAGERECORDERROR = "SAVESHORTAGERECORDERROR";
	
	
	/**
	 * 存储SAVESUGGESTERROR持久化错误的
	 */
	public static final String SAVESUGGESTERROR = "SAVESUGGESTERROR";
	
	
	/**
	 * 存储customer更新错误的
	 */
	public static final String UPDATECUSTOMERERROR="UPDATECUSTOMERERROR"  ;

	/**
	 * 新建一般静态用户分组推送kafka错误的T_GROUP ID 信息
	 */
	public static final String SEND_CUSTOMERGROUPINSERTSELECTIVE_ERROR = "SEND_CUSTOMERGROUPINSERTSELECTIVE_ERROR";



	/**
	 * 当天RFM 策略要计算的用户id队列
	 */
	public static final String CUSTOMER_RFM_INDEX_COMPUTING_QUEUE = "CUSTOMER_RFM_INDEX_COMPUTING_QUEUE";

	/***
	 * 当天RFM 策略计算的用户最大ID
	 */
	public static final String CUSTOMER_RFM_INDEX_COMPUTING_MAXID = "CUSTOMER_RFM_INDEX_COMPUTING_MAXID";

	
	/**
	 * 存储当前已推送的最大ID产品
	 */
	public static final String MAXPRODUCT_ID = "MAXPRODUCT_ID";


	/**
	 * 存储当前已推送的产品数总计
	 */
	public static final String PUSH_PRODUCT_TOTAL = "PUSH_PRODUCT_TOTAL";

	/**
	 * product保存错误的
	 */
	public static final String SAVEPRODUCTERROR ="SAVEPRODUCTERROR" ;

	
//	/**
//	 * 当天正在计算用户等级的用户id队列
//	 */
//	public static final String CUSTOMER_GRADE_COMPUTING_QUEUE = "CUSTOMER_GRADE_COMPUTING_QUEUE";
//	
//	/**
//	 * 当天已计算的用户等级的最大用户id
//	 */
//	public static final String CUSTOMER_GRADE_COMPUTING_MAXID = "CUSTOMER_GRADE_COMPUTING_MAXID";
	

	
	/**
	 * 保存抽过奖的用户信息 map
	 *key  :  userid  
	 *value:  List<TcustomerPrize>
	 */
	public static final String ACTIVTY_GAME_USER ="ACTIVTY_GAME_USER" ;
	

	/**
	 * 存储游戏、奖品信息
	 */
	public static final  String ACTIVTY_GAME_INFO="ACTIVTY_GAME_INFO";

	/**
	 * HASH 记录已从redis 持久化入 mysql 的抽奖信息
	 */
	public static final String ACTIVTY_GAME_SYN_2MYSQL = "ACTIVTY_GAME_SYN_2MYSQL";

	
	/**
	 * 存储QA、奖品信息
	 */
	public static final  String ACTIVTY_QA_INFO="ACTIVTY_QA_INFO";
	
	/**
	 * 保存答过题的用户答题信息 map
	 * key  :问卷存在  cn.com.ylpw.web.crm.model.activty.Qa.questions  中的顺序
	 * value:答案#时间#奖品ID
	 */
	public static final String ACTIVTY_QA_USER ="ACTIVTY_QA_USER" ;
	
	
	/***
	 * 存储用户答卷中奖后奖品是否兑换信息
	 */
	public static final String ACTIVTY_QA_PRIZE_USER ="ACTIVTY_PRIZE_USER" ;

	/**
	 * HASH 记录已从redis 持久化入 mysql 的答卷信息
	 */
	public static final String ACTIVTY_QA_SYN_2MYSQL = "ACTIVTY_QA_SYN_2MYSQL" ;

	/**
	 * 消费激励策略计算完成 需要计算积分的用户ID推送KAFKA 推送失败记录
	 */
	public static final String SEND_COMPUTING_INTEGRAL_ERROR = "SEND_COMPUTING_INTEGRAL_ERROR";

	/**
	 * 推送 投放活动错误的 数据
	 */
	public static String PUSH_228_ERROR_ACTIVTY_PUTIN ="PUSH_228_ERROR_ACTIVTY_PUTIN";
	
	/**
	 * 推送 触发活动错误的 数据
	 */
	public static String PUSH_228_ERROR_ACTIVTY_TRIGER="PUSH_228_ERROR_ACTIVTY_TRIGER";

	/**
	 * 需要同步essearch 用户等级的等级
	 */
	public static String SYN_GRADE_ELASTIC_QUEUE="SYN_GRADE_ELASTIC_QUEUE";
	
	/**
	 * 需要同步essearch 用户等级的用户
	 */
	public static String SYN_CUSTOMERS_ELASTIC_QUEUE="SYN_CUSTOMERS_ELASTIC_QUEUE";

	/**
	 * 数据库未更新完  不允许 同步es 数据库更新过程中 lock =true
	 */
	public static String SYN_GRADE2ES_LOCK="SYN_GRADE2ES_LOCK";

	/**
	 * 当前正在同步的 用户等级信息
	 */
	public static String SYN_CUSTOMERS_PROGRESSOF="SYN_CUSTOMERS_PROGRESSOF";

	
	/***
	 * 待处理的静态分组队列
	 */
	public static String CUSTOMER_STATIC_GROUP_QUEUE="CUSTOMER_STATIC_GROUP_QUEUE";
	
	/***
	 * 营销屏蔽的会员
	 */
	public static final String SHIELD_CUSTOMER="SHIELD_CUSTOMER" ;


	/***
	 * 正在处理的分组ID
	 */
	public static String CUSTOMER_STATIC_GROUP_DOING="CUSTOMER_STATIC_GROUP_DOING";
	
	/***
	 * 待删除的分组ID
	 */
	public static String CUSTOMER_GROUP_DEL_QUEUE="CUSTOMER_GROUP_DEL_QUEUE";
	
	/***
	 * 正在删除的分组ID
	 */
	public static String CUSTOMER_GROUP_DEL_DOING="CUSTOMER_GROUP_DEL_DOING";
	
	/***
	 * 待生成导出excel的分组ID集合
	 */
	public static String GENERATE_CUSTOMER_GROUPIDS="GENERATE_CUSTOMER_GROUPIDS";
	
	/***
	 * 正在导出excel的分组ID
	 */
	public static String GENERATEING_CUSTOMER_GROUPIDS="GENERATEING_CUSTOMER_GROUPIDS";
	
	/***
	 * 记录活动浏览数量
	 */
	public static String ACTIVTY_GAME_READERCOUNT="ACTIVTY_GAME_READERCOUNT";

	/***
	 * 记录推送的订单更新数
	 */
	public static String PUSH_ORDERS_UPD_TOTAL="PUSH_ORDERS_UPD_TOTAL";

	/**
	 * 记录最后一次推送更新订单的时间
	 */
	public static String LAST_UPDATE_ORDERS_DATE="LAST_UPDATE_ORDERS_DATE";

	

	/***
	 * true 禁止push应用推送信息 
	 */
	public static final String  STOP_PUSH="STOP_PUSH" ;


//	/***
//	 * 活动投放进行中（ 删除 、暂停 都是 false）
//	 */
//	public static final String  ACTIVTY_PUTIN_ING="ACTIVTY_PUTIN_ING" ;
	
	/***
	 * 活动投放用户类型 1所有用户2分组用户
	 */
	public static final String  ACTIVTY_PUTIN_LIMIT_TYPE="ACTIVTY_PUTIN_LIMIT_TYPE" ;
	
	/***
	 * 活动投放用户ID
	 */
//	public static final String  ACTIVTY_PUTIN_LIMIT_IDS="ACTIVTY_PUTIN_LIMIT_IDS" ;
	
	/***
	 * 活动投放详细信息
	 */
	public static String ACTIVTY_PUTIN_DETAIL="ACTIVTY_PUTIN_DETAIL";

	/**
	 * 记录活动投放开始时间和结束时间
	 */
	public static String ACTIVTY_PUTIN_TIMES="ACTIVTY_PUTIN_TIMES";

	/***
	 * 标示活动正在投放中。禁止用户操作正在投放中的投放信息
	 */
	public static String ACTIVTY_PUTIN_ING_DOING="ACTIVTY_PUTIN_ING_DOING";
	
	
	/***
	 * 活动触发进行中（ 删除 、暂停 都是 false）
	 */
	public static final String  ACTIVTY_TRIGER_ING="ACTIVTY_TRIGER_ING" ;
	
	/***
	 * 活动触发用户类型 1所有用户2分组用户
	 */
	public static final String  ACTIVTY_TRIGER_LIMIT_TYPE="ACTIVTY_TRIGER_LIMIT_TYPE" ;
	
	/***
	 * 活动触发用户ID
	 */
	public static final String  ACTIVTY_TRIGER_LIMIT_IDS="ACTIVTY_TRIGER_LIMIT_IDS" ;

	/**
	 * 活动现金券奖品信息拉取
	 */
	public static final String ACTIVTY_PRIZE_CASHCOUPON_PULL = "ACTIVTY_PRIZE_CASHCOUPON_PULL";
	
	
}
