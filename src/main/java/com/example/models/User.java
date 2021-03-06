package com.example.models;

public class User {

  private Long idx;
  private String id;
  private String password;

  public User() {
    super();
  }

  public User(Long idx, String id, String password) {
    super();
    this.idx = idx;
    this.id = id;
    this.password = password;
  }

  public Long getIdx() {
    return idx;
  }

  public String getId() {
    return id;
  }

  public String getPassword() {
    return password;
  }

  public void setIdx(Long idx) {
    this.idx = idx;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}