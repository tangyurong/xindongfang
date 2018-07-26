package com.xdf.entity;


public class Companymechanism {

  private long mechanismId;
  private String mechanismName;
  private long mechanismParentId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getMechanismId() {
    return mechanismId;
  }

  public void setMechanismId(long mechanismId) {
    this.mechanismId = mechanismId;
  }


  public String getMechanismName() {
    return mechanismName;
  }

  public void setMechanismName(String mechanismName) {
    this.mechanismName = mechanismName;
  }


  public long getMechanismParentId() {
    return mechanismParentId;
  }

  public void setMechanismParentId(long mechanismParentId) {
    this.mechanismParentId = mechanismParentId;
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
