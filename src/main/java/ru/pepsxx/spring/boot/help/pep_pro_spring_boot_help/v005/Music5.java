package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Music5 {

    @Value("${yml.name}")
    private String name;

    public String getName() {
        return name;
    }

}
