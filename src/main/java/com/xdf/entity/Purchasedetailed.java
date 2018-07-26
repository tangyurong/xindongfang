package com.xdf.entity;

public class Purchasedetailed {

  private long purchaseDetailedId;
  private long purchaseId;
  private long costDetailedType;
  private String purpose;
  private long costcenterId;
  private long administrativeId;
  private long accountingId;
  private long specialBudgetId;
  private long budgetaryId;
  private double money;
  private double borrowmoney;
  private long borrowType;
  private java.sql.Date costDetailedDate;
  private long currencysId;
  private String remarks;
  private double rmb;
  private double amount;
  private double totalloanamount;
  private String explain;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getPurchaseDetailedId() {
    return purchaseDetailedId;
  }

  public void setPurchaseDetailedId(long purchaseDetailedId) {
    this.purchaseDetailedId = purchaseDetailedId;
  }


  public long getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(long purchaseId) {
    this.purchaseId = purchaseId;
  }


  public long getCostDetailedType() {
    return costDetailedType;
  }

  public void setCostDetailedType(long costDetailedType) {
    this.costDetailedType = costDetailedType;
  }


  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }


  public long getCostcenterId() {
    return costcenterId;
  }

  public void setCostcenterId(long costcenterId) {
    this.costcenterId = costcenterId;
  }


  public long getAdministrativeId() {
    return administrativeId;
  }

  public void setAdministrativeId(long administrativeId) {
    this.administrativeId = administrativeId;
  }


  public long getAccountingId() {
    return accountingId;
  }

  public void setAccountingId(long accountingId) {
    this.accountingId = accountingId;
  }


  public long getSpecialBudgetId() {
    return specialBudgetId;
  }

  public void setSpecialBudgetId(long specialBudgetId) {
    this.specialBudgetId = specialBudgetId;
  }


  public long getBudgetaryId() {
    return budgetaryId;
  }

  public void setBudgetaryId(long budgetaryId) {
    this.budgetaryId = budgetaryId;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public double getBorrowmoney() {
    return borrowmoney;
  }

  public void setBorrowmoney(double borrowmoney) {
    this.borrowmoney = borrowmoney;
  }


  public long getBorrowType() {
    return borrowType;
  }

  public void setBorrowType(long borrowType) {
    this.borrowType = borrowType;
  }


  public java.sql.Date getCostDetailedDate() {
    return costDetailedDate;
  }

  public void setCostDetailedDate(java.sql.Date costDetailedDate) {
    this.costDetailedDate = costDetailedDate;
  }


  public long getCurrencysId() {
    return currencysId;
  }

  public void setCurrencysId(long currencysId) {
    this.currencysId = currencysId;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public double getRmb() {
    return rmb;
  }

  public void setRmb(double rmb) {
    this.rmb = rmb;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public double getTotalloanamount() {
    return totalloanamount;
  }

  public void setTotalloanamount(double totalloanamount) {
    this.totalloanamount = totalloanamount;
  }


  public String getExplain() {
    return explain;
  }

  public void setExplain(String explain) {
    this.explain = explain;
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
