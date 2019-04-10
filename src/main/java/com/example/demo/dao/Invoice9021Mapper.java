package com.example.demo.dao;

import com.example.demo.model.Invoice9021;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface Invoice9021Mapper {

    int insert(Invoice9021 record);

    int insertSelective(Invoice9021 record);

    int batchSave(List<Invoice9021> records);

    List<Invoice9021> getBySingle(@Param("agentName")String agentName);

    List<Invoice9021> getByMore(@Param("agentName")String agentName, @Param("cord")String cord,  @Param("device")String device);

    List<Invoice9021> getByDateRange(@Param("begin")Date begin, @Param("end")Date end);

    List<Invoice9021> getBySingleAndDate(@Param("begin")Date begin, @Param("end")Date end, @Param("agentName")String agentName);

    List<Invoice9021> getByMoreAndDate(@Param("begin")Date begin, @Param("end")Date end, @Param("agentName")String agentName, @Param("cord")String cord, @Param("device")String device);

}