package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Spencer on 3/11/2016.
 */
public class referAdd {
    Main plugin;

    public referAdd(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public void actionAdd(final Player p, String[] args) {

        p.sendMessage(plugin.prefix + plugin.dgray + "Please specify a player: " + plugin.gray + "/refer admin add <player>" + plugin.dgray + ".");
        return;

    }
    else
    {
        if (args.length == 2)
        {
            plugin.targetconfirmed = Bukkit.getOfflinePlayer(args[2]);
            uuid = targetconfirmed.getUniqueId().toString();
            String referGetCount = referdatabase.getString(targetconfirmed.getUniqueId().toString());
            if (targetconfirmed == null)
            {
                sender.sendMessage(prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return;
            }
            else
            {
                referdatabase.set(uuid + ".referCount", referdatabase.getInt(uuid + ".referCount") + args[3]);
                referdatabase.saveConfig();
                sender.sendMessage(prefix + gray + args[3] + dgray + " refer count(s) has been added to " + gray + targetconfirmed.getName() + dgray + "'s account.");
                return;
            }
        }
    }
}
