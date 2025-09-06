package org.cgl.mainprogram.component;

import org.cgl.springframework.stereotype.MyComponent;
import org.springframework.stereotype.Component;

@MyComponent
public class MyComponentTest {
    public String sayHello() {
        return "Hello, World!";
    }
}
