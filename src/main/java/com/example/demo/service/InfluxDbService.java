package com.example.demo.service;

import org.assertj.core.util.Lists;
import org.influxdb.InfluxDB;
import org.influxdb.dto.BatchPoints;
import org.influxdb.dto.Point;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InfluxDb service
 */
public class InfluxDbService {

    private String dbName; // 数据库名称
    private String policyName; // 数据保存策略名称
    private String measurementName;
    private InfluxDB influxDB;

    public InfluxDbService(String dbName, String policyName, InfluxDB influxDB, String measurementName){
        this.dbName = dbName;
        this.policyName = policyName;
        this.influxDB = influxDB;
        this.measurementName = measurementName;
    }

    // 使用 influxdb.write(BatchPoints batchPoints)
    // 创建BatchPoinst

    public BatchPoints buildBatchPoints(String policyName, Point... points){
        BatchPoints.Builder builder = BatchPoints.database(dbName);
        builder.retentionPolicy(policyName);
        builder.points(points);
        BatchPoints batchPoints = builder.build();
        return batchPoints;
    }

    public List<Point> ofPoints(List<Map<String, Object>> records){
        List<Point> points = Lists.newArrayList();
        Point.Builder pointBuilder = Point.measurement(measurementName);
        // 传入多条记录
        Map<String, String> tags; // tags
        Map<String, Object> fields; // fields 健--值
        for(Map<String, Object> record : records){
            tags = new HashMap<>();
            fields = new HashMap<>();
            //4个信息  2个tags  2个fields
            tags.put("corp", String.valueOf(record.get("corp")));
            tags.put("card", String.valueOf(record.get("cord")));
            fields.put("userName", String.valueOf(record.get("name")));
            fields.put("checkTime", String.valueOf(record.get("checkTime")));
            pointBuilder.tag(tags);
            pointBuilder.fields(fields);
//          pointBuilder.time();
            Point point = pointBuilder.build();
            points.add(point);
        }
        return points;
    }

    private Date converDate(String obj){
        Date checkTime = new Date();
        return null;
    }


}
