package com.example.demo.dao;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    List<Student> selectByName(@Param("name")String name);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}