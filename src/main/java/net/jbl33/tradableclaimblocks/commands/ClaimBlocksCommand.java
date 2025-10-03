package net.jbl33.tradableclaimblocks.commands;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClaimBlocksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            int claimBlocks = GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId()).getAccruedClaimBlocks();
            player.sendMessage(ChatColor.GRAY + "You currently have " + ChatColor.GOLD + claimBlocks + ChatColor.GRAY + " claim blocks.");
        } else {
            sender.sendMessage(ChatColor.RED + "This command cannot be run from console");
        }
        return false;
    }
}
