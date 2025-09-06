package org.cgl.springframework.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)                   // 只能用于类上
@Retention(RetentionPolicy.RUNTIME)         // 在运行时可见
public @interface MyComponent {
    // 组件名称，默认为空字符串
    String value() default "";
}
