package me.ende124.testplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class InventoryClickListener implements Listener {
	
	@EventHandler
	public void onPlayerClick(InventoryClickEvent e) {
		if (!e.getInventory().getName().equalsIgnoreCase("Colour Selector")) {
			return;
		}
		Player p = (Player)e.getWhoClicked();
		e.setCancelled(true);

		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR || !e.getCurrentItem().hasItemMeta()) {
			p.closeInventory();
			return;
		}

		LeatherArmorMeta lam = (LeatherArmorMeta)p.getItemInHand().getItemMeta();
		switch (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName())) {
			case "White":
				lam.setColor(Color.WHITE);
				p.closeInventory();
				break;
			case "Red":
				lam.setColor(Color.RED);
				p.closeInventory();
				break;
			case "Green":
				lam.setColor(Color.GREEN);
				p.closeInventory();
				break;
			case "Brown":
				lam.setColor(null);
				p.closeInventory();
				break;
			case "Blue":
				lam.setColor(Color.BLUE);
				p.closeInventory();
				break;
			case "Purple":
				lam.setColor(Color.PURPLE);
				p.closeInventory();
				break;
			case "Cyan":
				lam.setColor(Color.TEAL);
				p.closeInventory();
				break;
			case "Grey":
				lam.setColor(Color.GRAY);
				p.closeInventory();
				break;
			case "Pink":
				lam.setColor(Color.FUCHSIA);
				p.closeInventory();
				break;
			case "Yellow":
				lam.setColor(Color.YELLOW);
				p.closeInventory();
				break;
			case "Orange":
				lam.setColor(Color.ORANGE);
				p.closeInventory();
				break;
			case "Black":
				lam.setColor(Color.BLACK);
				p.closeInventory();
				break;
			default:
				p.closeInventory();
				break;
		}
		p.getItemInHand().setItemMeta(lam);
	}
}
