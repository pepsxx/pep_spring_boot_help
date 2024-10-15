package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PepProSpringBootHelpApplication {

    public static void main(String[] args) {

        // Получение контекста
        ConfigurableApplicationContext context = SpringApplication.run(PepProSpringBootHelpApplication.class, args);

        TestBean testBean = context.getBean("testBean", TestBean.class);

        System.out.println("testBean = " + testBean);

        context.close();


    }

}
