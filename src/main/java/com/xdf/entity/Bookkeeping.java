package com.xdf.entity;


public class Bookkeeping {

  private long bookkeepingId;
  private long businesstype;
  private long handleId;
  private java.sql.Date bookkeepingDate;
  private java.sql.Date businessDate;
  private long accountingId;


  public long getBookkeepingId() {
    return bookkeepingId;
  }

  public void setBookkeepingId(long bookkeepingId) {
    this.bookkeepingId = bookkeepingId;
  }


  public long getBusinesstype() {
    return businesstype;
  }

  public void setBusinesstype(long businesstype) {
    this.businesstype = businesstype;
  }


  public long getHandleId() {
    return handleId;
  }

  public void setHandleId(long handleId) {
    this.handleId = handleId;
  }


  public java.sql.Date getBookkeepingDate() {
    return bookkeepingDate;
  }

  public void setBookkeepingDate(java.sql.Date bookkeepingDate) {
    this.bookkeepingDate = bookkeepingDate;
  }


  public java.sql.Date getBusinessDate() {
    return businessDate;
  }

  public void setBusinessDate(java.sql.Date businessDate) {
    this.businessDate = businessDate;
  }


  public long getAccountingId() {
    return accountingId;
  }

  public void setAccountingId(long accountingId) {
    this.accountingId = accountingId;
  }

}
