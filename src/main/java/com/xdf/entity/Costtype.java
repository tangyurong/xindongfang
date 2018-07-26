package com.xdf.entity;


public class Costtype {

  private long costId;
  private String costName;
  private String costCode;
  private long parentId;
  private long accountingId;
  private long budgetaryId;
  private long companyId;
  private long isApply;
  private long isContract;
  private long isMoney;
  private long isDepartment;
  private long businessId;
  private long businessDetailsId;
  private long effective;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getCostId() {
    return costId;
  }

  public void setCostId(long costId) {
    this.costId = costId;
  }


  public String getCostName() {
    return costName;
  }

  public void setCostName(String costName) {
    this.costName = costName;
  }


  public String getCostCode() {
    return costCode;
  }

  public void setCostCode(String costCode) {
    this.costCode = costCode;
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


  public long getBudgetaryId() {
    return budgetaryId;
  }

  public void setBudgetaryId(long budgetaryId) {
    this.budgetaryId = budgetaryId;
  }


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }


  public long getIsApply() {
    return isApply;
  }

  public void setIsApply(long isApply) {
    this.isApply = isApply;
  }


  public long getIsContract() {
    return isContract;
  }

  public void setIsContract(long isContract) {
    this.isContract = isContract;
  }


  public long getIsMoney() {
    return isMoney;
  }

  public void setIsMoney(long isMoney) {
    this.isMoney = isMoney;
  }


  public long getIsDepartment() {
    return isDepartment;
  }

  public void setIsDepartment(long isDepartment) {
    this.isDepartment = isDepartment;
  }


  public long getBusinessId() {
    return businessId;
  }

  public void setBusinessId(long businessId) {
    this.businessId = businessId;
  }


  public long getBusinessDetailsId() {
    return businessDetailsId;
  }

  public void setBusinessDetailsId(long businessDetailsId) {
    this.businessDetailsId = businessDetailsId;
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
