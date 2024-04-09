package com.jakub.wardrobe;

import mc.thelblack.custominventory.CInventoryManager;
import org.bukkit.plugin.java.JavaPlugin;

// Zakładam, że WardrobeModel jest klasą, którą zdefiniowałeś gdzieś indziej


// Importowanie klasy getWardrobeInventory


public final class Wardrobe extends JavaPlugin {

    static CInventoryManager inventoryManager;
    private getWardrobeInventory wardrobeInventory;

    private static Wardrobe wardrobe;
    public static Wardrobe getInstance() { return wardrobe; }


    @Override
    public void onEnable() {
        wardrobe = this;
        inventoryManager = new CInventoryManager(this);
        wardrobeInventory = new getWardrobeInventory();

        // Dodajemy wywołanie metody loadWardrobeModels z klasy InventoryInit
        InventoryInit.loadWardrobeModels();

        // Tworzymy instancję klasy GuiCommands (lub odpowiednik w twoim projekcie)
        GuiCommands guiCommands = new GuiCommands(wardrobeInventory, this);

        // Rejestrujemy komendy i zdarzenia
        getCommand("szafa").setExecutor(guiCommands);
        getCommand("szafa").setTabCompleter(guiCommands);
        getServer().getPluginManager().registerEvents(guiCommands, this);
    }

}
