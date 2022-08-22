package me.Garvierl.ShopPlugin.Listeners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Garvierl.ShopPlugin.Main;
import me.Garvierl.ShopPlugin.GUI.KBFFAShop;

public class InventoryListener implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getView().getTitle().equals("Shop")) {
			e.setCancelled(true);
			// TODO: Add all the other inventories
			switch (e.getRawSlot()) {
			case 11:
				KBFFAShop shop = new KBFFAShop();
				shop.show((Player)e.getWhoClicked());
				break;
			case 13:
				break;
			case 15:
				break;
			default:
				break;
			}
		}
		else if (e.getView().getTitle().equals("Knockback FFA Shop")) {
			e.setCancelled(true);
			switch (e.getRawSlot()) {
			case 12:
				Player player = (Player)e.getWhoClicked();
				if (Main.economy.getBalance(player) >= 10) {
					ItemStack is = player.getInventory().getItem(8); // Ender Pearl
					is.setAmount(is.getAmount() + 1);
					player.getInventory().setItem(8, is);
					Main.economy.withdrawPlayer(player, 10);
					player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 1);
					player.sendMessage("§aYou bought an extra ender pearl for 10$!");
				}else {
					player.sendMessage("§cYou don't have enough money!");
				}
				break;
			case 14:
				player = (Player)e.getWhoClicked();
				if (Main.economy.getBalance(player) >= 25) {
					ItemStack is = new ItemStack(Material.BLAZE_ROD);
					ItemMeta meta = is.getItemMeta();
					meta.setDisplayName("§6§lBuffed Stick");
					meta.addEnchant(Enchantment.KNOCKBACK, 3, true);
					meta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
					ArrayList<String> lore = new ArrayList<String>();
					lore.add("§7A much cooler §4§lStick§7, ngl.");
					meta.setLore(lore);
					is.setItemMeta(meta);
					player.getInventory().setItem(0, is);
					Main.economy.withdrawPlayer(player, 25);
					player.sendMessage("§aYou bought a §6§lBuffed Stick§a for 25$!");
				}else {
					player.sendMessage("§cYou don't have enough money!");
				}
				break;
			}
		}
	}
}
