package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class ServerPluginCommand implements CommandExecutor {

	private ChatColor ChatColoPlayer;
	private ChatColor ChatColorError;
	private ChatColor ChatColorWarning;
	private ChatColor ChatColorInfo;
	private ChatColor ChatColorDefault;
	private ChatColor ChatColorArg;
	private ChatColor ChatColorPrivate;
	private ChatColor ChatColorCommand;
	private ChatColor ChatColorPositive;
	private ChatColor ChatColorName;

	public ServerPluginCommand(ServerPlugin instance) {
		setChatColoPlayer(ChatColor.AQUA);
		setChatColorArg(ChatColor.GRAY);
		setChatColorDefault(ChatColor.RESET);
		setChatColorError(ChatColor.RED);
		setChatColorWarning(ChatColor.YELLOW);
		setChatColorInfo(ChatColor.BLUE);
		setChatColorPrivate(ChatColor.LIGHT_PURPLE);
		setChatColorCommand(ChatColor.GOLD);
		setChatColorPositive(ChatColor.GREEN);
		setChatColorName(ChatColor.LIGHT_PURPLE);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(getChatColorError() + "This command can only be used in-game!");
			return true;
		}
		Player p = (Player) sender;

		if (!(p.hasPermission("server." + cmd.getName()))) {
			sender.sendMessage(getChatColorError() + "You don't have permission for this command");
			return true;
		}

		return onPlayerCommand (p, cmd, label, args);
	}

	public abstract boolean onPlayerCommand (Player p, Command cmd, String label, String[] args);

	public ChatColor getChatColoPlayer() {
		return ChatColoPlayer;
	}

	public void setChatColoPlayer(ChatColor chatColoPlayer) {
		ChatColoPlayer = chatColoPlayer;
	}

	public ChatColor getChatColorError() {
		return ChatColorError;
	}

	public void setChatColorError(ChatColor chatColorError) {
		ChatColorError = chatColorError;
	}

	public ChatColor getChatColorWarning() {
		return ChatColorWarning;
	}

	public void setChatColorWarning(ChatColor chatColorWarning) {
		ChatColorWarning = chatColorWarning;
	}

	public ChatColor getChatColorInfo() {
		return ChatColorInfo;
	}

	public void setChatColorInfo(ChatColor chatColorInfo) {
		ChatColorInfo = chatColorInfo;
	}

	public ChatColor getChatColorDefault() {
		return ChatColorDefault;
	}

	public void setChatColorDefault(ChatColor chatColorDefault) {
		ChatColorDefault = chatColorDefault;
	}

	public ChatColor getChatColorArg() {
		return ChatColorArg;
	}

	public void setChatColorArg(ChatColor chatColorArg) {
		ChatColorArg = chatColorArg;
	}

	public ChatColor getChatColorPrivate() {
		return ChatColorPrivate;
	}

	public void setChatColorPrivate(ChatColor chatColorPrivate) {
		ChatColorPrivate = chatColorPrivate;
	}

	public ChatColor getChatColorCommand() {
		return ChatColorCommand;
	}

	public void setChatColorCommand(ChatColor chatColorCommand) {
		ChatColorCommand = chatColorCommand;
	}

	public ChatColor getChatColorPositive() {
		return ChatColorPositive;
	}

	public void setChatColorPositive(ChatColor chatColorPositive) {
		ChatColorPositive = chatColorPositive;
	}

	public ChatColor getChatColorName() {
		return ChatColorName;
	}

	public void setChatColorName(ChatColor chatColorName) {
		ChatColorName = chatColorName;
	}
}