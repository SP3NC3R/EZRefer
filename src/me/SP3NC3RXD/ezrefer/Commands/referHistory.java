package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Spencer on 3/11/2016.
 */
public class referHistory {
    Main plugin;

    public referHistory(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    public void actionHistory(final Player p, String[] args) {

        sender.sendMessage(plugin.prefix + plugin.dgray + "Please specify a player: " + plugin.gray + "/refer admin history <player>" + plugin.dgray + ".");
        return true;
    } else {
        if (args.length == 2) {
            targetconfirmed = Bukkit.getOfflinePlayer(args[2]);
            uuid = targetconfirmed.getUniqueId().toString();
            String referGetCount = referdatabase.getString(targetconfirmed.getUniqueId().toString());
            if (targetconfirmed == null) {
                sender.sendMessage(prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return true;
            } else {
                if (!this.referdatabase.getList(uuid + ".history").contains(targetconfirmed.getName())) {
                    sender.sendMessage(prefix + ChatColor.GRAY + targetconfirmed + ChatColor.RED + " has no history of referring anybody.");
                    return true;
                }
                ArrayList<String> historyfinal = (ArrayList<String>) this.referdatabase.getList(uuid + ".history");
                for (String h : historyfinal) {
                    sender.sendMessage(prefix + gray + historyfinal);
                    return true;
                    //see if their history is null
                }

            }
        }
    }

        //end
    }
}
