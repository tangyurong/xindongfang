package com.xdf.entity;


public class Generalbudget {

  private long generalBudgetId;
  private long companyOrganization;
  private long departmentId;
  private long costcenterId;
  private long businessId;
  private long businessDetailsId;
  private double estimate;
  private double controlestimate;
  private double total;
  private double frozen;
  private double thaw;
  private double occupy;
  private double available;
  private double loan;
  private double repayment;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getGeneralBudgetId() {
    return generalBudgetId;
  }

  public void setGeneralBudgetId(long generalBudgetId) {
    this.generalBudgetId = generalBudgetId;
  }


  public long getCompanyOrganization() {
    return companyOrganization;
  }

  public void setCompanyOrganization(long companyOrganization) {
    this.companyOrganization = companyOrganization;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public long getCostcenterId() {
    return costcenterId;
  }

  public void setCostcenterId(long costcenterId) {
    this.costcenterId = costcenterId;
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


  public double getEstimate() {
    return estimate;
  }

  public void setEstimate(double estimate) {
    this.estimate = estimate;
  }


  public double getControlestimate() {
    return controlestimate;
  }

  public void setControlestimate(double controlestimate) {
    this.controlestimate = controlestimate;
  }


  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  public double getFrozen() {
    return frozen;
  }

  public void setFrozen(double frozen) {
    this.frozen = frozen;
  }


  public double getThaw() {
    return thaw;
  }

  public void setThaw(double thaw) {
    this.thaw = thaw;
  }


  public double getOccupy() {
    return occupy;
  }

  public void setOccupy(double occupy) {
    this.occupy = occupy;
  }


  public double getAvailable() {
    return available;
  }

  public void setAvailable(double available) {
    this.available = available;
  }


  public double getLoan() {
    return loan;
  }

  public void setLoan(double loan) {
    this.loan = loan;
  }


  public double getRepayment() {
    return repayment;
  }

  public void setRepayment(double repayment) {
    this.repayment = repayment;
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
