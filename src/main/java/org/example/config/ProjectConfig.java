package org.example.config;

import org.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    Vehicle vehicle1(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Swarnava");
        return vehicle;
    }
    @Bean
    Vehicle vehicle2(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Swarnava Sinha");
        return vehicle;
    }
    @Primary
    @Bean("ferrariVehicle")
    Vehicle vehicle3(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Ferrari");
        return vehicle;
    }
    @Bean
    String hello(){
        return "Hello World";
    }

    @Bean
    Integer num (){
        return 12;
    }
}
