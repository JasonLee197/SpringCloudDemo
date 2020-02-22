package com.su.DAO;

import com.su.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "menuDAO")
public interface MenuDAO {
    public List<Menu> findAll(int index, int limit);
    public int count();
    public void save(Menu menu);
    public void update(Menu menu);
    public void deleteById(long id);
    public Menu findById(long id);
}
