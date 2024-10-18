package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Spring5Config {

    @Bean
    Music5Con music5Con(){
        return new Music5Con("ConstructorName");
    }

    @Bean
    Music5Set music5Set(){
        Music5Set music5Set = new Music5Set();
        music5Set.setName("SetName");
        return music5Set;
    }

    @Bean
    Music5Fab mu5FabCon(){
        return Music5Fab.getMusic5FabCon();
    }

    @Bean
    Music5Fab mu5FabSet(){
        return Music5Fab.getMusic5FabSet();
    }

}
