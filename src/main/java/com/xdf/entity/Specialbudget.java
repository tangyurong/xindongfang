package com.xdf.entity;


public class Specialbudget {

  private long specialBudgetId;
  private long companyOrganization;
  private long businessId;
  private long businessDetailsId;
  private double estimate;
  private double controlestimate;
  private double total;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getSpecialBudgetId() {
    return specialBudgetId;
  }

  public void setSpecialBudgetId(long specialBudgetId) {
    this.specialBudgetId = specialBudgetId;
  }


  public long getCompanyOrganization() {
    return companyOrganization;
  }

  public void setCompanyOrganization(long companyOrganization) {
    this.companyOrganization = companyOrganization;
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
