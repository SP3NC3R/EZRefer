package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

/**
 * Created by Spencer on 3/11/2016.
 */
@SuppressWarnings("deprecation")
public class referSubtract {
    Main plugin;

    public referSubtract(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    public void actionSubtract(final Player p, String[] args, OfflinePlayer targetconfirmed) {

        if (!(args.length == 3)) {
            p.sendMessage(plugin.prefix + plugin.dgray + "Please specify a player: "
                    + plugin.gray + "/refer admin subtract <player> <amount>" + plugin.dgray + ".");
            return;
        }
        if (!(args.length == 4)) {
            p.sendMessage(plugin.prefix + plugin.dgray + "Please specify the amount to add: "
                    + plugin.gray + "/refer admin subtract <player> <amount>" + plugin.dgray + ".");
            return;
        }
        if (!plugin.isInt(args[3])) {
            p.sendMessage(plugin.prefix + plugin.dgray + "Only numbers are allowed: "
                    + plugin.gray + "/refer admin subtract <player> <amount>" + plugin.dgray + ".");
            return;

    } else {
            targetconfirmed = Bukkit.getOfflinePlayer(args[2]);
            String uuid = targetconfirmed.getUniqueId().toString();
            //String referGetCount = plugin.referdatabase.getString(targetconfirmed.getUniqueId().toString());

            if (targetconfirmed == null)
            {
                p.sendMessage(plugin.prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return;
            } else {
                plugin.referdatabase.set(uuid + ".referCount", plugin.referdatabase.getInt(uuid + ".referCount") - Integer.valueOf(args[3]));
                plugin.referdatabase.saveConfig();
                p.sendMessage(plugin.prefix + plugin.gray + args[3] + plugin.dgray + " refer count(s) has been added to "
                        + plugin.gray + targetconfirmed.getName() + plugin.dgray + "'s account.");
                return;
            }
        }
    }
}
