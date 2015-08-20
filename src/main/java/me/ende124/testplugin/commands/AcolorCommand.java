package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

public class AcolorCommand extends ServerPluginCommand implements Listener {

	public AcolorCommand(ServerPlugin instance) {
		super(instance);
	}

	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (p.getItemInHand().getType() == Material.LEATHER_HELMET
				|| p.getItemInHand().getType() == Material.LEATHER_CHESTPLATE
				|| p.getItemInHand().getType() == Material.LEATHER_LEGGINGS
				|| p.getItemInHand().getType() == Material.LEATHER_BOOTS) {
			
			if (args.length == 0) {
				openAColorGUI(p);
				return true;
			}
			
			if (args[0].equalsIgnoreCase("rgb") && args.length > 3) {

				try {
					int r = Integer.parseInt(args[1]);
					int g = Integer.parseInt(args[2]);
					int b = Integer.parseInt(args[3]);
					
					if (r > 255 || g > 255 || b > 355) {
						p.sendMessage(getChatColorError() + "Invalid RGB format");
						return true;
					}
					
					LeatherArmorMeta lam = (LeatherArmorMeta) p.getItemInHand().getItemMeta();
					lam.setColor(Color.fromRGB(r, g, b));
					p.getItemInHand().setItemMeta(lam);
					
				} catch(Exception e) {
					p.sendMessage(getChatColorError() + "Invalid RGB format");
					return true;
				}
				return true;
			}
			if (args[0].equalsIgnoreCase("rgb")) {
				p.sendMessage(getChatColorError() + "Usage: " + getChatColorCommand() + "/acolor rgb <r> <g> <b>");
				return true;
			}

		} else p.sendMessage(getChatColorError() + "You need to hold a piece of leather armor.");
		
		
	return true;
}

	private void openAColorGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 18, "Colour Selector");

		ItemStack white = new ItemStack(Material.INK_SACK, 1, (short) 15);
		ItemMeta whiteM = white.getItemMeta();
		whiteM.setDisplayName(ChatColor.WHITE + "White");
		white.setItemMeta(whiteM);

		ItemStack red = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta redM = red.getItemMeta();
		redM.setDisplayName(ChatColor.RED + "Red");
		red.setItemMeta(redM);

		ItemStack green = new ItemStack(Material.INK_SACK, 1, (short) 2);
		ItemMeta greenM = green.getItemMeta();
		greenM.setDisplayName(ChatColor.GREEN + "Green");
		green.setItemMeta(greenM);

		ItemStack brown = new ItemStack(Material.INK_SACK, 1, (short) 3);
		ItemMeta brownM = brown.getItemMeta();
		brownM.setDisplayName(ChatColor.GOLD + "Brown");
		brown.setItemMeta(brownM);

		ItemStack blue = new ItemStack(Material.INK_SACK, 1, (short) 4);
		ItemMeta blueM = blue.getItemMeta();
		blueM.setDisplayName(ChatColor.BLUE + "Blue");
		blue.setItemMeta(blueM);

		ItemStack purple = new ItemStack(Material.INK_SACK, 1, (short) 5);
		ItemMeta purpleM = purple.getItemMeta();
		purpleM.setDisplayName(ChatColor.DARK_PURPLE + "Purple");
		purple.setItemMeta(purpleM);

		ItemStack cyan = new ItemStack(Material.INK_SACK, 1, (short) 6);
		ItemMeta cyanM = cyan.getItemMeta();
		cyanM.setDisplayName(ChatColor.AQUA + "Cyan");
		cyan.setItemMeta(cyanM);

		ItemStack gray = new ItemStack(Material.INK_SACK, 1, (short) 8);
		ItemMeta grayM = gray.getItemMeta();
		grayM.setDisplayName(ChatColor.GRAY + "Gray");
		gray.setItemMeta(grayM);

		ItemStack pink = new ItemStack(Material.INK_SACK, 1, (short) 9);
		ItemMeta pinkM = pink.getItemMeta();
		pinkM.setDisplayName(ChatColor.LIGHT_PURPLE + "Pink");
		pink.setItemMeta(pinkM);

		ItemStack yellow = new ItemStack(Material.INK_SACK, 1, (short) 11);
		ItemMeta yellowM = yellow.getItemMeta();
		yellowM.setDisplayName(ChatColor.YELLOW + "Yellow");
		yellow.setItemMeta(yellowM);

		ItemStack orange = new ItemStack(Material.INK_SACK, 1, (short) 14);
		ItemMeta orangeM = orange.getItemMeta();
		orangeM.setDisplayName(ChatColor.GOLD + "Orange");
		orange.setItemMeta(orangeM);

		ItemStack black = new ItemStack(Material.INK_SACK, 1, (short) 0);
		ItemMeta blackM = black.getItemMeta();
		blackM.setDisplayName(ChatColor.BLACK + "Black");
		black.setItemMeta(blackM);

		ItemStack custom = new ItemStack(Material.BARRIER);
		ItemMeta customM = custom.getItemMeta();
		customM.setDisplayName(ChatColor.GOLD + "Want to customize even more?");
		customM.setLore(Arrays.asList(
				ChatColor.GRAY + "Its super simple!", 
				ChatColor.GRAY + "Just use this command:", 
				getChatColorCommand() + "/acolor rgb <r> <g> <b>"));
		custom.setItemMeta(customM);

		inv.setItem(0, white);
		inv.setItem(1, red);
		inv.setItem(2, green);
		inv.setItem(3, brown);
		inv.setItem(4, blue);
		inv.setItem(5, purple);
		inv.setItem(6, cyan);
		inv.setItem(7, gray);
		inv.setItem(8, pink);
		inv.setItem(9, yellow);
		inv.setItem(10, orange);
		inv.setItem(11, black);
		inv.setItem(17, custom);
		
		p.openInventory(inv);
	}
}
