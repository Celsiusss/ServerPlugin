package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class BringCommand extends ServerPluginCommand {

	public BringCommand(ServerPlugin instance) {
		super(instance);
	}

	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			p.sendMessage(getChatColorError() + "Please specify a player!");
			return true;
		}
		Player target = p.getServer().getPlayer(args[0]);

		if (target == null) {
			p.sendMessage(getChatColorError() + "The player " + getChatColoPlayer() + args[0] + getChatColorError() + " does not exist!");
			return true;
		}

		target.teleport(p.getLocation());
		p.sendMessage(getChatColorDefault() + "You have brought " + getChatColoPlayer() + target.getDisplayName() + getChatColorDefault() + " to you!");
		target.sendMessage(getChatColorDefault() + "You have been brought by " + getChatColoPlayer() + p.getDisplayName() + getChatColorDefault() + "!");

		return true;
	}
}
