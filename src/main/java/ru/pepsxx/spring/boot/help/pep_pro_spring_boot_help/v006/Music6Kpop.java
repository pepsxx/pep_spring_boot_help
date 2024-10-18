package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v006;

import org.springframework.stereotype.Component;

@Component
public class Music6Kpop implements Music6 {

    @Override
    public String song() {
        return "MusicKpop";
    }
}
