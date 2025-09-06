package org.cgl.springframework.stereotype;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * * 自定义服务注解，表示一个服务组件
 * * 该注解是 @MyComponent 的衍生注解，具有相同的功能
 */
@Target(ElementType.TYPE)                   // 只能用于类上
@Retention(RetentionPolicy.RUNTIME)         // 在运行时可见
public @interface MyService {
    // 组件名称，默认为空字符串
    @AliasFor(annotation = MyComponent.class) // 与 MyComponent 的 value 属性关联
    String value() default "";
}
