package com.jakub.wardrobe;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class YamlData {

    /*
    Klasa YamlData.java jest odpowiedzialna za pobieranie danych z configu Artefakty.yml
    */

    private YamlConfiguration config;
    private final File configFile;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public YamlData(String ymlName){
        this.configFile = new File(Wardrobe.getInstance().getDataFolder(), ymlName);
        this.config = YamlConfiguration.loadConfiguration(configFile);
        setupConfig(configFile, ymlName);
        reload();
    }


    private void setupConfig(File file, String ymlName){

        File dataDir = new File(Wardrobe.getInstance().getDataFolder(), "data");
        if(!dataDir.exists()) dataDir.mkdir();


        File logsDir = new File(Wardrobe.getInstance().getDataFolder(), "logs");
        if(!logsDir.exists()) logsDir.mkdir();

        if(!file.exists()){
            try{
                Wardrobe.getInstance().saveResource(ymlName, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void reload(){
        try {
            config = YamlConfiguration.loadConfiguration(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public YamlConfiguration getConfig() {
        return config;
    }


    public File getConfigFile() {
        return configFile;
    }
}