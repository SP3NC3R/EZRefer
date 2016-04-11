package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Spencer on 3/11/2016.
 */
@SuppressWarnings("deprecation")
public class referAmount {
    Main plugin;

    public referAmount(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    public void actionAmount(final Player p, String[] args) {

        if (args.length == 0)
        {
            if (!plugin.referdatabase.contains(p.getUniqueId().toString()))
            {
                p.sendMessage(plugin.prefix + plugin.dgray + "You have never been referred before!");
                return;
            }

            String referAmountSender = plugin.referdatabase.getString(p.getUniqueId().toString());
            p.sendMessage(plugin.prefix + plugin.dgray + "You have " + plugin.gray + referAmountSender + plugin.dgray + " referrals.");
            return;
        } else {

            Player targetconfirmedamount = Bukkit.getPlayer(args[0]);
            Player targetamountnull = Bukkit.getPlayer(args[0]);
            String referAmountTarget = plugin.referdatabase.getString(targetconfirmedamount.getUniqueId().toString());

            if (targetamountnull == null)
            {
                p.sendMessage(plugin.prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return;
            } else {
                if (!plugin.referdatabase.contains(targetconfirmedamount.getUniqueId().toString()))
                {
                    p.sendMessage(plugin.prefix + plugin.dgray + "That player has never been referred before!");
                    return;
                } else {
                    p.sendMessage(plugin.prefix + plugin.gray + targetconfirmedamount.getName()
                            + plugin.dgray + " has " + plugin.gray + referAmountTarget + plugin.dgray + " referrals.");
                    return;
                }
            }
        }

        //end
    }

}
