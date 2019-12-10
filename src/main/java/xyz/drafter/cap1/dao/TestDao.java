package xyz.drafter.cap1.dao;

import org.springframework.stereotype.Repository;

/**
 * @author drafter
 * @date 2019/12/5
 * @desciption
 */
@Repository
public class TestDao {
    private String flag = "1";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TestDao{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
