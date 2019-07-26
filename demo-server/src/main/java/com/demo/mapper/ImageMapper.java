package com.demo.mapper;

import com.demo.model.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Classname ImageMapper
 * @Description TODO
 * @Date 2019/6/25 14:42
 * @Created by ChenS
 */
@Mapper
@Component
public interface ImageMapper {
    void insert(Image image);

    List<Image> findAll();
}
