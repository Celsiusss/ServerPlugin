package me.ende124.testplugin;

import me.ende124.testplugin.commands.BringCommand;
import me.ende124.testplugin.commands.GotoCommand;
import me.ende124.testplugin.commands.HealCommand;
import me.ende124.testplugin.commands.SetwarpCommand;
import me.ende124.testplugin.config.MyConfig;
import me.ende124.testplugin.config.MyConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerPlugin extends JavaPlugin {

	public static MyConfig warps;
	MyConfigManager manager;

	@Override
	public void onEnable() {
		manager = new MyConfigManager(this);
		warps = manager.getNewConfig("warps.yml", new String[] {"Warps"});
		
		registerCommands();
	}

	@Override
	public void onDisable() {
	}

	public void registerCommands() {
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("goto").setExecutor(new GotoCommand(this));
		getCommand("bring").setExecutor(new BringCommand(this));
		getCommand("setwarp").setExecutor(new SetwarpCommand(this));
	}
}