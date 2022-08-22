package me.Garvierl.ShopPlugin.GUI;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KBFFAShop {

	private Inventory inv;
	
	public void show(Player player) {
		createInventory(player);
		player.openInventory(inv);
	}
	
	private void createInventory(Player player) {
		inv = Bukkit.createInventory(null, 27, "Knockback FFA Shop");
		
		for (int i = 0; i < inv.getSize(); i++) {
			inv.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15));
		}
		
		ItemStack is = new ItemStack(Material.ENDER_PEARL);
		ItemMeta meta = is.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("§7Gives you an extra ender pearl");
		lore.add("");
		lore.add("§7Price: §b10$");
		lore.add("§cOne time use!");
		lore.add("");
		lore.add("§eClick to purchase!");
		meta.setLore(lore);
		is.setItemMeta(meta);
		inv.setItem(12, is);
		
		is = new ItemStack(Material.BLAZE_ROD);
		meta = is.getItemMeta();
		meta.setDisplayName("§6§lBuffed Stick");
		lore = new ArrayList<String>();
		lore.add("§7Gives you a better stick");
		lore.add("§7with knockback III and");
		lore.add("§7sharpness II!");
		lore.add("");
		lore.add("§7Price: §b25$");
		lore.add("§cOne time use!");
		lore.add("");
		lore.add("§eClick to purchase!");
		meta.setLore(lore);
		is.setItemMeta(meta);ll
		inv.setItem(14, is);
	}
}
