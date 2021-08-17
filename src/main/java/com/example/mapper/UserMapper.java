package com.example.mapper;

import com.example.models.*;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

  @Select("select * from user")
  List<User> findAll();

  @Insert("insert into user(id) values(#{id})")
  void Create(User user);

  @Update("update user set id = #{id} where idx = #{idx}")
  void Update(User user);

  @Delete("delete from user where idx = #{idx}")
  void Delete(User user);

}