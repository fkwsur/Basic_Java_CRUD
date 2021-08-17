package com.example.models;

public class User {

  private Long idx;
  private String id;

  public User() {
    super();
  }

  public User(Long idx, String id) {
    super();
    this.idx = idx;
    this.id = id;
  }

  public Long getIdx() {
    return idx;
  }

  public String getId() {
    return id;
  }

  public void setIdx(Long idx) {
    this.idx = idx;
  }

  public void setId(String id) {
    this.id = id;
  }

}