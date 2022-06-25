package org.example.main;

import org.example.beans.CreatingBeansUsingComponent;
import org.example.beans.Vehicle;
import org.example.config.ProjectConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanComponentTest {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);
        CreatingBeansUsingComponent cbComponent = context.getBean(CreatingBeansUsingComponent.class);
        System.out.println(cbComponent.getName());

    }
}
