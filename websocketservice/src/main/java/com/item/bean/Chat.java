package com.item.bean;


import java.io.Serializable;
import java.sql.Timestamp;

public class Chat implements Serializable {
  private static final long serialVersionUID = 1L;
  private long id;
  private User send;
  private User accept;
  private String message;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getSend() {
    return send;
  }

  public void setSend(User send) {
    this.send = send;
  }

  public User getAccept() {
    return accept;
  }

  public void setAccept(User accept) {
    this.accept = accept;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  private String file;
  private java.sql.Timestamp time;



}
