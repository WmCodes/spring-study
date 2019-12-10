package xyz.drafter.dell.ch1.dao;

import org.springframework.stereotype.Repository;

/**
 * @author wangmeng
 * @date 2019/12/4
 * @desciption
 */
@Repository
public class TestDao {
    private String flag = "1";

    public TestDao(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TestDao{" +
                "flag='" + flag + '\'' +
                '}';
    }

    public TestDao() {
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}

