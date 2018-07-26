package com.xdf.entity;


public class Loandetails {

  private long loanDetailsId;
  private long loanPaymentId;
  private long loanDetailsType;
  private String purpose;
  private long costcenterId;
  private long administrativeId;
  private long accountingId;
  private long specialBudgetId;
  private double money;
  private java.sql.Date loanDetailsDate;
  private long currencysId;
  private String remarks;
  private double rmb;
  private double totalloanamount;
  private String explain;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getLoanDetailsId() {
    return loanDetailsId;
  }

  public void setLoanDetailsId(long loanDetailsId) {
    this.loanDetailsId = loanDetailsId;
  }


  public long getLoanPaymentId() {
    return loanPaymentId;
  }

  public void setLoanPaymentId(long loanPaymentId) {
    this.loanPaymentId = loanPaymentId;
  }


  public long getLoanDetailsType() {
    return loanDetailsType;
  }

  public void setLoanDetailsType(long loanDetailsType) {
    this.loanDetailsType = loanDetailsType;
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


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }


  public java.sql.Date getLoanDetailsDate() {
    return loanDetailsDate;
  }

  public void setLoanDetailsDate(java.sql.Date loanDetailsDate) {
    this.loanDetailsDate = loanDetailsDate;
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
