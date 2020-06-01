package net.elicodes.perfil.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import net.elicodes.perfil.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PerfilListeners implements Listener {

    @EventHandler
    public void aoClicar(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        String nomeinv = Main.getPlugin().getConfig().getString("Perfil.Inventory.NomeInv");
        String inv = PlaceholderAPI.setPlaceholders(p, nomeinv);
        if(e.getView().getTitle().contains(ChatColor.translateAlternateColorCodes('&', inv))) {
            e.setCancelled(true);
        }
    }
}
