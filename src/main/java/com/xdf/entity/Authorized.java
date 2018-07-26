package com.xdf.entity;

public class Authorized {

  private long authorizedId;
  private long beauthorizedId;
  private long toauthorizedId;
  private String describe;
  private java.sql.Timestamp validity;
  private long effective;
  private long companyId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getAuthorizedId() {
    return authorizedId;
  }

  public void setAuthorizedId(long authorizedId) {
    this.authorizedId = authorizedId;
  }


  public long getBeauthorizedId() {
    return beauthorizedId;
  }

  public void setBeauthorizedId(long beauthorizedId) {
    this.beauthorizedId = beauthorizedId;
  }


  public long getToauthorizedId() {
    return toauthorizedId;
  }

  public void setToauthorizedId(long toauthorizedId) {
    this.toauthorizedId = toauthorizedId;
  }


  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }


  public java.sql.Timestamp getValidity() {
    return validity;
  }

  public void setValidity(java.sql.Timestamp validity) {
    this.validity = validity;
  }


  public long getEffective() {
    return effective;
  }

  public void setEffective(long effective) {
    this.effective = effective;
  }


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
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
