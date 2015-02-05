package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KitCommand extends ServerPluginCommand {
	public KitCommand(ServerPlugin instance) {
		super(instance);
	}

	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			p.sendMessage(getChatColorError() + "Please specify a kit.");
			return true;
		}

		if (args[0].equalsIgnoreCase("protect")) {
			ItemStack protect = new ItemStack(Material.GOLD_SPADE);
			ItemMeta protectM = protect.getItemMeta();
			
			protectM.setDisplayName(ChatColor.GOLD + "Land Protector 9000");
			protectM.setLore(Arrays.asList("Use this tool when you want to", "expand your protected land or", "create a new one!"));

			
			protect.setItemMeta(protectM);
			p.getInventory().addItem(protect);
			
			return true;
		}
		p.sendMessage(getChatColorError() + "Invalid kit name!");
		return true;
	}
}
