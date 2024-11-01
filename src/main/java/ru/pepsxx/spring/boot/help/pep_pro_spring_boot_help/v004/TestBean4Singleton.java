package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v004;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class TestBean4Singleton {

    @PostConstruct
    void PostConstruct() {
        System.out.println("PostConstruct: TestBean4Singleton - Выполняется один раз");
    }

    @PreDestroy
    void PreDestroy() {
        System.out.println("PreDestroy:    TestBea4nSingleton - Выполняется один раз");
    }

}
