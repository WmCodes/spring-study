package xyz.drafter.handwriting.service;

import xyz.drafter.handwriting.annotation.DrafterService;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
@DrafterService("serviceImpl")
public class ServiceImpl implements Service {
    @Override
    public String query(String name, String age) {
        return "name == "+name+" ; age == "+ age;
    }

    @Override
    public String insert(String param) {
        return "isnert successful...";
    }

    @Override
    public String update(String param) {
        return "update successful...";
    }
}
