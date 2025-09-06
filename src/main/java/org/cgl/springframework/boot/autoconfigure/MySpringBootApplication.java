package org.cgl.springframework.boot.autoconfigure;
/**
 *  @SpringBootApplication 注解是一个组合注解，包含了以下三个注解的功能：
 *  *  1. @Configuration：标记该类为配置类，类似于传统的 Spring 配置文件。
 *  *  2. @EnableAutoConfiguration：启用 Spring Boot 的自动配置机制，根据类路径中的依赖自动配置 Spring 应用程序。
 *  *  3. @ComponentScan：启用组件扫描，自动发现并注册被 @Component、@Service、@Repository 和 @Controller 注解标记的类为 Spring Bean。
 */

import org.cgl.springframework.context.annotation.MyComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)                   // 只能用于类上
@Retention(RetentionPolicy.RUNTIME)         // 在运行时可见
@Configuration                              // 标记为配置类
@EnableAutoConfiguration                    // 启用自动配置
//@ComponentScan                            // 启用组件扫描
@MyComponentScan
public @interface MySpringBootApplication {
}
