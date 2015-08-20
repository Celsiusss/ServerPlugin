package me.ende124.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		//Swear filter
		if(event.getMessage().contains("fuck")) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.DARK_RED + "Do not swear in chat!");
			event.getPlayer().sendMessage(ChatColor.GOLD + "If you try to bypass this system, you'll get a warning.");
			return;
		}
		
		//Custom chat format with ranks
		if (event.getPlayer().hasPermission("rank.owner")) {
			event.setFormat(ChatColor.DARK_RED + "[" + ChatColor.GOLD + "Owner" + ChatColor.DARK_RED + "] " + ChatColor.RESET + "%s: %s");
			return;
		}
		if (event.getPlayer().hasPermission("rank.admin")) {
			event.setFormat(ChatColor.YELLOW + "[Admin] " + ChatColor.RESET + "%s: %s");
			return;
		}
		if (event.getPlayer().hasPermission("rank.moderator")) {
			event.setFormat(ChatColor.BLUE + "[Mod] " + ChatColor.RESET + "%s: %s");
			return;
		} 
		if (event.getPlayer().hasPermission("rank.vip")) {
			event.setFormat(ChatColor.GREEN + "[VIP] " + ChatColor.RESET + "%s: %s");
			return;
		} else {
			event.setFormat("%s: %s");
		}
	}
}
