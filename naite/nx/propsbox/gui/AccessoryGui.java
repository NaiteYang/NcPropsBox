package nx.propsbox.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nx.propsbox.file.AccessoryGuiYml;

public class AccessoryGui 
{
	public static ItemStack none = new ItemStack(Material.STAINED_GLASS_PANE,1 , (short)15);
	
	private static YamlConfiguration yaml = (YamlConfiguration) AccessoryGuiYml.getConfig();
	public static String invName = yaml.getString("PropsBox.Name");
	private static String path = "PropsBox.Items.";
	private static String name = ".DisplayName";
	private static String lore = ".Lore";
	
	public static void setMeta(ItemStack is,String item)
	{
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(yaml.getString(path + item + name));
		im.setLore(yaml.getStringList(path + item + lore));
		is.setItemMeta(im);
	}
	
	public static void openInterace(Player p)
	{
		Inventory inv = Bukkit.createInventory(null, 54, invName);
		for(int i = 0;i<54;i++){inv.setItem(i, none);}
		p.openInventory(inv);
	}
	
	public static void reload()
	{
		invName = yaml.getString("PropsBox.Name");
		setItem();
	}
	
	private static void setItem()
	{
		setMeta(none, "None");
	}
}
