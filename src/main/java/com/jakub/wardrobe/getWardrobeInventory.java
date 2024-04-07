package com.jakub.wardrobe;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;

import static com.jakub.wardrobe.InventoryInit.artefaktModels;

// Zakładam, że WardrobeModel jest klasą, którą zdefiniowałeś gdzieś indziej

// Zakładam, że Wardrobe i InventoryManager są klasami, które zdefiniowałeś gdzieś indziej


public class getWardrobeInventory {
    private static final ItemStack FILL_BLACK;

    public static YamlData yamlData = new YamlData("Artefakty.yml");

    static {
        FILL_BLACK = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = FILL_BLACK.getItemMeta();
        meta.setDisplayName(" ");
        FILL_BLACK.setItemMeta(meta);
    }

    public Inventory getWardrobeInventory() {
        System.out.println("Wywołano metodę getWardrobeInventory");
        return Wardrobe.inventoryManager.builder().setTitle("§6Twoja Szafa").setRows(6).fill(FILL_BLACK)
                .addEventInventoryOpen((p, e) -> {
                    //System.out.println("Wywołano zdarzenie otwarcia ekwipunku dla gracza: " + p.getName());
                    wardrobeModels.forEach(wardrobeModel -> {
                        System.out.println("Przetwarzam model szafy: " + wardrobeModel);
                        ItemStack item = wardrobeModel.getItemStack().clone(); // Klonuj ItemStack, aby uniknąć zmiany oryginalnego modelu
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(wardrobeModel.getName()); // Ustaw nazwę wyświetlaną na wartość z pliku konfiguracyjnego
                        item.setItemMeta(meta);
                        e.getInventory().setItem(wardrobeModel.getSlotInEq(), item);
                    });
                })
                .addEventInventoryClick((p, e) -> {
                    //System.out.println("Wywołano zdarzenie kliknięcia w ekwipunek dla gracza: " + p.getName());
                    if (e.getClickedInventory() == null || e.getCurrentItem() == null) return;
                    e.setCancelled(true); // Anuluj zdarzenie, aby zapobiec wyciągnięciu przedmiotu
                    if (e.getClickedInventory().getType() != InventoryType.CHEST || e.getCurrentItem().getType() == Material.BLACK_STAINED_GLASS_PANE) return; // Dodano sprawdzenie, czy kliknięty przedmiot znajduje się w GUI i czy nie jest czarnym szkłem
                    if (e.getCurrentItem().isSimilar(FILL_BLACK)) return; // Dodano sprawdzenie, czy kliknięty przedmiot to czarne szkło

                    ItemStack clickedItem = e.getCurrentItem();

                    // Wywołaj metodę handlePlayerInteraction
                    //System.out.println("Kliknięto przedmiot: " + clickedItem);
                    handlePlayerInteraction(p, clickedItem);
                })
                .build();
    }


    private void handlePlayerInteraction(Player player, ItemStack clickedItem) {
    }
}
