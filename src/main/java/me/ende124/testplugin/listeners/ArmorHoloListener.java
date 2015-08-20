package me.ende124.testplugin.listeners;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class ArmorHoloListener implements Listener {

	ServerPlugin plugin;

	@EventHandler
	public void manipulate(PlayerArmorStandManipulateEvent e) {
		if(!e.getRightClicked().isVisible()) {

			if (plugin.holodelmap.get(e.getPlayer()) != null) {
				e.getRightClicked().remove();
				e.getPlayer().sendMessage(ChatColor.GREEN + "Hologram deleted");
			}
			e.setCancelled(true);
		}
	}
}
