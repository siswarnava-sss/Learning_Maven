package org.example.main;

import org.example.beans.ResgisteringBean;
import org.example.config.RegisterBeanProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class TestingRegisterBeanMethod {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(RegisterBeanProjectConfig.class);

        ResgisteringBean regBean1 = new ResgisteringBean();
        regBean1.setName("Swarnava Sinha");
        Supplier<ResgisteringBean> regBeanSupplier1= () -> regBean1;


        Supplier<ResgisteringBean> regBean2Supplier = ()->{
            ResgisteringBean regBean2 = new ResgisteringBean();
            regBean2.setName("Mukur Sinha");
            return regBean2;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);

        if((randomNumber & 1) ==0){
            context.registerBean("regBean1",ResgisteringBean.class,regBeanSupplier1);
        }else{
            context.registerBean("regBean2",ResgisteringBean.class,regBean2Supplier);

        }

        ResgisteringBean bean1 = null, bean2 = null;

        try {
            bean1  = context.getBean("regBean1",ResgisteringBean.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating bean1");
        }
        try {
            bean2  = context.getBean("regBean2",ResgisteringBean.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating bean2");
        }

        if (bean1 != null){
            System.out.println("The bean 1 created: "+bean1.getName());
        }else{
            System.out.println("The bean 2 created: "+bean2.getName());
        }
    }
}
