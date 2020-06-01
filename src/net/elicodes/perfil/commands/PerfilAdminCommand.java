package net.elicodes.perfil.commands;

import net.elicodes.perfil.Main;
import net.elicodes.perfil.utils.PerfilConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PerfilAdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String lb, String[] a) {
        if(cmd.getName().equalsIgnoreCase("perfiladmin")){
            PerfilConfig config = Main.getPlugin().config;
            if(!s.hasPermission(config.permadmin)){
                s.sendMessage(config.sempermissao);
                return true;
            }
            if(a.length == 0){
                s.sendMessage(ChatColor.YELLOW+"Utilize: /perfiladmin <reload>");
                return true;
            }
            if(a[0].equalsIgnoreCase("reload")){
                Main.getPlugin().reloadConfig();
                s.sendMessage(config.reload);
            }else{
                s.sendMessage(ChatColor.YELLOW+"Utilize: /perfiladmin <reload>");
            }
        }
        return false;
    }
}