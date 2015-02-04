package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import me.ende124.testplugin.config.MyConfig;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class DelwarpCommand extends ServerPluginCommand{
	public DelwarpCommand(ServerPlugin instance) {
		super(instance);
	}

	MyConfig warps = ServerPlugin.warps;
	
	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (args.length < 1) {
			p.sendMessage(getChatColorError() + "Please specify a warp name!");
			return true;
		}
		if (!warps.contains("warps." + args[0])) {
			p.sendMessage(getChatColorError() + "Invalid warp name!");
			return true;
		}
		warps.removeKey("warps." + args[0]);
		warps.saveConfig();
		p.sendMessage(getChatColorPositive() + "Warp deleted!");
		return true;
	}
}
