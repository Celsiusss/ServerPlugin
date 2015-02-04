package me.ende124.testplugin;

import me.ende124.testplugin.commands.*;
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
		getCommand("warps").setExecutor(new WarpsCommand(this));
		getCommand("warp").setExecutor(new WarpCommand(this));
		getCommand("delwarp").setExecutor(new DelwarpCommand(this));
	}
}