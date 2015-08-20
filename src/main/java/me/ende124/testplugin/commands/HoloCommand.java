package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HoloCommand extends ServerPluginCommand {

	public HoloCommand(ServerPlugin instance) {
		super(instance);
	}

	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			p.sendMessage(getChatColorError() + "Please specify some text");
			
		} else {

			StringBuilder text = new StringBuilder();
			for (int i = 0; i < args.length; i++) {
				text.append(args[i] + " ");
			}

			Location ploc = p.getLocation();

			Location location = new Location(p.getLocation().getWorld(), ploc.getX(), ploc.getY(), ploc.getZ());

			ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

			as.setGravity(false);
			as.setCanPickupItems(false);
			as.setCustomName(text.toString());
			as.setCustomNameVisible(true);
			as.setVisible(false);
		}

		return true;
	}
}
