package com.jakub.wardrobe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryInit {
    public static List<WardrobeModel> wardrobeModels = new ArrayList<>();

    public static void loadWardrobeModels() {
        wardrobeModels.clear();

        for (String ID : getWardrobeInventory.yamlData.getConfig().getConfigurationSection("artefakty").getKeys(false)) {
            WardrobeModel artefaktModel = new WardrobeModel();

            String materialName = getWardrobeInventory.yamlData.getConfig().getString("artefakty." + ID + ".ItemStack");
            ItemStack itemStack;
            if (materialName != null) {
                itemStack = new ItemStack(Material.valueOf(materialName));
                artefaktModel.setItemStack(itemStack);
            } else {
                System.out.println("Błąd: Brak nazwy materiału dla artefaktu " + ID);
                continue;
            }

            int slotInEq = getWardrobeInventory.yamlData.getConfig().getInt("artefakty." + ID + ".SlotInEq");
            artefaktModel.setSlotInEq(slotInEq);

            List<String> lore = getWardrobeInventory.yamlData.getConfig().getStringList("artefakty." + ID + ".Lore");
            if (lore != null && !lore.isEmpty()) {
                ItemMeta meta = itemStack.getItemMeta();
                meta.setLore(lore);
                itemStack.setItemMeta(meta);
                artefaktModel.setLore(lore);
            }

            String displayName = getWardrobeInventory.yamlData.getConfig().getString("artefakty." + ID + ".name");
            if (displayName != null) {
                ItemMeta meta = itemStack.getItemMeta();
                meta.setDisplayName(displayName);
                itemStack.setItemMeta(meta);
                artefaktModel.setName(displayName);
            } else {
                System.out.println("Błąd: Brak nazwy wyświetlanej dla artefaktu " + ID);
            }

            wardrobeModels.add(artefaktModel);
        }
    }
}
