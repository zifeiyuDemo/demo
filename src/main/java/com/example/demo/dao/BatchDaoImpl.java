package com.example.demo.dao;

import com.example.demo.model.Invoice9021;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

/**
 */
@Slf4j
public class BatchDaoImpl implements BatchDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String url = "jdbc:postgresql://localhost:5432/tutorial?useSSL=false";
    private String userName = "postgres";
    private String password = "cxb132456";

    public void testInsert(List<Invoice9021> records){
        Date date1 = new Date();
        log.info("records size:{}", records.size());
        PreparedStatement pstmt = null;
        Connection con = null;
        try{
            con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(false);
            int total = 0;
            int pageSize = 1000;
            int pageCount = 0;
            int index = 0;

            if (records != null && records.size() > 0) {
                total = records.size();
                pageCount = total/pageSize;
                if (total%pageSize > 0) {
                    pageCount += 1;
                }
                Invoice9021 record = null;
                pstmt = con.prepareStatement("insert into invoice_9021 (time, corp_secret, person_name, check_time, cord, device, agent_name) values (?,?,?,?,?,?,?,?)");
                for (int i = 0; i < pageCount; i++) {
                    for (int j = 0; j < pageSize; j++) {
                        index = i*pageSize + j;
                        if (index >= total) break;
                        record = records.get(index);
                        pstmt.setDate(1, new java.sql.Date(record.getTime().getTime()));
                        pstmt.setString(2, record.getCorpSecret());
                        pstmt.setString(3, record.getPersonName());
                        pstmt.setString(4, record.getCheckTime());
                        pstmt.setString(5, record.getCord());
                        pstmt.setString(6, record.getDevice());
                        pstmt.setString(7, record.getAgentName());
                        pstmt.addBatch();
                    }
                    int[] arr = pstmt.executeBatch();
                    log.info("批量插入数据 arr.size:{}", arr.length);
                }
            }
            con.commit();
            Date date2 = new Date();
            log.info("insert records use time:{} ", (date2.getTime()-date1.getTime()));
        }catch(Exception e){
            try {
                log.debug("批量插入调休汇总数据错误。", e);
                con.rollback();
            } catch (Exception e1){
                log.error("批量插入调休汇总数据事务回滚出现异常。",e1);
            }
        }finally {
            try {
                pstmt.close();
                con.close();
            } catch (Exception e2){}
        }
    }

}
