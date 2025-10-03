package net.jbl33.tradableclaimblocks.commands;

import net.jbl33.tradableclaimblocks.TradableClaimBlocks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DeveloperInfoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GREEN + "TradableClaimBlocks " + ChatColor.GRAY + "(V" + TradableClaimBlocks.version + ")");
        sender.sendMessage(ChatColor.GREEN + "Created by jbl33 - https://github.com/jbl33/");
        sender.sendMessage(ChatColor.RED + "Are you looking for an experienced server developer? Add jbl_33 on Discord for more information.");
        return false;
    }
}
