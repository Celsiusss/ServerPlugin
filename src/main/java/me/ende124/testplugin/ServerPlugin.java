package me.ende124.testplugin;

import me.ende124.testplugin.commands.BringCommand;
import me.ende124.testplugin.commands.GotoCommand;
import me.ende124.testplugin.commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerPlugin extends JavaPlugin {

	@Override
	public void onEnable() {

		registerCommands();
	}

	@Override
	public void onDisable() {
	}

	public void registerCommands() {
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("goto").setExecutor(new GotoCommand(this));
		getCommand("bring").setExecutor(new BringCommand(this));
	}
}