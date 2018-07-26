package com.xdf.entity;

public class Userinfo {

  private long userId;
  private String userName;
  private String passWord;
  private String telephone;
  private long roleId;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long companyId;
  private long costcenterId;
  private long effective;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
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


  public long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(long companyId) {
    this.companyId = companyId;
  }


  public long getCostcenterId() {
    return costcenterId;
  }

  public void setCostcenterId(long costcenterId) {
    this.costcenterId = costcenterId;
  }


  public long getEffective() {
    return effective;
  }

  public void setEffective(long effective) {
    this.effective = effective;
  }

}
