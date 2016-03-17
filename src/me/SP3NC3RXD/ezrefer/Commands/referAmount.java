package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by Spencer on 3/11/2016.
 */
public class referAmount {
    Main plugin;

    public referAmount(Main passedPlugin) {
        this.plugin = passedPlugin;
    }
    public void actionAmount(final Player p, String[] args) {

        targetconfirmedamount = Bukkit.getPlayer(args[0]);
        referAmountTarget = referdatabase.getString(targetconfirmedamount.getUniqueId().toString());
        if (args.length == 0) {
            if (!referdatabase.contains(p.getUniqueId().toString())) {
                sender.sendMessage(prefix + dgray + "You have never been referred before!");
                return true;
            }
            String referAmountSender = referdatabase.getString(p.getUniqueId().toString());
            sender.sendMessage(prefix + dgray + "You have " + gray + referAmountSender + dgray + " referrals.");
            return true;
        } else {
            targetconfirmedamount = Bukkit.getPlayer(args[1]);
            Player targetamountnull = Bukkit.getPlayer(args[1]);
            referAmountTarget = referdatabase.getString(targetconfirmedamount.getUniqueId().toString());
            if (targetamountnull == null) {
                sender.sendMessage(prefix + ChatColor.RED + "Sorry, but we could not find the player specified.");
                return true;
            } else {
                if (!referdatabase.contains(targetconfirmedamount.getUniqueId().toString())) {
                    sender.sendMessage(prefix + dgray + "That player has never been referred before!");
                    return true;
                } else {
                    sender.sendMessage(prefix + gray + targetconfirmedamount.getName() + dgray + " has " + gray + referAmountTarget + dgray + " referrals.");
                    return true;
                }
            }
        }

        //end
    }

}
