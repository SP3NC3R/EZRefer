package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Spencer on 3/11/2016.
 */
public class referSubtract {
    Main plugin;

    public referSubtract(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    public void actionSubtract(final Player p, String[] args) {

        sender.sendMessage(prefix + dgray + "Please specify a player: " + gray + "/refer admin subtract <player>" + dgray + ".");
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
                referdatabase.set(uuid + ".referCount", referdatabase.getInt(uuid + ".referCount") - Integer.valueOf(args[3]));
                return true;
            }
        }
        //end
    }
}
