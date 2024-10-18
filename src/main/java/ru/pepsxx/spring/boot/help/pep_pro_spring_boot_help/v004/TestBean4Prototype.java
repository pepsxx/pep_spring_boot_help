package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v004;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TestBean4Prototype {

    @PostConstruct
    void PostConstruct() {
        System.out.println("PostConstruct: TestBean4Prototype - Выполняется каждый раз");
    }

    @PreDestroy
    void PreDestroy() {
        System.out.println("PreDestroy:    TestBean4Prototype - Не Выполняется ни когда");
    }

}
