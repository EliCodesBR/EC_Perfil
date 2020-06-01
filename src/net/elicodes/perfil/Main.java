package net.elicodes.perfil;

import net.elicodes.perfil.commands.PerfilAdminCommand;
import net.elicodes.perfil.commands.PerfilCommand;
import net.elicodes.perfil.listeners.PerfilListeners;
import net.elicodes.perfil.utils.PerfilConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public PerfilConfig config;
    private static Main plugin;

    @Override
    public void onEnable() {
        setPlugin(this);
        saveDefaultConfig();
        getConfig().addDefault("file-version", 1.1);
        saveConfig();
        if(!Bukkit.getPluginManager().isPluginEnabled("EC_Perfil")){
            getLogger().info(ChatColor.YELLOW+"Não altere a plugin.yml! Desabilitando plugin...");
            return;
        }
        if(!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            getLogger().info(ChatColor.YELLOW+"PlaceholderAPI não encontrado! Desabilitando plugin...");
            return;
        }
        getCommand("perfiladmin").setExecutor(new PerfilAdminCommand());
        getCommand("perfil").setExecutor(new PerfilCommand());
        Bukkit.getPluginManager().registerEvents(new PerfilListeners(), this);
        register();
        getLogger().info(ChatColor.GREEN+"[EC_Perfil] Plugin habilitado.");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED+"[EC_Perfil] Plugin desabilitado.");
        super.onDisable();
    }

    private void register(){
        Bukkit.getConsoleSender().sendMessage("§2[EC_Perfil] §fClass (PerfilAdminCommand) loaded.");
        Bukkit.getConsoleSender().sendMessage("§2[EC_Perfil] §fClass (PerfilCommand) loaded.");
        Bukkit.getConsoleSender().sendMessage("§2[EC_Perfil] §fClass (PerfilListeners) loaded.");
        config =  new PerfilConfig(this); //tenta
    }
    private void setPlugin(Main main){
        plugin = main;
    }

    public static Main getPlugin(){
        return plugin;
    }
}
