package com.su.DAO;

import com.su.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "AdminDAO")
public interface AdminDAO {
    public Admin login(String username, String password);
}
