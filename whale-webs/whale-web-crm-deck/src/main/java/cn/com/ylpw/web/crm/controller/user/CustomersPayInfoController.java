package cn.com.ylpw.web.crm.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.com.ylpw.web.crm.entity.Enums;
import cn.com.ylpw.web.crm.service.other.AddressService;
import cn.com.ylpw.web.crm.service.other.EWalletService;
import cn.com.ylpw.web.crm.service.other.LeTongService;
import cn.com.ylpw.web.crm.service.other.OrdersService;
import cn.com.ylpw.web.crm.service.other.PaymentTypesService;
import cn.com.ylpw.web.crm.util.Page;

/***
 * @ClassName: CustomersPayInfoController
 * @Description:交易信息列表相关查询
 * @author LT
 * @date 2017年5月4日 下午2:06:12
 */
@Controller("customersPayInfoController")
public class CustomersPayInfoController {
  
  private static final Logger logger = LoggerFactory.getLogger(CustomersPayInfoController.class);
  @Autowired
  private  OrdersService ordersService;
  @Autowired
  private EWalletService eWalletService;
  @Autowired
  private LeTongService  leTongService; 
  @Autowired
  private AddressService  addressService; 
  @Autowired
  private PaymentTypesService paymentTypesService  ; 
  
  /***
   * <p>会员交易记录</p>
   * @author LT
   * @date 2017年5月15日 上午10:21:11
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/orders/list/{id}")
	public String ordersList( @RequestParam(required=false) Map<String,Object> searchParam  ,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id  ){
		logger.info("加载会员交易记录");
		searchParam.put("customerid", id);
		searchParam.put("payStatus", Enums.payStatus.已支付);
		PageInfo<Map<String,Object>>  pageInfo =ordersService.pageFindModel("findAll", page, searchParam);
		
		Map<String,Object> totals = ordersService.findTotalInfo("findAll",searchParam);
		model.put("totals", totals);
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		model.put("searchParam", searchParam);
		model.put("customerid", id);
	    return "/customers/deatil_orders_list";
	}

  /***
   * <p>电子钱包使用记录</p>
   * @author LT
   * @date 2017年5月15日 上午10:35:10
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/ewallet/list/{id}")
  public String ewalletList( @RequestParam(required=false) Map<String,Object> searchParam  ,
		  Page<Map<String,Object>> page,
		  HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id  ){
	  logger.info("加载会员电子钱包使用记录");
	  searchParam.put("customerid", id);
	  PageInfo<Map<String,Object>>  pageInfo =eWalletService.pageFindModel("findAll", page, searchParam);
	  
	  model.put("dateList", pageInfo.getList());
	  model.put("page",  page );
	  model.put("searchParam", searchParam);
	  model.put("customerid", id);
	  return "/customers/deatil_ewallet_list";
  }
  
  /***
   * <p>乐通卡使用记录</p>
   * @author LT
   * @date 2017年5月15日 上午10:35:10
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/letong/list/{id}")
  public String letongList( @RequestParam(required=false) Map<String,Object> searchParam  ,
		  Page<Map<String,Object>> page,
		  HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id  ){
	  logger.info("加载乐通卡使用记录");
	  searchParam.put("customerid", id);
	  PageInfo<Map<String,Object>>  pageInfo =leTongService.pageFindModel("findAll", page, searchParam);
	  
	  model.put("dateList", pageInfo.getList());
	  model.put("page",  page );
	  model.put("searchParam", searchParam);
	  model.put("customerid", id);
	  return "/customers/deatil_letongcard_list";
  }
  
  
  /***
   * <p>配送信息统计</p>
   * @author LT
   * @date 2017年5月15日 上午10:35:10
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/address/list/{id}")
  public String addressList( @RequestParam(required=false) Map<String,Object> searchParam  ,
		  Page<Map<String,Object>> page,
		  HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id  ){
	  logger.info("加载配送信息记录");
	  searchParam.put("customerid", id);
	  PageInfo<Map<String,Object>>  pageInfo =addressService.pageFindModel("findAll", page, searchParam);
	  
	  model.put("dateList", pageInfo.getList());
	  model.put("page",  page );
	  model.put("searchParam", searchParam);
	  model.put("customerid", id);
	  return "/customers/deatil_address_list";
  }
  
  
  /***
   * <p>支付方式统计</p>
   * @author LT
   * @date 2017年5月15日 下午1:26:51
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/paytypes/list/{id}")
  public String paytypesList( @RequestParam(required=false) Map<String,Object> searchParam  ,
		  Page<Map<String,Object>> page,
		  HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id  ){
	  logger.info("加载支付信息统计");
	  searchParam.put("customerid", id);
	  PageInfo<Map<String,Object>>  pageInfo =paymentTypesService.pageFindModel("findAll", page, searchParam);
	  
	  model.put("dateList", pageInfo.getList());
	  model.put("page",  page );
	  model.put("searchParam", searchParam);
	  model.put("customerid", id);
	  return "/customers/deatil_paytypes_list";
  }
  
  /**
   * <p>订单退款</p>
   * @author LT
   * @date 2017年5月15日 下午2:02:23
   * @return String
   * @param searchParam
   * @param page
   * @param req
   * @param model
   * @param id
   * @return
   */
  @RequestMapping("/customers/ordersrefund/list/{id}")
  public String ordersRefundList( @RequestParam(required=false) Map<String,Object> searchParam  ,
			Page<Map<String,Object>> page,
			HttpServletRequest req, ModelMap model ,@PathVariable(name="id")  Long id  ){
		logger.info("加载订单退款记录");
		searchParam.put("customerid", id);
		searchParam.put( "orderStatusIsRef" , 1 );
		searchParam.put( "payStatus" , "已退款" );
		
		PageInfo<Map<String,Object>>  pageInfo =ordersService.pageFindModel("findAll", page, searchParam);
		Map<String,Object> totals = ordersService.findTotalInfo("findAll",searchParam);
		model.put("totals", totals);
		model.put("dateList", pageInfo.getList());
		model.put("page",  page );
		model.put("searchParam", searchParam);
		model.put("customerid", id);
	    return "/customers/deatil_ordersrefund_list";
	}
  
}
