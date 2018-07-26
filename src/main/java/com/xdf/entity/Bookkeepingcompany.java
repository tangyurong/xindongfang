package com.xdf.entity;


public class Bookkeepingcompany {

  private long companyId;
  private String companyName;
  private String companyCode;
  private long companyMechanismId;
  private long financeId;
  private long financialManagementId;
  private long parentId;
  private long currencyId;
  private long effective;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }


  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }


  public String getCompanyCode() {
    return companyCode;
  }

  public void setCompanyCode(String companyCode) {
    this.companyCode = companyCode;
  }


  public long getCompanyMechanismId() {
    return companyMechanismId;
  }

  public void setCompanyMechanismId(long companyMechanismId) {
    this.companyMechanismId = companyMechanismId;
  }


  public long getFinanceId() {
    return financeId;
  }

  public void setFinanceId(long financeId) {
    this.financeId = financeId;
  }


  public long getFinancialManagementId() {
    return financialManagementId;
  }

  public void setFinancialManagementId(long financialManagementId) {
    this.financialManagementId = financialManagementId;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public long getCurrencyId() {
    return currencyId;
  }

  public void setCurrencyId(long currencyId) {
    this.currencyId = currencyId;
  }


  public long getEffective() {
    return effective;
  }

  public void setEffective(long effective) {
    this.effective = effective;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
