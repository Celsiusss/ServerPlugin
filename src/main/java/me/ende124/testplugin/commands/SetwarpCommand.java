package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import me.ende124.testplugin.config.MyConfig;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class SetwarpCommand extends ServerPluginCommand {
	public SetwarpCommand(ServerPlugin instance) {
		super(instance);
	}

	MyConfig warps = ServerPlugin.warps;

	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			p.sendMessage(getChatColorError() + "Please specify a warp name!");
			return true;
		}

		warps.set("warps." + args[0] + ".x", p.getLocation().getX());
		warps.set("warps." + args[0] + ".y", p.getLocation().getY());
		warps.set("warps." + args[0] + ".z", p.getLocation().getZ());
		warps.set("warps." + args[0] + ".pitch", p.getLocation().getPitch());
		warps.set("warps." + args[0] + ".yaw", p.getLocation().getYaw());
		warps.set("warps." + args[0] + ".world", p.getLocation().getWorld().getName());
		warps.saveConfig();
		
		p.sendMessage(getChatColorDefault() + "Warp " + getChatColorName() + args[0] + getChatColorDefault() + " set!");

		return true;
	}
}
