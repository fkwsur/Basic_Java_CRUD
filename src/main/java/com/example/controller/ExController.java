package com.example.controller;

import com.example.models.*;
import com.example.mapper.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ExController {

  private UserMapper userMapper;

  public ExController(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @GetMapping("/users")
  public List<User> AllUser() {
    return userMapper.findAll();
  }

  @PostMapping("/user") 
  public ResponseEntity<Map<String,String>> CreateUser(@RequestBody User req) {
    userMapper.Create(req);
    
    Map<String,String> map = new HashMap<>();
    map.put("result", "success");

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/update") 
  public ResponseEntity<Map<String,String>> UpdateUser(@RequestBody User req) {
    userMapper.Update(req);
    
    Map<String,String> map = new HashMap<>();
    map.put("result", "success");

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/delete") 
  public ResponseEntity<Map<String,String>> DeleteUser(@RequestBody User req) {
    userMapper.Delete(req);
    
    Map<String,String> map = new HashMap<>();
    map.put("result", "success");

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/hello")
  public ResponseEntity<Map<String,String>> Hello() {
    Map<String,String> map = new HashMap<>();
    map.put("result", "hello world");

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/hello2")
  public ResponseEntity<Map<String,String>> Hello2() {
    Map<String,String> map = new HashMap<>();
    map.put("result", "hello??");

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/name") 
  public ResponseEntity<Map<String,String>> YourName(@RequestBody Request req) {
    Map<String,String> map = new HashMap<>();

    map.put("your_name", req.getName());
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/test") 
  public ResponseEntity<Map<String,String>> YourInfo(@RequestBody Request req) {
    Map<String,String> map = new HashMap<>();

    map.put("your_name", req.getName());
    map.put("your_age", req.getAge());
    map.put("your_address", req.getAddress());
    return new ResponseEntity<>(map, HttpStatus.OK);
  }

}

