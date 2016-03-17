package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Spencer on 3/11/2016.
 */
public class referReset {
    Main plugin;

    public referReset(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public void actionReset(final Player p, String[] args) {

        sender.sendMessage(prefix + dgray + "Please specify a player: " + gray + "/refer admin reset <player>" + dgray + ".");
        return true;
    } else {
        if (args.length == 1) {
            targetconfirmed = Bukkit.getOfflinePlayer(args[2]);
            uuid = targetconfirmed.getUniqueId().toString();
            String referGetCount = referdatabase.getString(targetconfirmed.getUniqueId().toString());
            if (targetconfirmed == null) {
                sender.sendMessage(prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return true;
            } else {
                referdatabase.set(uuid + ".referCount", 0);
                return true;
            }
        }

        //end
    }
}
