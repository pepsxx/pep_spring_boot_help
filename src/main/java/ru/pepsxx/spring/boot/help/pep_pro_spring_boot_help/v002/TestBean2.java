package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v002;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean2 {

    @Value("${name}")
    String namePro;

    @Value("${yml.name}")
    String nameYml;

    public String getNamePro() {
        return namePro;
    }

    public String getNameYml() {
        return nameYml;
    }
}
