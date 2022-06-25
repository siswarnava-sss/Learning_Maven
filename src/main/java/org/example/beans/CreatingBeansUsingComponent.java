package org.example.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CreatingBeansUsingComponent {

    private String name;

    public void setName(String name) {
        this.name =  name;
    }

    public String getName() {
        return name;
    }

    public void printHello(){
        System.out.println("Hello " + this.getName());

    }

    @PostConstruct
    public void initialize(){
        this.name="Honda";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying beans");
    }
}
