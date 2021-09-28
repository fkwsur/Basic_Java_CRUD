package com.example.controller;

import com.example.models.*;
import com.example.mapper.*;
import com.example.service.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Iterator;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*", allowedHeaders="*")
public class ExController {

  private UserMapper userMapper;
  private Bcrypt bcrypt;
  private JWTManager jwt;

  public ExController(UserMapper userMapper, JWTManager jwt ,Bcrypt bcrypt) {
    this.userMapper = userMapper;
    this.jwt = jwt;
    this.bcrypt = bcrypt;
  }

  @GetMapping("/users")
  public List<User> AllUser() {
    return userMapper.findAll();
  }

  @PostMapping("/user") 
  public ResponseEntity<Map<String,String>> CreateUser(@RequestBody User req) {
    //System.out.println(req);
    //System.out.println(req.getPassword());
    //System.out.println(req.getId());
    
    String hashpassword = bcrypt.HashPassword(req.getPassword());
    req.setPassword(hashpassword);
    userMapper.Create(req);
    Map<String,String> map = new HashMap<>();
    map.put("result", "success");

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> Login(@RequestBody ReqUser req) {
    User user = new User();
    user = userMapper.findOne(req.getId());
    Boolean result = bcrypt.CompareHash(req.getPassword(), user.getPassword());
    Map<String,String> map = new HashMap<>();

    if (result) {
      String token = jwt.CreateToken(user.getId());
  
      map.put("result", token);
      return new ResponseEntity<>(map, HttpStatus.OK);
      } else {
          map.put("result", "password is not correct");
          return new ResponseEntity<>(map, HttpStatus.OK);        
      }

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

