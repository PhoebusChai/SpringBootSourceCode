package org.cgl.mainprogram;

import org.cgl.mainprogram.component.MyComponentTest;
import org.cgl.springframework.boot.autoconfigure.MySpringBootApplication;
import org.cgl.springframework.context.annotation.MyComponentScan;
import org.cgl.springframework.context.annotation.MyComponentScanProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@MySpringBootApplication
@MyComponentScan(basePackages = "org.cgl")
public class MyApplication {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 通过反射获取 MyComponentScan 注解的 basePackages 配置
        MyComponentScan myComponentScan = MyApplication.class.getAnnotation(MyComponentScan.class);
        String[] basePackages = myComponentScan.basePackages();

        //2. 执行扫描操作
        List<Class<?>> scannedClasses = MyComponentScanProcessor.scan(basePackages[0]);
        //3. 创建 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        //4. 注册所有扫描到的类作为 Bean
        for (Class<?> clazz : scannedClasses) {
            context.register(clazz);
        }

        //5. 启动 Spring 应用上下文
        context.refresh();

        // 验证 Bean 是否注册成功
        MyComponentTest myComponent = context.getBean(MyComponentTest.class);
        System.out.println(myComponent.sayHello());
    }
}
