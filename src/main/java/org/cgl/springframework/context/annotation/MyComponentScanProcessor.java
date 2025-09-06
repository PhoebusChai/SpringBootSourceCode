package org.cgl.springframework.context.annotation;
/**
 * @ComponentScanProcessor
 * @Description: 扫描指定包及其子包下的所有类
 * @Author: chenglong
 * @Date: 2023/7/17
 */

import org.cgl.springframework.stereotype.MyComponent;
import org.cgl.springframework.stereotype.MyService;


import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MyComponentScanProcessor {
    /**
     * 扫描指定包及其子包下的所有类
     * @param basePackage 要扫描的基础包
     * @return 扫描到的类列表
     */
    public static List<Class<?>> scan(String basePackage) throws ClassNotFoundException {
        //1. classList 存放扫描到的类
        List<Class<?>> classList = new ArrayList<>();

        //2. 通过类加载器获取指定包下的资源,将包名转换为路径
        String path = basePackage.replace('.', '/');

        //3. 获取资源
        URL url = Thread.currentThread().getContextClassLoader().getResource(path);

        //4. 获取资源对应的文件
        File dir = new File(url.getFile());

        for (File file : dir.listFiles()){
            if (file.isDirectory()){
                //5. 如果是目录，递归扫描
                classList.addAll(scan(basePackage + "." + file.getName()));
            } else if(file.getName().endsWith(".class")){
                //6. 如果是类文件，加载类并添加到 classList
                String className = file.getName().substring(0, file.getName().length() - 6);
                //7. 拼接类的全限定名并加载类
                Class<?> clazz = Class.forName(basePackage + "." + className);
                if(isComponent(clazz)){
                    // 8. 如果类上有 @MyComponent 注解，则添加到 classList
                    classList.add(clazz);
                }
            }
        }
        // 9. 返回扫描到的类列表
        return classList;
    }
    /**
     * 判断类上是否有 @MyComponent 注解
     * @param clazz 要判断的类
     * @return 如果有 @MyComponent 注解，返回 true；否则返回 false
     */
    private static boolean isComponent(Class<?> clazz) {
        //1. 遍历类上的所有注解
        for (Annotation annotation : clazz.getAnnotations()) {
            //2. 如果注解是 @Component，则返回 true
            if (annotation.annotationType().equals(MyComponent.class) ||
                annotation.annotationType().equals(MyService.class) ||
                    annotation.annotationType().equals(org.springframework.stereotype.Repository.class) ||
                    annotation.annotationType().equals(org.springframework.stereotype.Controller.class)) {
                return true;
            }
        }
        //3. 如果没有找到 @MyComponent 注解，返回 false
        return false;
    }
}
