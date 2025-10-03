package net.jbl33.tradableclaimblocks.commands;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import net.jbl33.tradableclaimblocks.TradableClaimBlocks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WithdrawClaimBlocks implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Proper usage: /withdrawclaimblocks (number)");
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int numberOfClaimBlocks;
                try {
                    numberOfClaimBlocks = Integer.parseInt(args[0]);
                    if(numberOfClaimBlocks > 0) {
                        int playerClaimBlocks = GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId()).getAccruedClaimBlocks();
                        if (playerClaimBlocks >= numberOfClaimBlocks) {
                            if (TradableClaimBlocks.hasEmptySlot(player)) {
                                ItemStack claimNote = TradableClaimBlocks.getBlockClaimNote(player, numberOfClaimBlocks);
                                int newClaimBlocks = playerClaimBlocks - numberOfClaimBlocks;
                                // Setting the player's new claim blocks
                                GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId()).setAccruedClaimBlocks(newClaimBlocks);
                                player.getInventory().addItem(claimNote);
                                player.sendMessage(ChatColor.GREEN + "You have successfully withdrawn " + ChatColor.GOLD + numberOfClaimBlocks +
                                        ChatColor.GREEN + " claim block(s)!");
                            } else {
                                player.sendMessage(ChatColor.RED + "You cannot withdraw claim blocks as your inventory is full!");
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + "You don't have enough claim blocks to withdraw " + numberOfClaimBlocks + " blocks!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Amount must be greater than 0");
                    }
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "Error converting the number of claim blocks to an Integer");
                }
            } else {
                sender.sendMessage("You cannot run this command from console!");
            }
        }
        return false;
    }
}
