package com.example.demo.service.impl;

import com.example.demo.dao.BatchDao;
import com.example.demo.dao.Invoice9021Mapper;
import com.example.demo.model.Invoice9021;
import com.example.demo.service.InfluxDbService;
import com.example.demo.service.TestDbService;
import com.example.demo.util.InfluxDbUtils;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.assertj.core.util.Lists;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 */
@Service
@Slf4j
public class TestDvServiceImpl implements TestDbService {

    @Autowired
    private Invoice9021Mapper invoice9021Mapper;

    @Autowired
    private BatchDao batchDao;

    public void insertRecord(Integer time){
        // 测试插入一条记录
        log.info("into impl");
        time = 0;
        Long totalTime = 0l;
        for(int m=0; m<time; m++){
            Date end = new Date();
            Date start  = DateUtil.parse("2018-12-01 13:55:00");
            Date insert = null;
            List<Invoice9021> records = Lists.newArrayList();
            Invoice9021 record = null;
            for(int i=0; i<1000; i++){
                insert = null;
                insert = getMiddleDate(start, end);
                if(insert != null && i<330){
                    record = Invoice9021.ofRecord1(insert, "考勤1", String.valueOf(insert), "001");
                }else if(insert != null && i>=330 && i< 665){
                    record = Invoice9021.ofRecord2(insert, "考勤2", String.valueOf(insert), "002");
                }else if(insert != null && i >= 665){
                    record = Invoice9021.ofRecord3(insert, "考勤3", String.valueOf(insert), "003");
                }
                //invoice9021Mapper.insert(record);
                records.add(record);
            }
            // testInsert(records);
            invoice9021Mapper.batchSave(records);
            Date date = new Date();
            totalTime = totalTime + date.getTime()-end.getTime();
            log.info("第:{}次 ， use time:{}", m, (date.getTime()-end.getTime()));
        }
        log.info("执行插入数据总用时:{}", totalTime);
        getTest1();
        getTest2();
        getTest3();
        getTest4();
        getTest5();
    }

    public void insert2(Integer times){
        log.info("into this methods:{}", times);
        // times = 0;
        Date date1 = new Date();
        Invoice9021 record = null;
        Date end = new Date();
        Date start  = DateUtil.parse("2018-12-01 13:55:00");
        Date insert = null;
        Long allTime = 0l;
        for(int j=0; j<times;j++){
            List<Invoice9021> records = Lists.newArrayList();
            for(int i=0; i<1000; i++){
                insert = null;
                insert = getMiddleDate(start, end);
                record = Invoice9021.ofRecord1(insert, "考勤1", String.valueOf(insert), "001");
                records.add(record);
            }
            List<Point> points = InfluxDbUtils.converData(records);
            Date date2 = new Date();
            log.info("build data use time:{}",(date2.getTime()-date1.getTime()));

            InfluxDbUtils.writePoints(points);
            Date date3 = new Date();
            allTime = allTime + (date3.getTime()-date2.getTime());
            log.info("write data use time:{}",(date3.getTime()-date2.getTime()));
        }
        log.info("总计用时 time:{}", allTime);
//        InfluxDbUtils.getTestQuery1();
        InfluxDbUtils.getTestAll();
    }

    public void inserInflux(){
        InfluxDB influxDB = new InfluxDbUtils("http://127.0.0.1:8086", "admin", "", "","").getInstance();
        InfluxDbService influxDbService = new InfluxDbService("testdb", "",influxDB,"invoice+9021");
        List<Map<String, Object>> records = Lists.newArrayList();
        List<Point> points = influxDbService.ofPoints(records);
        Point[] points1 = new Point[]{};
        for(int i=0; i< points.size(); i++){
            points1[i] = points.get(i);
        }
        BatchPoints batchPoints = influxDbService.buildBatchPoints("", points1);
        influxDB.write(batchPoints);
    }

    private Date getMiddleDate(Date date1, Date date2){
        Long start = date1.getTime();
        Long end = date2.getTime();
        Long minddle = (long)(start + (end - start)*Math.random());
        return new Date(minddle);
    }

    public List<Invoice9021> getTest1(){
        // 单列加载1000条记录 用时
        Date date1 = new Date();
        List<Invoice9021> lists = invoice9021Mapper.getBySingle("代理1");
        Date date2 = new Date();
        log.info("单列 获取1000条记录用时:{}", (date2.getTime()-date1.getTime()));
        return lists;
    }

    public List<Invoice9021> getTest2(){
        // 多列加载1000条记录用时
        Date date1 = new Date();
        List<Invoice9021> lists = invoice9021Mapper.getByMore("代理1", "001", "001001");
        Date date2 = new Date();
        log.info("多列 获取1000条记录用时:{}", (date2.getTime()-date1.getTime()));
        return lists;
    }

    public List<Invoice9021> getTest3(){
        // 时间范围获取1000条记录用时
        Date start  = DateUtil.parse("2018-12-01 00:00:00");
        Date end = DateUtil.parse("2018-12-31 23:59:59");
        Date date1 = new Date();
        List<Invoice9021> lists = invoice9021Mapper.getByDateRange(start, end);
        Date date2 = new Date();
        log.info("时间范围 获取1000条记录用时:{}", (date2.getTime()-date1.getTime()));
        return lists;
    }

    public List<Invoice9021> getTest4(){
        // 单列 + 时间范围获取1000条记录
        Date start  = DateUtil.parse("2018-12-01 00:00:00");
        Date end = DateUtil.parse("2018-12-31 23:59:59");
        Date date1 = new Date();
        List<Invoice9021> lists = invoice9021Mapper.getBySingleAndDate(start, end, "代理1");
        Date date2 = new Date();
        log.info("单列+时间范围 获取1000条记录用时:{}", (date2.getTime()-date1.getTime()));
        return lists;
    }

    public List<Invoice9021> getTest5(){
        // 多列 + 时间范围获取1000条记录
        Date start  = DateUtil.parse("2018-12-01 00:00:00");
        Date end = DateUtil.parse("2018-12-31 23:59:59");
        Date date1 = new Date();
        List<Invoice9021> lists = invoice9021Mapper.getByMoreAndDate(start, end, "代理1", "001", "001001");
        Date date2 = new Date();
        log.info("多列+时间范围 获取1000条记录用时:{}", (date2.getTime()-date1.getTime()));
        return lists;
    }
}
