package com.xdf.entity;


public class Role {

  private Integer roleId;
  private Integer roleTypeId;
  private String roleLevelRelationShip;
  private String roleName;
  private String rights;


  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public Integer getRoleTypeId() {
    return roleTypeId;
  }

  public void setRoleTypeId(Integer roleTypeId) {
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
