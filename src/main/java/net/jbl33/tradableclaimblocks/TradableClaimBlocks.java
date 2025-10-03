package net.jbl33.tradableclaimblocks;

import net.jbl33.tradableclaimblocks.commands.ClaimBlocksCommand;
import net.jbl33.tradableclaimblocks.commands.DeveloperInfoCommand;
import net.jbl33.tradableclaimblocks.commands.WithdrawClaimBlocks;
import net.jbl33.tradableclaimblocks.events.RedeemClaimBlocks;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Arrays;

public class TradableClaimBlocks extends JavaPlugin {

    public static double version = 1.0;

    @Override
    public void onEnable() {
        System.out.println("TradableClaimBlocks has been started");
        getCommand("tradableclaimblocks").setExecutor(new DeveloperInfoCommand());
        getCommand("withdrawclaimblocks").setExecutor(new WithdrawClaimBlocks());
        getCommand("claimblocks").setExecutor(new ClaimBlocksCommand());
        this.getServer().getPluginManager().registerEvents(new RedeemClaimBlocks(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("TradableClaimBlocks has been stopped");
    }

    public static ItemStack getBlockClaimNote(Player player, int claimBlocksAmount) {
        ItemStack note = new ItemStack(Material.PAPER, 1);
        ItemMeta noteMeta = note.getItemMeta();
        noteMeta.setDisplayName(ChatColor.GOLD + "Claim Blocks Voucher");
        noteMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Right-click to redeem",
                ChatColor.GRAY + "Grants " + ChatColor.GOLD + claimBlocksAmount + ChatColor.GRAY + " claim blocks!",
                ChatColor.GRAY + "Withdrawn by: " + ChatColor.BLUE + player.getName()));
        note.setItemMeta(noteMeta);
        return note;
    }

    public static boolean isInventoryFull(Player player) {
        PlayerInventory inventory = player.getInventory();
        for (ItemStack item : inventory.getStorageContents()) {
            if (item == null || item.getType() == Material.AIR) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasEmptySlot(Player p) {
        return !isInventoryFull(p);
    }
}
