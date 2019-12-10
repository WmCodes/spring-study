package xyz.drafter.cap4;

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
@WebServlet("/order")
public class DrafterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(Thread.currentThread()+"start");
        try {
            buyCards();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.getWriter().write("order successful.....");
        System.out.println(Thread.currentThread()+" end.....");
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
