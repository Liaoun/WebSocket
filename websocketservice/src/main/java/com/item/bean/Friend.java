package com.item.bean;


import java.io.Serializable;

public class Friend implements Serializable {
  private static final long serialVersionUID = 1L;
  private long id;
  private long palone;
  private long paltwo;
  private java.sql.Timestamp paltime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPalone() {
    return palone;
  }

  @Override
  public String toString() {
    return "{\"Friend\":{"
            + "\"id\":"
            + id
            + ",\"palone\":"
            + palone
            + ",\"paltwo\":"
            + paltwo
            + ",\"paltime\":\""
            + paltime + '\"'
            + "}}";

  }

  public void setPalone(long palone) {
    this.palone = palone;
  }


  public long getPaltwo() {
    return paltwo;
  }

  public void setPaltwo(long paltwo) {
    this.paltwo = paltwo;
  }


  public java.sql.Timestamp getPaltime() {
    return paltime;
  }

  public void setPaltime(java.sql.Timestamp paltime) {
    this.paltime = paltime;
  }

}
