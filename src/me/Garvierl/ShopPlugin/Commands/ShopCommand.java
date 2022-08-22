package me.Garvierl.ShopPlugin.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Garvierl.ShopPlugin.GUI.MainShopGUI;

public class ShopCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String args, String[] label) {
		if (sender instanceof Player) {
			MainShopGUI gui = new MainShopGUI();
			gui.show((Player)sender);
		}else {
			sender.sendMessage("§cOnly players can run this!");
			return false;
		}
		return false;
	}
}
