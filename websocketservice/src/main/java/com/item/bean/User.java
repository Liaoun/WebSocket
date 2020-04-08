package com.item.bean;


import java.io.Serializable;

public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  private long id;
  private String account;
  private String username;

  public User(String account) {
    this.account = account;
  }

  public User() {
  }

  private String password;
  private String iphone;

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  @Override
  public String toString() {
    return "{\"User\":{"
            + "\"id\":"
            + id
            + ",\"account\":\""
            + account + '\"'
            + ",\"username\":\""
            + username + '\"'
            + ",\"password\":\""
            + password + '\"'
            + ",\"iphone\":\""
            + iphone + '\"'
            + ",\"createtime\":\""
            + createtime + '\"'
            + "}}";

  }

  private java.sql.Timestamp createtime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getIphone() {
    return iphone;
  }

  public void setIphone(String iphone) {
    this.iphone = iphone;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }

}
