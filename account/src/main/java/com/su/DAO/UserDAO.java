package com.su.DAO;

import com.su.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "userDAO")
public interface UserDAO {
    public User login(String username, String password);
}
