package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import me.ende124.testplugin.config.MyConfig;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class WarpsCommand extends ServerPluginCommand {
	public WarpsCommand(ServerPlugin instance) {
		super(instance);
	}

	MyConfig warps = ServerPlugin.warps;
	
	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {

		p.sendMessage(warps.getConfigurationSection("warps").getName());
		return true;
	}
}
