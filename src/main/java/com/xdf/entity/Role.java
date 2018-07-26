package com.xdf.entity;


public class Role {

  private long roleId;
  private long roleTypeId;
  private String roleLevelRelationShip;
  private String roleName;
  private String rights;


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public long getRoleTypeId() {
    return roleTypeId;
  }

  public void setRoleTypeId(long roleTypeId) {
    this.roleTypeId = roleTypeId;
  }


  public String getRoleLevelRelationShip() {
    return roleLevelRelationShip;
  }

  public void setRoleLevelRelationShip(String roleLevelRelationShip) {
    this.roleLevelRelationShip = roleLevelRelationShip;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getRights() {
    return rights;
  }

  public void setRights(String rights) {
    this.rights = rights;
  }

}
