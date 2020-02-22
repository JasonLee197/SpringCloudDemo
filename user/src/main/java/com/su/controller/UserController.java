package com.su.controller;

import com.su.DAO.UserDAO;
import com.su.entity.User;
import com.su.entity.UserVO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@MapperScan("/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int page,
                          @PathVariable("limit") int limit){
        UserVO userVO = new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userDAO.count());
        userVO.setData(userDAO.findAll((page - 1) * limit, limit));
        return userVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userDAO.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userDAO.deleteById(id);
    }
}
