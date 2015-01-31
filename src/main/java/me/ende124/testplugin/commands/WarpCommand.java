package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import me.ende124.testplugin.config.MyConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class WarpCommand extends ServerPluginCommand {
	public WarpCommand(ServerPlugin instance) {
		super(instance);
	}

	MyConfig warps = ServerPlugin.warps;
	
	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (args.length > 0) {
			p.sendMessage(getChatColorError() + "Please specify a warp name!");
			return true;
		}
		World w = Bukkit.getServer().getWorld(warps.getString("warps." + args[0] + "world"));
		double x = warps.getDouble("warps." + args[0] + "x");
		double y = warps.getDouble("warps." + args[0] + "y");
		double z = warps.getDouble("warps." + args[0] + "z");
		float pitch = (float)warps.getDouble("warps." + args[0] + "pitch");
		float yaw = (float)warps.getDouble("warps." + args[0] + "yaw");
		
		p.teleport(new Location(w, x, y, z, pitch, yaw));
		return true;
	}
}
