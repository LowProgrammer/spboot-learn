package com.demo.mapper;

import com.demo.model.DepartMent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname DepartmentMapper
 * @Description TODO
 * @Date 2019/7/29 10:23
 * @Created by ChenS
 */
@Mapper
@Component
public interface DepartmentMapper {
    void save(DepartMent departMent);

    void update(DepartMent departMent);

    void delete(String name);

    DepartMent findOne(String name);
    List<DepartMent> findAll();
}
