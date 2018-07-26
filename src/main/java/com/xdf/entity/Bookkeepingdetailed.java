package com.xdf.entity;


public class Bookkeepingdetailed {

  private long bookkeepingDetailedId;
  private long bookkeepingId;
  private long serial;
  private String abstracts;
  private long borrower;
  private long businessDetailsId;
  private long currencysId;
  private long money;
  private long auxiliaryprojectId;


  public long getBookkeepingDetailedId() {
    return bookkeepingDetailedId;
  }

  public void setBookkeepingDetailedId(long bookkeepingDetailedId) {
    this.bookkeepingDetailedId = bookkeepingDetailedId;
  }


  public long getBookkeepingId() {
    return bookkeepingId;
  }

  public void setBookkeepingId(long bookkeepingId) {
    this.bookkeepingId = bookkeepingId;
  }


  public long getSerial() {
    return serial;
  }

  public void setSerial(long serial) {
    this.serial = serial;
  }


  public String getAbstract() {
    return abstracts;
  }

  public void setAbstract(String abstracts) {
    this.abstracts = abstracts;
  }


  public long getBorrower() {
    return borrower;
  }

  public void setBorrower(long borrower) {
    this.borrower = borrower;
  }


  public long getBusinessDetailsId() {
    return businessDetailsId;
  }

  public void setBusinessDetailsId(long businessDetailsId) {
    this.businessDetailsId = businessDetailsId;
  }


  public long getCurrencysId() {
    return currencysId;
  }

  public void setCurrencysId(long currencysId) {
    this.currencysId = currencysId;
  }


  public long getMoney() {
    return money;
  }

  public void setMoney(long money) {
    this.money = money;
  }


  public long getAuxiliaryprojectId() {
    return auxiliaryprojectId;
  }

  public void setAuxiliaryprojectId(long auxiliaryprojectId) {
    this.auxiliaryprojectId = auxiliaryprojectId;
  }

}
