package net.elicodes.perfil.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.elicodes.perfil.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    FileConfiguration config = Main.getPlugin().getConfig();

    public Inventory openPerfil(Player p){
        String na = ChatColor.translateAlternateColorCodes('&', config.getString("Perfil.Inventory.NomeInv"));
        String name = PlaceholderAPI.setPlaceholders(p, na);
        int slots = config.getInt("Perfil.Inventory.Tamanho");
        Inventory inv = Bukkit.createInventory(null, slots, name);
        for(String item : config.getConfigurationSection("Perfil.Inventory.Items").getKeys(false)){
            int id = config.getInt("Perfil.Inventory.Items." + item + ".id");
            short data = (short)config.getInt("Perfil.Inventory.Items." + item + ".data");
            int amount = config.getInt("Perfil.Inventory.Items." + item + ".quantidade");
            int slot = config.getInt("Perfil.Inventory.Items." + item + ".slot");
            String n = ChatColor.translateAlternateColorCodes('&', config.getString("Perfil.Inventory.Items." + item + ".nome"));
            String nome = PlaceholderAPI.setPlaceholders(p, n);
            if(config.getBoolean("Perfil.Inventory.Items." + item + ".cabeca") == true){
                ItemStack items = new ItemStack(397, amount, (short)3);
                SkullMeta meta = (SkullMeta) items.getItemMeta();
                meta.setOwner(p.getName());
                ArrayList<String> lore = new ArrayList<>();
                List<String> newLore = new ArrayList<>();
                lore.addAll(Main.getPlugin().getConfig().getStringList("Perfil.Inventory.Items." + item + ".lore"));
                for(String b : lore) {
                    newLore.add(ChatColor.translateAlternateColorCodes('&', b));
                }
                List<String> desc = PlaceholderAPI.setPlaceholders(p, newLore);
                meta.setLore(desc);
                meta.setDisplayName(nome);
                items.setItemMeta(meta);
                inv.setItem(slot, items);
            }else {
                ItemStack items = new ItemStack(id, amount, (short)data);
                ItemMeta meta = items.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                List<String> newLore = new ArrayList<>();
                lore.addAll(Main.getPlugin().getConfig().getStringList("Perfil.Inventory.Items." + item + ".lore"));
                for(String b : lore) {
                    newLore.add(ChatColor.translateAlternateColorCodes('&', b));
                }
                List<String> desc = PlaceholderAPI.setPlaceholders(p, newLore);
                meta.setLore(desc);
                meta.setDisplayName(nome);
                items.setItemMeta(meta);
                inv.setItem(slot, items);
            }
            p.openInventory(inv);
        }
        return inv;
    }

    public Inventory openPerfilOther(Player p, Player t) {
        String na = ChatColor.translateAlternateColorCodes('&', config.getString("Perfil.Inventory.NomeInv"));
        String name = PlaceholderAPI.setPlaceholders(t, na);
        int slots = config.getInt("Perfil.Inventory.Tamanho");
        Inventory inv = Bukkit.createInventory(null, slots, name);
        for (String item : config.getConfigurationSection("Perfil.Inventory.Items").getKeys(false)) {
            int id = config.getInt("Perfil.Inventory.Items." + item + ".id");
            short data = (short) config.getInt("Perfil.Inventory.Items." + item + ".data");
            int amount = config.getInt("Perfil.Inventory.Items." + item + ".quantidade");
            int slot = config.getInt("Perfil.Inventory.Items." + item + ".slot");
            String n = ChatColor.translateAlternateColorCodes('&', config.getString("Perfil.Inventory.Items." + item + ".nome"));
            String nome = PlaceholderAPI.setPlaceholders(t, n);
            if (config.getBoolean("Perfil.Inventory.Items." + item + ".cabeca") == true) {
                ItemStack items = new ItemStack(397, amount, (short) 3);
                SkullMeta meta = (SkullMeta) items.getItemMeta();
                meta.setOwner(p.getName());
                ArrayList<String> lore = new ArrayList<>();
                List<String> newLore = new ArrayList<>();
                lore.addAll(Main.getPlugin().getConfig().getStringList("Perfil.Inventory.Items." + item + ".lore"));
                for (String b : lore) {
                    newLore.add(ChatColor.translateAlternateColorCodes('&', b));
                }
                List<String> desc = PlaceholderAPI.setPlaceholders(t, newLore);
                meta.setLore(desc);
                meta.setDisplayName(nome);
                items.setItemMeta(meta);
                inv.setItem(slot, items);
            }else{
                ItemStack items = new ItemStack(id, amount, (short) data);
                ItemMeta meta = items.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                List<String> newLore = new ArrayList<>();
                lore.addAll(Main.getPlugin().getConfig().getStringList("Perfil.Inventory.Items." + item + ".lore"));
                for (String b : lore) {
                    newLore.add(ChatColor.translateAlternateColorCodes('&', b));
                }
                List<String> desc = PlaceholderAPI.setPlaceholders(t, newLore);
                meta.setLore(desc);
                meta.setDisplayName(nome);
                items.setItemMeta(meta);
                inv.setItem(slot, items);
            }
            p.openInventory(inv);
        }
        return inv;
    }
}
