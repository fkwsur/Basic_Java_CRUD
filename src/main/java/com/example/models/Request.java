package com.example.models;

public class Request {

  private String name;
  private String age;
  private String address;

  public Request() {
    super();
  }

  public Request(String name,String age,String address) {
    super();
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public String getName() {
    return name;
  } 
  public String getAge() {
    return age;
  } 
  public String getAddress() {
    return address;
  } 

  public void setName(String name) {
    this.name = name;
  }
  public void setAge(String age) {
    this.age = age;
  }
  public void setAddress(String address) {
    this.address = address;
  }

}