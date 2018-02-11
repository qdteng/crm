package cn.com.ylpw.web.crm.util;

import java.util.List;

import com.google.common.collect.Lists;

 /**
  * @ClassName: Page
  * @Description: 系统分页框架模型
  * @author zhaohb
  * @date 2017-3-17 下午5:56:28
  */
public class Page<T> {
  
  public static final int DEFAULT_PAGE_SIZE = 10;
  
  private Integer pageNo;//当前页码
  private Integer pageSize;//每页条数
  private Long total;//总条数
  
  private List<T> data;//数据列表
  
  public Page() {
    this.pageNo = 1;
    this.pageSize = DEFAULT_PAGE_SIZE;
    this.total = 0l;
    this.data = Lists.newArrayList();
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public List  getData() {
    return data;
  }

  public void setData(List  data) {
    this.data = data;
  }

}
