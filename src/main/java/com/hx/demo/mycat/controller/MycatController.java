package com.hx.demo.mycat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangfei
 * @date 2019/5/21 13:30
 */
@RestController
@Slf4j
public class MycatController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public Object list() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT id,name FROM item ");
        return rows;
    }

    @RequestMapping("/add")
    public Object add() {
        jdbcTemplate.execute("INSERT INTO item (id,name) VALUES (7,'zh'),(8,'ch'),(9,'bcg')");
        return "success";
    }

    @RequestMapping("/update")
    public Object update() {
        jdbcTemplate.execute("UPDATE item SET name ='KK' WHERE id = 5");
        return "success";
    }

    @RequestMapping("/del")
    public Object delete() {
        jdbcTemplate.execute("DELETE FROM item WHERE id = 5");
        return "success";
    }

    @RequestMapping("/user/add")
    public Object addUser() {
        jdbcTemplate.execute("INSERT INTO user (id,name,age) VALUES (1,'张三',25),(2,'李四',30),(3,'王五',28)");
        return "success";
    }

    @RequestMapping("/user/list")
    public Object listUser() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT id,name FROM USER ");
        return rows;
    }

    @RequestMapping("/part/batchInsert")
    public Object partBatchInsert() {
        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 3598601; i < 10000000; i++) {
            batchArgs.add(new Object[]{i * 2, i + "mm", i});
            if (batchArgs.size() % 500 == 0) {
                final List<Object[]> finalBatchArgs = batchArgs;
                jdbcTemplate.batchUpdate("INSERT INTO t1 (col1,col2,col3) VALUES (?,?,?)", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setObject(1, finalBatchArgs.get(i)[0]);//要注意，下标从1开始
                        ps.setObject(2, finalBatchArgs.get(i)[1]);
                        ps.setObject(3, finalBatchArgs.get(i)[2]);
                    }

                    @Override
                    public int getBatchSize() {
                        return finalBatchArgs.size();
                    }
                });
                batchArgs = new ArrayList<>();
            }
        }
        return "success";
    }

    @RequestMapping("/part/batchInsert2")
    public Object partBatchInsert2() {
        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            batchArgs.add(new Object[]{i * 2, i + "mm", i});
            if (batchArgs.size() % 500 == 0) {
                final List<Object[]> finalBatchArgs = batchArgs;
                jdbcTemplate.batchUpdate("INSERT INTO t2 (col1,col2,col3) VALUES (?,?,?)", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setObject(1, finalBatchArgs.get(i)[0]);//要注意，下标从1开始
                        ps.setObject(2, finalBatchArgs.get(i)[1]);
                        ps.setObject(3, finalBatchArgs.get(i)[2]);
                    }

                    @Override
                    public int getBatchSize() {
                        return finalBatchArgs.size();
                    }
                });
                batchArgs = new ArrayList<>();
            }
        }
        return "success";
    }

    @RequestMapping("/part/batchInsert3")
    public Object partBatchInsert3() {
        List<Object[]> batchArgs = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            batchArgs.add(new Object[]{i * 2, i + "mm", i});
            if (batchArgs.size() % 500 == 0) {
                final List<Object[]> finalBatchArgs = batchArgs;
                jdbcTemplate.batchUpdate("INSERT INTO t3 (col1,col2,col3) VALUES (?,?,?)", new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setObject(1, finalBatchArgs.get(i)[0]);//要注意，下标从1开始
                        ps.setObject(2, finalBatchArgs.get(i)[1]);
                        ps.setObject(3, finalBatchArgs.get(i)[2]);
                    }

                    @Override
                    public int getBatchSize() {
                        return finalBatchArgs.size();
                    }
                });
                batchArgs = new ArrayList<>();
            }
        }
        return "success";
    }

}
