package ru.pepsxx.spring.boot.help.pep_pro_spring_boot_help.v005;

public class Music5Fab {

    private String name;

    private Music5Fab(){}

    private Music5Fab(String name){
        this.name = name;
    }

    private void setName(String name) {
        this.name = name;
    }

    static Music5Fab getMusic5FabCon() {
        return new Music5Fab("FabricConstructorName");
    }

    static Music5Fab getMusic5FabSet() {
        Music5Fab music5Fab = new Music5Fab();
        music5Fab.setName("FabricSetName");
        return music5Fab;
    }

    public String getName() {
        return name;
    }

}
