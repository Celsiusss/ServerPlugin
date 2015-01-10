package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class HealCommand extends ServerPluginCommand {

	public HealCommand(ServerPlugin instance) {
		super(instance);
	}


	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {



		if (args.length == 0) {
			heal(p);
			p.sendMessage(getChatColorDefault() + "You have been " + getChatColorPositive() + "healed!");
			return true;

		}
		Player target = p.getServer().getPlayer(args[0]);

		if (target == null) {
			p.sendMessage(getChatColorError() + "The player " + getChatColoPlayer() + args[0] + getChatColorError() + " does not exist!");
			return true;
		}

		heal(target);
		p.sendMessage(getChatColoPlayer() + target.getDisplayName() + getChatColorDefault() + " has been healed!");
		target.sendMessage(getChatColorDefault() + "You have been " + getChatColorPositive() + "healed" + getChatColorDefault() + " by " + getChatColoPlayer() + p.getDisplayName() + getChatColorDefault() + "!");
		return true;

	}

	private void heal(Player p) {
		p.setHealth(20.0);
		p.setFoodLevel(20);
		p.setSaturation(4);
		for (PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
		}
	}
}
