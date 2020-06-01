package net.elicodes.perfil.commands;

import net.elicodes.perfil.Main;
import net.elicodes.perfil.utils.Methods;
import net.elicodes.perfil.utils.PerfilConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PerfilCommand extends Methods implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String lb, String[] a) {
        if(cmd.getName().equalsIgnoreCase("perfil")){
            PerfilConfig config = Main.getPlugin().config;
            if(!(s instanceof Player)){
                s.sendMessage(config.semconsole);
                return true;
            }
            Player p = (Player)s;
            if(!p.hasPermission(config.permperfil)){
                p.sendMessage(config.sempermissao);
                return true;
            }
            if(a.length == 0){
                openPerfil(p);
                return true;
            }
            if(a.length == 1){
                Player t = Bukkit.getPlayerExact(a[0]);
                if(t == null){
                    p.sendMessage(config.jogadoroffline);
                    return true;
                }
                openPerfilOther(p, t);
                return true;
            }
        }
        return false;
    }
}
