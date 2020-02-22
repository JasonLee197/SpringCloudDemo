package com.su.controller;

import com.su.DAO.MenuDAO;
import com.su.DAO.TypeDAO;
import com.su.entity.Menu;
import com.su.entity.MenuVO;
import com.su.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private TypeDAO typeDAO;

    @GetMapping("findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit){
        MenuVO menuVO = new MenuVO();
        menuVO.setCode(0);
        menuVO.setMsg("");
        menuVO.setCount(menuDAO.count());
        menuVO.setData(menuDAO.findAll((page - 1) * limit, limit));
        return menuVO;
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu){
        menuDAO.save(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuDAO.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuDAO.update(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuDAO.findById(id);
    }

    @GetMapping("/findAll")
    public List<Type> findAll(){
        return typeDAO.findAll();
    }
}
