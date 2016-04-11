package me.SP3NC3RXD.ezrefer.Commands;

import me.SP3NC3RXD.ezrefer.Main;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Spencer on 3/11/2016.
 */
public class referTop {
    Main plugin;

    public referTop(Main passedPlugin) {
        this.plugin = passedPlugin;
    }

    public void actionTop(final Player p) {

        //Get a list of the top 10 players on the server with the most referrals.
        HashMap<String, Integer> topReferrals = new HashMap<String, Integer>();

        for (String s : plugin.referdatabase.getConfigurationSection("refer").getKeys(false)) {
            OfflinePlayer op = Bukkit.getOfflinePlayer(UUID.fromString(s));
            topReferrals.put(op.getName(), plugin.getConfig().getInt(s + ".<refer count>"));
        }

        plugin.top10(topReferrals, p);

        return;
        //end
    }
}
