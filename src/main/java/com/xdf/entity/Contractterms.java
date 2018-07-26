package com.xdf.entity;

public class Contractterms {

  private long contracttermsId;
  private long contracApprovalId;
  private long periods;
  private String condition;
  private java.sql.Date contracDate;
  private double amount;
  private long paymentmode;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getContracttermsId() {
    return contracttermsId;
  }

  public void setContracttermsId(long contracttermsId) {
    this.contracttermsId = contracttermsId;
  }


  public long getContracApprovalId() {
    return contracApprovalId;
  }

  public void setContracApprovalId(long contracApprovalId) {
    this.contracApprovalId = contracApprovalId;
  }


  public long getPeriods() {
    return periods;
  }

  public void setPeriods(long periods) {
    this.periods = periods;
  }


  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }


  public java.sql.Date getContracDate() {
    return contracDate;
  }

  public void setContracDate(java.sql.Date contracDate) {
    this.contracDate = contracDate;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public long getPaymentmode() {
    return paymentmode;
  }

  public void setPaymentmode(long paymentmode) {
    this.paymentmode = paymentmode;
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
