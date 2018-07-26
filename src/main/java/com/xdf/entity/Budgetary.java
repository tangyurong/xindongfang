package com.xdf.entity;


public class Budgetary {

  private long budgetaryId;
  private String budgetaryName;
  private String budgetaryCode;
  private long parentId;
  private long accountingId;
  private long companyId;
  private long effective;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getBudgetaryId() {
    return budgetaryId;
  }

  public void setBudgetaryId(long budgetaryId) {
    this.budgetaryId = budgetaryId;
  }


  public String getBudgetaryName() {
    return budgetaryName;
  }

  public void setBudgetaryName(String budgetaryName) {
    this.budgetaryName = budgetaryName;
  }


  public String getBudgetaryCode() {
    return budgetaryCode;
  }

  public void setBudgetaryCode(String budgetaryCode) {
    this.budgetaryCode = budgetaryCode;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public long getAccountingId() {
    return accountingId;
  }

  public void setAccountingId(long accountingId) {
    this.accountingId = accountingId;
  }


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
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
