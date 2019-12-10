package xyz.drafter.cap3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author drafter
 * @date 2019/12/6
 * @desciption
 */
@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 操作数据的方法
    public void insert(){
        String sql = "insert into `order` (orderTime,orderMoney,orderStatus) values (?,?,?)";
        jdbcTemplate.update(sql,new Date(),100,0);

    }
}
