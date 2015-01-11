package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class GotoCommand extends ServerPluginCommand {

	public GotoCommand(ServerPlugin instance) {
		super(instance);
	}

	@Override
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

		p.teleport(target.getLocation());
		p.sendMessage(getChatColorDefault() + "You have teleported to " + getChatColoPlayer() + target.getDisplayName());
		target.sendMessage(getChatColoPlayer() + p.getDisplayName() + getChatColorDefault() + " has teleported to you");

		return true;
	}
}
