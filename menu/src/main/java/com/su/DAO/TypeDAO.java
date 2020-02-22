package com.su.DAO;

import com.su.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "typeDAO")
public interface TypeDAO {
    public List<Type> findAll();
}
