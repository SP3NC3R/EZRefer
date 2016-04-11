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
public class referReset {
    Main plugin;

    public referReset(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public void actionReset(final Player p, String[] args, OfflinePlayer targetconfirmed) {

        if (!(args.length == 3))
        {
            p.sendMessage(plugin.prefix + plugin.dgray + "Please specify a player: "
                    + plugin.gray + "/refer admin reset <player>" + plugin.dgray + ".");
            return;
        } else {

            targetconfirmed = Bukkit.getOfflinePlayer(args[2]);
            String uuid = targetconfirmed.getUniqueId().toString();
            String referGetCount = plugin.referdatabase.getString(targetconfirmed.getUniqueId().toString());

            if (targetconfirmed == null)
            {
                p.sendMessage(plugin.prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return;
            } else {
                plugin.referdatabase.set(uuid + ".referCount", 0);
                return;
            }
        }
    }
}
