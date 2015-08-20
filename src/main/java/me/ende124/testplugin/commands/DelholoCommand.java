package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DelholoCommand extends ServerPluginCommand {
	
	ServerPlugin plugin;
	
	public DelholoCommand(ServerPlugin instance) {
		super(instance);
	}

	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {

		ItemStack helm = new ItemStack(Material.GOLD_HELMET, 1);
		ItemMeta helmM = helm.getItemMeta();
		helmM.setDisplayName(ChatColor.GOLD + "Right click holograms to remove");
		helmM.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
		helm.setItemMeta(helmM);
		helm.setDurability((short) 77);
		
		if (plugin.holodelmap.get(p) != null) {
			plugin.holodelmap.clear();

			if (p.getInventory().contains(helm)) {
				p.getInventory().remove(helm);
			}
			p.sendMessage(ChatColor.AQUA + "Turned off hologram deletion mode.");
		} else {
			plugin.holodelmap.put(p, true);
			
			p.getInventory().addItem(helm);
			p.sendMessage(ChatColor.GREEN + "Entered hologram delete mode. Re-run the command to turn it off.");
		}
		
		return true;
	}
}
