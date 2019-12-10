package xyz.drafter.handwriting.controller;


import xyz.drafter.handwriting.annotation.DrafterController;
import xyz.drafter.handwriting.annotation.DrafterQualifier;
import xyz.drafter.handwriting.annotation.DrafterRequestMapping;
import xyz.drafter.handwriting.annotation.DrafterRequestParam;
import xyz.drafter.handwriting.service.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
@DrafterController
@DrafterRequestMapping("/drafter")
public class Controller {

    @DrafterQualifier("serviceImpl")
    private Service service;

    @DrafterRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @DrafterRequestParam("name")String name,@DrafterRequestParam("age")String age ){

        PrintWriter pw = null;
        try {
             pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = service.query(name, age);
        pw.write(result);

    }
}
