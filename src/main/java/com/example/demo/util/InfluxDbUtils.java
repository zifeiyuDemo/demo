package com.example.demo.util;

import com.example.demo.model.Invoice9021;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.DateUtil;
import org.assertj.core.util.Lists;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * influxDB Utils
 */
@Getter
@Setter
@Slf4j
public class InfluxDbUtils {
    private static String userName = "admin";
    private static String password = "";
    private static String url = "http://127.0.0.1:8086";
    private static String dbName = "testdb";
    private static String policyName = "autogen";

    private final static String measurementName = "invoice_9041";

    private static InfluxDB influxDB;

    public InfluxDbUtils(String url, String userName, String password, String dbName, String policyName){
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.dbName = dbName;
        this.policyName = policyName==""?"autogen":policyName;
    }

    static {
        if(influxDB == null){
            influxDB = InfluxDBFactory.connect(url,userName,password);
        }
    }

    public InfluxDB getInstance(){
        if(influxDB == null){
            synchronized (this){
                if(influxDB == null){
                    influxDB = InfluxDBFactory.connect(url,userName,password);
                }
            }
        }
        return influxDB;
    }

    // 设置数据库
    public void setDb(String dbName){
        influxDB.setDatabase(dbName);
    }

    // 设置保存策略
    public void setPolicy(String policyName){
        influxDB.setRetentionPolicy(policyName);
    }

    // 需要有测试连接
    public boolean testConnection(){
        boolean isConnection = false;
        try{
            if(influxDB!=null){
                Pong pong = influxDB.ping();
                if(pong != null){
                    isConnection = true;
                }
            }
        }catch(Exception e){
            log.info("test connection influx error:{}", e);
        }
        return isConnection;
    }

    // 插入数据
    // 单条插入 先不处理
    // ConsistencyLevel
    // consistency 一致性处理 ： 到s ms ns 级别  如果有tags 重复记录 后来者会覆盖 之前的记录
    // tags 中应该还有几个字段： corp cord checkTime
    public static void writeBatch(BatchPoints batchPoints){
        if(batchPoints != null){
            influxDB.write(batchPoints);
        }
    }

    public static void writePoints(List<Point> points){
        if(influxDB == null){
            influxDB = InfluxDBFactory.connect(url,userName,password);
        }
        if(points!=null && !points.isEmpty()){
            BatchPoints batchPoints = buildBatchPoints(points);
            writeBatch(batchPoints);
        }
    }

    // tags 上限 10W个
    // 每个库 列数fields 上限100W

    // 需要构建BatchPoints
    public static BatchPoints buildBatchPoints(List<Point> points){
        // 传入参数有可能为： list<Map<String, Object>>
        BatchPoints batchPoints= null;
        if(!points.isEmpty()){
            Point[] pointses = points.toArray(new Point[0]);
            BatchPoints.Builder builder = BatchPoints.database(dbName);
            builder.points(pointses);
            builder.retentionPolicy(policyName);
            builder.consistency(InfluxDB.ConsistencyLevel.ALL);
            batchPoints = builder.build();
        }
        return batchPoints;
    }

    // 构建point
    public Point buildPoint(Map<String, Object> records, Map<String, String> tags, Map<String, Object> fields){
        // 仅接受记录 records 需要个对象存储一下。
        Point point = null;
        if(records != null){
            Point.Builder builder = Point.measurement(measurementName);
            fields.put("corp", String.valueOf(records.get("corp")));
            fields.put("cord", String.valueOf(records.get("cord")));
            fields.put("checkTime", String.valueOf(records.get("checkTime")));
            fields.put("userName", String.valueOf(records.get("userName")));
            fields.put("agentName", String.valueOf(records.get("agentName")));
            fields.put("device", String.valueOf(records.get("device")));

            builder.tag(tags);
            builder.fields(fields);
            builder.time(System.currentTimeMillis(), TimeUnit.MILLISECONDS);

            point = builder.build();
        }
        return point;
    }

    public static List<Point> converData(List<Invoice9021> records){
        // invoice9021 ==> point 记录
        List<Point> points = Lists.newArrayList();
        if(!records.isEmpty()){
            Point.Builder builder = null;
            Map<String, String> tags = new TreeMap<>();
            Map<String, Object> fields = new TreeMap<>();
            for(Invoice9021 invoice9021 : records){
                Point point = null;
                builder = Point.measurement(measurementName);
                fields.put("corpSecret", invoice9021.getCorpSecret());
                fields.put("cord", invoice9021.getCord());
                fields.put("checkTime", invoice9021.getCheckTime());
                fields.put("personName", invoice9021.getPersonName());
                fields.put("agentName", invoice9021.getAgentName());
                fields.put("device", invoice9021.getDevice());

                builder.tag(tags);
                builder.fields(fields);

                // 设置签卡时间
                //
                // String checkTime = invoice9021.getCheckTime();
                builder.time(System.nanoTime(), TimeUnit.MICROSECONDS);

                point = builder.build();
                points.add(point);
            }
        }
        return points;
    }

    public void testBuildData(int times){
        for(int i=0; i< times; i++){

        }
    }
    // 查询数据
    // 单条件查询
    public static void getTestQuery1(String sql){
        Query query = new Query(sql, dbName);
        if(query!=null){
            QueryResult result = influxDB.query(query);
            // log.info("result:{}", result.getResults().toArray());
//            for(QueryResult.Result result1 : result.getResults()){
//                for(QueryResult.Series series : result1.getSeries()){
//                    log.info("values:{}", series.getValues().toString());
//                }
//            }
        }else{
            log.info("query is error");
        }
    }
    // 多条件查询
    public static void getTestAll(){

        Date date0 = new Date();
        String sql = "select count(agentName) from " + measurementName;
        getTestQuery1(sql);
        Date date1 = new Date();
        log.info("select count(*) use time :{}", (date1.getTime()-date0.getTime()));

        String sql1 = "select * from "+measurementName + " where agentName='代理1' limit 1000;";
        getTestQuery1(sql1);
        Date date2 = new Date();
        log.info("select single use time :{}", (date2.getTime()-date1.getTime()));

        String sql2 = "select * from "+measurementName + " where agentName = '代理1' and cord ='001' and device = '001001' limit 1000";
        getTestQuery1(sql2);
        Date date3 = new Date();
        log.info("select more use time:{}", (date3.getTime()-date2.getTime()));

        Date start  = DateUtil.parse("2018-12-01 00:00:00");
        Date end = DateUtil.parse("2018-12-31 23:59:59");
        String sql3 = "select * from " + measurementName + " where time>'" + start.getTime() + "' and time<'" + end.getTime() + "' limit 1000";
        getTestQuery1(sql3);
        Date date4 = new Date();
        log.info("select dateRange use time:{}", (date4.getTime()-date3.getTime()));

        String sql4 = "select * from " + measurementName + " where agentName='代理1' and  time>'" + start.getTime() + "' and time<'" + end.getTime() + "' limit 1000" ;
        getTestQuery1(sql4);
        Date date5 = new Date();
        log.info("select dateRange+single use time:{}", (date5.getTime()-date4.getTime()));

        String sql5 = "select * from " + measurementName + " where agentName='代理1' and  time>'" + start.getTime() + "' and time<'" + end.getTime() + "' and cord='001' and device='001001' limit 1000" ;
        getTestQuery1(sql5);
        Date date6 = new Date();
        log.info("select dateRange+more use time:{}", (date6.getTime()-date5.getTime()));
    }

    // 删除数据

}
