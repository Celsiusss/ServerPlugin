package me.ende124.testplugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getClickedBlock().getType() == Material.SIGN_POST
				|| event.getClickedBlock().getType() == Material.WALL_SIGN) {
			

		}
	}
}
