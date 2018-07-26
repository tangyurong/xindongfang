package com.xdf.entity;


public class Businessdetails {

  private long businessDetailsId;
  private String businessDetailsName;
  private long businessId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getBusinessDetailsId() {
    return businessDetailsId;
  }

  public void setBusinessDetailsId(long businessDetailsId) {
    this.businessDetailsId = businessDetailsId;
  }


  public String getBusinessDetailsName() {
    return businessDetailsName;
  }

  public void setBusinessDetailsName(String businessDetailsName) {
    this.businessDetailsName = businessDetailsName;
  }


  public long getBusinessId() {
    return businessId;
  }

  public void setBusinessId(long businessId) {
    this.businessId = businessId;
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
