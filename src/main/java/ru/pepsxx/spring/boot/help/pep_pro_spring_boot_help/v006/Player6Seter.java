package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v006;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Player6Seter {

    private Music6 music6;

    @Autowired
    public void setMusic(@Qualifier("music6Rock") Music6 music6) {
        this.music6 = music6;
    }

    public void playMusic() {
        System.out.println("Играет Setter " + music6.song());
    }

}
