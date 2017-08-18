package nx.propsbox.core;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import nx.propsbox.cmd.PlayerCmd;
import nx.propsbox.event.InvClick;
import nx.propsbox.file.AccessoryGuiYml;
import nx.propsbox.file.EquipmentGuiYml;
import nx.propsbox.gui.AccessoryGui;

public class Core extends JavaPlugin
{
	public static Core plugin;
	
	public void onEnable()
	{
		plugin = this;
		
		// console
		Server server = getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage(ChatColor.YELLOW + "NcPropsBox v1.0.1 has been enabled");
		
		getCommand("ne").setExecutor(new PlayerCmd());
		
		save();
		files();
		reload();
		events();
	}
	
	public void onDisable()
	{
		save();
	}
	
	public void files()
	{
		AccessoryGuiYml.getConfig().options().copyDefaults(true);
		EquipmentGuiYml.getConfig().options().copyDefaults(true);
	}
	
	public void save()
	{
		AccessoryGuiYml.saveConfig();
		EquipmentGuiYml.saveConfig();
	}
	
	public void reload()
	{
		AccessoryGui.reload();
	}
	
	public void events()
	{
		getServer().getPluginManager().registerEvents(new InvClick(), this);
	}
}
