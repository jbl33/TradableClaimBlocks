package net.jbl33.tradableclaimblocks.events;

import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class RedeemClaimBlocks implements Listener {


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = e.getPlayer();
            if (e.getItem().getType() == Material.PAPER) {
                if (e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasLore()) {
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Claim Blocks Voucher")) {
                        ItemMeta meta = e.getItem().getItemMeta();
                        if (meta.getLore().size() == 3) {
                            List<String> lores = meta.getLore();
                            if (lores.get(0).contains(ChatColor.GRAY + "Right-click to redeem")) {
                                String lineWithCounter = ChatColor.stripColor(lores.get(1));
                                String[] split = lineWithCounter.split(" ");
                                try {
                                    int blocks = Integer.parseInt(split[1]);

                                    // Remove only one item from the stack
                                    ItemStack item = e.getItem();
                                    if (item.getAmount() > 1) {
                                        item.setAmount(item.getAmount() - 1);
                                    } else {
                                        player.getInventory().remove(item);
                                    }

                                    int currentBlockCount = GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId()).getAccruedClaimBlocks();
                                    GriefPrevention.instance.dataStore.getPlayerData(player.getUniqueId()).setAccruedClaimBlocks(currentBlockCount + blocks);
                                    player.sendMessage(ChatColor.GREEN + "You have successfully redeemed a claim block voucher worth " + ChatColor.GOLD + ""
                                            + blocks + ChatColor.GREEN + " blocks!");
                                } catch (Exception ex) {
                                    System.out.println("Error converting string to integer");
                                }
                            }
                        }
                    } else {
                        player.sendMessage(e.getItem().getItemMeta().getDisplayName());
                    }
                }
            }
        }
    }


}