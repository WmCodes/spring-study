package xyz.drafter.handwriting.servlet;

import xyz.drafter.handwriting.annotation.DrafterController;
import xyz.drafter.handwriting.annotation.DrafterQualifier;
import xyz.drafter.handwriting.annotation.DrafterRequestMapping;
import xyz.drafter.handwriting.annotation.DrafterService;
import xyz.drafter.handwriting.controller.Controller;
import xyz.drafter.handwriting.hand.HandToolsService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangmeng
 * @date 2019/12/9
 * @desciption
 */
public class DispatcherServlet extends HttpServlet {

    List<String> classNames = new ArrayList<>();
    Map<String,Object> beans = new HashMap<>();
    Map<String,Object> handlerMapping = new HashMap<>();




    public DispatcherServlet() {
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 扫描哪些类需要被实例化 class
        doScanPackage("xyz.drafter.handwriting");
        for (String cname:classNames){
            System.out.println(cname);
        }

        // classNames包含所有bean全类名路径
        doInstance();

        // 依赖注入
        iocDI();

        // 建立URL 与method的映射关系
        handlerMapper();
        for (Map.Entry<String,Object>entry:handlerMapping.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }





    }


    private void handlerMapper(){

        if (beans.entrySet().size()<= 0){
            System.out.println("类没有被实例化...");
            return;
        }
        for (Map.Entry<String,Object> entry:beans.entrySet()){
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(DrafterController.class)){
                DrafterRequestMapping requestMapping = clazz.getAnnotation(DrafterRequestMapping.class);
                String classPath = requestMapping.value();
                Method[] methods = clazz.getMethods();
                for (Method method:methods){
                    if (method.isAnnotationPresent(DrafterRequestMapping.class)){
                        DrafterRequestMapping mapping = method.getAnnotation(DrafterRequestMapping.class);
                        String methodUrl = mapping.value();
                        handlerMapping.put(classPath+methodUrl, method);
                    }
                }
             }
        }

    }

    private void iocDI(){
        if (beans.entrySet().size()<= 0){
            System.out.println("类没有被实例化...");
            return;
        }
        // 把service注入到controller
        for (Map.Entry<String,Object> entry:beans.entrySet()){
            Object instance = entry.getValue();
            //获取类声明了哪些注解
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(DrafterController.class)){
                Field[] fields = clazz.getDeclaredFields();
                for (Field field:fields){
                    if (field.isAnnotationPresent(DrafterQualifier.class)){
                            DrafterQualifier qualifier = field.getAnnotation(DrafterQualifier.class);
                            String value = qualifier.value();
                            field.setAccessible(true);
                        try {
                            field.set(instance, beans.get(value));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }

        }


    }

    // 扫描class类
    private void doScanPackage(String basePackage) {
        URL url = this.getClass().getClassLoader().getResource("/"+basePackage.replaceAll("\\.", "/"));
        String fileStr = url.getFile();
        File file = new File(fileStr);
        String[] files = file.list();
        for (String path:files){
            File filePath = new File(fileStr+path);// 磁盘路径+xyz.drafter.handwriting
            if (filePath.isDirectory()){
                doScanPackage(basePackage+"."+path);
            }else {
                classNames.add(basePackage+"."+filePath.getName());//xyz/drafter/hhh/service/class
            }
        }

    }

    private void doInstance(){
        if (classNames.size()<= 0){
            System.out.println("doScanFailed......");
            return;
        }

        // 遍历扫描到的class全类名路径  反射创建
        for (String className:classNames){
            String cn = className.replaceAll(".class", "");
            try {
                Class<?> clazz = Class.forName(cn);

                if (clazz.isAnnotationPresent(DrafterController.class)){
                    //DrafterController controller = clazz.getAnnotation(DrafterController.class);
                    Object instance = clazz.newInstance();
                    DrafterRequestMapping requestMapping = clazz.getAnnotation(DrafterRequestMapping.class);
                    String key = requestMapping.value();
                    beans.put(key, instance);

                    //IOC map<  map.put<key,instance>>
                }else if (clazz.isAnnotationPresent(DrafterService.class)){
                    DrafterService service = clazz.getAnnotation(DrafterService.class);
                    Object instance = clazz.newInstance();
                    beans.put(service.value(), instance);
                }else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 拿到drafter-mvc/drafter/query
        String uri = req.getRequestURI();
        // 拿到 drafter-mvc
        String context = req.getContextPath();
        String path = uri.replace(context, "");
        Method method = (Method) handlerMapping.get(path);

        Controller controller = (Controller) beans.get("/"+path.split("/")[1]);

        HandToolsService handToolsService = (HandToolsService) beans.get("drafterHandTool");
        Object[] args = handToolsService.hand(req, resp, method, beans);
        try {
            method.invoke(controller, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
