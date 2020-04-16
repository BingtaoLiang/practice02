package com.practice.mapper;

import com.practice.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    User findByToken(@Param("token") String token);

    User findByUsername(@Param("username") String username);

    void save(User user);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    void updateUser(User user);

    User selectByPhone(String phone);
}
