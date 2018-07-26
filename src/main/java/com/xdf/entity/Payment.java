package com.xdf.entity;


public class Payment {

  private long paymentId;
  private long businesstype;
  private long handleId;
  private double payments;
  private long method;
  private long payee;
  private long category;
  private long payeeId;
  private String payeeCode;
  private String payeeAccount;


  public long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(long paymentId) {
    this.paymentId = paymentId;
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


  public double getPayments() {
    return payments;
  }

  public void setPayments(double payments) {
    this.payments = payments;
  }


  public long getMethod() {
    return method;
  }

  public void setMethod(long method) {
    this.method = method;
  }


  public long getPayee() {
    return payee;
  }

  public void setPayee(long payee) {
    this.payee = payee;
  }


  public long getCategory() {
    return category;
  }

  public void setCategory(long category) {
    this.category = category;
  }


  public long getPayeeId() {
    return payeeId;
  }

  public void setPayeeId(long payeeId) {
    this.payeeId = payeeId;
  }


  public String getPayeeCode() {
    return payeeCode;
  }

  public void setPayeeCode(String payeeCode) {
    this.payeeCode = payeeCode;
  }


  public String getPayeeAccount() {
    return payeeAccount;
  }

  public void setPayeeAccount(String payeeAccount) {
    this.payeeAccount = payeeAccount;
  }

}
