package xyz.drafter.cap4;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author drafter
 * @date 2019/12/9
 * @desciption
 */
@WebServlet(value = "/asyncOrder",asyncSupported = true)
public class DarferAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("主线程开始: "+Thread.currentThread()+"start "+System.currentTimeMillis());
        final AsyncContext startAsync = req.startAsync();
        startAsync.start(new Runnable() {
            @Override
            public void run() {
                try {

                    System.out.println("副线程开始: "+Thread.currentThread()+"start "+System.currentTimeMillis());
                    buyCards();
                    startAsync.complete();
                    startAsync.getResponse().getWriter().write("order successful.....");

                    System.out.println("副线程结束: "+Thread.currentThread()+"end... "+System.currentTimeMillis());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        System.out.println("主线程结束: "+Thread.currentThread()+" end.....  "+System.currentTimeMillis());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    public void buyCards() throws InterruptedException {
        System.out.println(Thread.currentThread()+".............");
        Thread.sleep(5000);
    }
}
