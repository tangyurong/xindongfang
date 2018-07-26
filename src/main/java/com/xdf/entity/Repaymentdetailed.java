package com.xdf.entity;


public class Repaymentdetailed {

  private long repaymentDetailedId;
  private long repaymentId;
  private String repaymentDetailedCode;
  private String repaymentTitle;
  private double repayment;
  private double cash;
  private double bank;
  private long loanPaymentId;
  private long purchaseId;


  public long getRepaymentDetailedId() {
    return repaymentDetailedId;
  }

  public void setRepaymentDetailedId(long repaymentDetailedId) {
    this.repaymentDetailedId = repaymentDetailedId;
  }


  public long getRepaymentId() {
    return repaymentId;
  }

  public void setRepaymentId(long repaymentId) {
    this.repaymentId = repaymentId;
  }


  public String getRepaymentDetailedCode() {
    return repaymentDetailedCode;
  }

  public void setRepaymentDetailedCode(String repaymentDetailedCode) {
    this.repaymentDetailedCode = repaymentDetailedCode;
  }


  public String getRepaymentTitle() {
    return repaymentTitle;
  }

  public void setRepaymentTitle(String repaymentTitle) {
    this.repaymentTitle = repaymentTitle;
  }


  public double getRepayment() {
    return repayment;
  }

  public void setRepayment(double repayment) {
    this.repayment = repayment;
  }


  public double getCash() {
    return cash;
  }

  public void setCash(double cash) {
    this.cash = cash;
  }


  public double getBank() {
    return bank;
  }

  public void setBank(double bank) {
    this.bank = bank;
  }


  public long getLoanPaymentId() {
    return loanPaymentId;
  }

  public void setLoanPaymentId(long loanPaymentId) {
    this.loanPaymentId = loanPaymentId;
  }


  public long getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(long purchaseId) {
    this.purchaseId = purchaseId;
  }

}
