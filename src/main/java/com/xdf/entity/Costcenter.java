package com.xdf.entity;


public class Costcenter {

  private long costcenterId;
  private String costcenterName;
  private String costcenterCode;
  private long parentId;
  private long companyMechanismId;
  private long companyId;
  private long effective;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getCostcenterId() {
    return costcenterId;
  }

  public void setCostcenterId(long costcenterId) {
    this.costcenterId = costcenterId;
  }


  public String getCostcenterName() {
    return costcenterName;
  }

  public void setCostcenterName(String costcenterName) {
    this.costcenterName = costcenterName;
  }


  public String getCostcenterCode() {
    return costcenterCode;
  }

  public void setCostcenterCode(String costcenterCode) {
    this.costcenterCode = costcenterCode;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public long getCompanyMechanismId() {
    return companyMechanismId;
  }

  public void setCompanyMechanismId(long companyMechanismId) {
    this.companyMechanismId = companyMechanismId;
  }


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }


  public long getEffective() {
    return effective;
  }

  public void setEffective(long effective) {
    this.effective = effective;
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
