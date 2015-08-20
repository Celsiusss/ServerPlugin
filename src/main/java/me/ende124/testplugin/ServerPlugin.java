package me.ende124.testplugin;

import me.ende124.testplugin.commands.*;
import me.ende124.testplugin.config.MyConfig;
import me.ende124.testplugin.config.MyConfigManager;
import me.ende124.testplugin.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ServerPlugin extends JavaPlugin implements Listener {

	public static MyConfig warps, signs;
	MyConfigManager manager;
	public static HashMap<Player, Boolean> holodelmap;
	
	@Override
	public void onEnable() {
		manager = new MyConfigManager(this);
		warps = manager.getNewConfig("warps.yml", new String[]{"Warps"});
		signs = manager.getNewConfig("signs.yml");
		signs.saveConfig();
		warps.saveConfig();

		registerCommands();

		getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		getServer().getPluginManager().registerEvents(new ArmorHoloListener(), this);

		holodelmap = new HashMap<Player, Boolean>();
	}

	@Override
	public void onDisable() {
	}

	
	private void registerCommands() {
		getCommand("heal").setExecutor(new HealCommand(this));
		getCommand("goto").setExecutor(new GotoCommand(this));
		getCommand("bring").setExecutor(new BringCommand(this));
		getCommand("setwarp").setExecutor(new SetwarpCommand(this));
		getCommand("warps").setExecutor(new WarpsCommand(this));
		getCommand("warp").setExecutor(new WarpCommand(this));
		getCommand("delwarp").setExecutor(new DelwarpCommand(this));
		getCommand("kit").setExecutor(new KitCommand(this));
		getCommand("acolor").setExecutor(new AcolorCommand(this));
		getCommand("holo").setExecutor(new HoloCommand(this));
		getCommand("delholo").setExecutor(new DelholoCommand(this));
	}
}