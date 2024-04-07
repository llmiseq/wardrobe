package com.jakub.wardrobe;

import mc.thelblack.custominventory.CInventoryManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

// Zakładam, że WardrobeModel jest klasą, którą zdefiniowałeś gdzieś indziej
import com.jakub.wardrobe.WardrobeModel;



// Importowanie klasy getWardrobeInventory
import com.jakub.wardrobe.getWardrobeInventory;

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


    }
}
