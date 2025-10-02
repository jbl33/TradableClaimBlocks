package net.jbl33.tradableclaimblocks;

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

    @Override
    public void onEnable() {
        System.out.println("TradableClaimBlocks has been started");
        getCommand("withdrawclaimblocks").setExecutor(new WithdrawClaimBlocks());
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
                ChatColor.GRAY + "Redeemed by: " + ChatColor.BLUE + player.getName()));
        note.setItemMeta(noteMeta);
        return note;
    }

    public static boolean isInventoryFull(Player player) {
        // Get the player's inventory instance
        PlayerInventory inventory = player.getInventory();

        // getStorageContents() returns only the 36 main storage slots (hotbar + main area),
        // which is what is usually meant by a "full inventory."
        for (ItemStack item : inventory.getStorageContents()) {

            // Check for two conditions that indicate an empty slot:
            // 1. The slot is null (the most common check for an empty slot).
            // 2. The slot contains an ItemStack of Material.AIR (used sometimes when clearing slots).
            if (item == null || item.getType() == Material.AIR) {
                // We found an empty slot, so the inventory is not full.
                return false;
            }
        }

        // If the loop completes without returning false, every slot must be occupied.
        return true;
    }

    /**
     * Checks if a player's main inventory (36 storage slots) has at least one empty slot.
     * This is the inverse of isInventoryFull(Player).
     *
     * @param player The player whose inventory is to be checked.
     * @return true if there is at least one empty storage slot, false otherwise.
     */
    public static boolean hasEmptySlot(Player player) {
        return !isInventoryFull(player);
    }
}
