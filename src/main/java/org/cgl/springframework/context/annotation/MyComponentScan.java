package org.cgl.springframework.context.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * * 自定义组件扫描注解
 */
@Retention(RetentionPolicy.RUNTIME)        // 在运行时可见
@Target(ElementType.TYPE)                  // 只能用于类上
public @interface MyComponentScan {
    String[] basePackages() default {};    // 指定要扫描的包，默认为空，表示扫描当前类所在的包及子包
}
