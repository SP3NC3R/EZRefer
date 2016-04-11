package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Spencer on 3/11/2016.
 */
@SuppressWarnings("deprecation")
public class referHistory {
    Main plugin;

    public referHistory(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public void actionHistory(final Player p, String[] args, OfflinePlayer targetconfirmed)
    {
        if (!(args.length == 3))
        {
            p.sendMessage(plugin.prefix + plugin.dgray + "Please specify a player: "
                    + plugin.gray + "/refer admin history <player>" + plugin.dgray + ".");
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
                if (!plugin.referdatabase.getList(uuid + ".history").contains(targetconfirmed.getName()))
                {
                    p.sendMessage(plugin.prefix + plugin.gray + targetconfirmed + plugin.red + " has no referral history.");
                    return;
                }
                ArrayList<String> historyfinal = (ArrayList<String>) plugin.referdatabase.getList(uuid + ".history");

                for (String h : historyfinal)
                {
                    p.sendMessage(plugin.prefix + plugin.gray + historyfinal);
                    return;
                    //see if their history is null
                }

            }
        }
    }

        //end
    }
