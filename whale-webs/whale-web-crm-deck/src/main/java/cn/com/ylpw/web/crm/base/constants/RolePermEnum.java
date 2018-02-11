package cn.com.ylpw.web.crm.base.constants;

public enum RolePermEnum {
  
  SYS_ROLE_CHANNEL("SYS_ROLE_CHANNEL", "CHANNEL_ID"),
  SYS_ROLE_SPREADWAY("SYS_ROLE_SPREADWAY","SPREADWAY_ID"),
  SYS_ROLE_PRODUCTTYPEA("SYS_ROLE_PRODUCTTYPEA","PRODUCTTYPEA_ID"),
  SYS_ROLE_MENU("SYS_ROLE_MENU","SYS_MENU_ID"),
  SYS_ROLE_FCONFIG("SYS_ROLE_FCONFIG","FCONFIG_ID");
  
  RolePermEnum(String permTable, String permTableCol) {
    this.permTable=permTable;
    this.permTableCol=permTableCol;
  }
  
  private String permTable;
  private String permTableCol;
  
  public String getPermTable() {
    return permTable;
  }
  public void setPermTable(String permTable) {
    this.permTable = permTable;
  }
  public String getPermTableCol() {
    return permTableCol;
  }
  public void setPermTableCol(String permTableCol) {
    this.permTableCol = permTableCol;
  }

}
