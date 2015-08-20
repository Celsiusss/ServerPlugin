package me.ende124.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {

		Player p = event.getPlayer();
		
		if (ChatColor.stripColor(p.getItemInHand().getItemMeta().getDisplayName()).equals("Land Protector 9000")) {
			event.setCancelled(true);
			p.sendMessage(ChatColor.RED + "You cannot use this shovel to dig with.");
		}
	}
}
