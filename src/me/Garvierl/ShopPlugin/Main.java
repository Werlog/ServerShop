package me.Garvierl.ShopPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import me.Garvierl.ShopPlugin.Commands.ShopCommand;
import me.Garvierl.ShopPlugin.Listeners.InventoryListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

	public static Economy economy;
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
		
		if (!setupEconomy()) {
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
		getCommand("shop").setExecutor(new ShopCommand());
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> eco = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
		economy = eco.getProvider();
		return economy != null;
	}
}
