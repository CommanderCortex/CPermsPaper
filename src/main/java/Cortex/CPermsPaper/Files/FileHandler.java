package Cortex.CPermsPaper.Files;

import java.io.File;

public class FileHandler {
    public static void setup(){
        String MainDIR = "plugins/Cortex/";

        File MAIN = new File(MainDIR);
        if(!MAIN.exists())
            MAIN.mkdirs();

        File PlayerData = new File(MainDIR + "PlayerData/");
        if(!PlayerData.exists())
            PlayerData.mkdirs();
    }
}