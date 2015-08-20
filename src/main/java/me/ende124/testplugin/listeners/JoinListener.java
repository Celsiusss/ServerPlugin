package me.ende124.testplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		ItemStack helm = new ItemStack(Material.GOLD_HELMET, 1);
		ItemMeta helmM = helm.getItemMeta();
		helmM.setDisplayName(ChatColor.GOLD + "Right click holograms to remove");
		helmM.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
		helm.setItemMeta(helmM);
		helm.setDurability((short) 77);

		if (p.getInventory().contains(helm)) {
			p.getInventory().remove(helm);
		}
		
		if (p.hasPlayedBefore()) {
			p.sendMessage(ChatColor.GOLD + "Welcome back " + ChatColor.RESET + p.getDisplayName() + ChatColor.GOLD + "!");
			p.sendMessage(ChatColor.GOLD + "Enjoy your stay!");
		} else {
			p.sendMessage(ChatColor.GOLD + "Welcome to the server " + ChatColor.RESET + p.getDisplayName() + ChatColor.GOLD + "!");
			p.sendMessage(ChatColor.GOLD + "Enjoy your stay!");
			Bukkit.broadcastMessage(p.getDisplayName() + ChatColor.AQUA + " has joined the server for the first time!");
			Bukkit.broadcastMessage(ChatColor.AQUA + "Wish him welcome :)");
		}
		e.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.RESET + p.getDisplayName());
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {

		e.setQuitMessage(ChatColor.RED + "- " + ChatColor.RESET + e.getPlayer().getDisplayName());
	}
}
