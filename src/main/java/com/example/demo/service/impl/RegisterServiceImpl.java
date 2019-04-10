package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private StudentMapper studentMapper;

    public Boolean registerStudent(String name, String pwd){
        log.info("input name:{}, pwd:{}", name, pwd);
        List<Student> sdl = studentMapper.selectByName(name);
        log.info("sdl:{}",sdl);
        if(sdl!=null && sdl.size()>0){
            return false;
        }else{
            Student st = new Student();
            st.setId(1L);
            st.setName(name);
            st.setPwd(pwd);
            return studentMapper.insert(st)>0?true:false;
        }
    }
}
