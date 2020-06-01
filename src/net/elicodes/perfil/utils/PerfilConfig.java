package net.elicodes.perfil.utils;

import net.elicodes.perfil.Main;
import org.bukkit.ChatColor;

public class PerfilConfig {

    //Messages
    public String sempermissao;
    public String semconsole;
    public String jogadoroffline;
    public String reload;

    //Permissions
    public String permperfil;
    public String permadmin;

    public PerfilConfig(Main main) {
        PerfilConfig config = main.config;

        //Messages
        this.sempermissao = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Perfil.Options.Messages.sem_permissao"));
        this.semconsole = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Perfil.Options.Messages.sem_console"));
        this.jogadoroffline = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Perfil.Options.Messages.sem_console"));
        this.reload = ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Perfil.Options.Messages.reload"));

        //Permissions
        this.permperfil = main.getConfig().getString("Perfil.Options.Permissions.permissao_perfil");
        this.permadmin = main.getConfig().getString("Perfil.Options.Permissions.permissao_admin");
    }
}