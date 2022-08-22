package me.Garvierl.ShopPlugin.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainShopGUI {

	private Inventory inv;
	
	public void show(Player player) {
		createInventory(player);
		player.openInventory(inv);
	}
	
	private void createInventory(Player player) {
		inv = Bukkit.createInventory(null, 27, "Shop");
		
		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15));
		}
		
		ItemStack is = new ItemStack(Material.STICK);
		ItemMeta meta = is.getItemMeta();
		meta.setDisplayName("§aKnockback FFA");
		// glow
		meta.addEnchant(Enchantment.KNOCKBACK, 1, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Opens the shop for");
		lore.add("§7knockback FFA!");
		lore.add("");
		lore.add("§eClick to open!");
		meta.setLore(lore);
		is.setItemMeta(meta);
		inv.setItem(11, is);
		
		is = new ItemStack(Material.DIAMOND_AXE);
		meta = is.getItemMeta();
		meta.setDisplayName("§aUHC");
		lore = new ArrayList<String>();
		lore.add("§7Opens the shop for");
		lore.add("§7UHC!");
		lore.add("");
		lore.add("§eClick to open!");
		meta.setLore(lore);
		is.setItemMeta(meta);
		inv.setItem(13, is);
		
		is = new ItemStack(Material.EYE_OF_ENDER);
		meta = is.getItemMeta();
		meta.setDisplayName("§aSkywars");
		lore = new ArrayList<String>();
		lore.add("§7Opens the shop for");
		lore.add("§7Skywars!");
		lore.add("");
		lore.add("§eClick to open!");
		meta.setLore(lore);
		is.setItemMeta(meta);
		inv.setItem(15, is);
	}
}
