package com.jakub.wardrobe;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class WardrobeModel {


    private Wardrobe myPluginInstance;
    private ItemStack itemStack;
    private int slotInEq;
    private int maxInEq;
    private List<String> bonuses;
    private String name;
    private List<String> lore; // Dodane pole lore


    public WardrobeModel() {
        this.myPluginInstance = Wardrobe.getInstance(); // Pobierz instancję twojego pluginu
    }
    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public int getSlotInEq() {
        return slotInEq;
    }

    public void setSlotInEq(int slotInEq) {
        this.slotInEq = slotInEq;
    }

    public int getMaxInEq() {
        //System.out.println("Odczytano MaxInEq: " + maxInEq); // Dodano log
        return maxInEq;
    }

    public void setMaxInEq(int maxInEq) {
        //System.out.println("Próba ustawienia MaxInEq na: " + maxInEq); // Dodano log
        this.maxInEq = maxInEq;
        //System.out.println("Ustawiono MaxInEq na: " + this.maxInEq); // Dodano log
    }

    public ItemStack getPlayerItem(Player player) {
        //System.out.println("Wywołano metodę getPlayerItem dla gracza: " + player.getName());
        ItemStack itemStack1 = this.itemStack.clone();
        return itemStack1;
    }

    public String getName() {
        return name; // Zwraca wartość pola name
    }

    public void setName(String name) {
        this.name = name; // Ustawia wartość pola name
    }


    public List<String> getLore() {
        return lore; // Zwraca wartość pola lore
    }

    public void setLore(List<String> lore) {
        this.lore = lore; // Ustawia wartość pola lore
    }
}
