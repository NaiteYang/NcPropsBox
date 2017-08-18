package nx.propsbox.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import nx.propsbox.core.Core;

public class AccessoryGuiYml 
{
	static Core main;
	public AccessoryGuiYml(Core core){main = core;}
	public static YamlConfiguration aC = null;
	public static File aF = null;
	
	// reload
	@SuppressWarnings("deprecation")
	public static void reload()
	{
		if (aF == null) 
			aF = new File(Core.plugin.getDataFolder() + File.separator + "Interface" + File.separator + "AccessoryGui.yml");
		if (!aF.exists())
		{
			new File(Core.plugin.getDataFolder() + File.separator + "Interface").mkdir();
			Core.plugin.saveResource("Interface/AccessoryGui.yml", true);
		}
		aC = YamlConfiguration.loadConfiguration(aF);
		
		// =================== ½T»{ÀÉ®×¬O§_·l¥¢¡AÁ×§K»~§R
	    InputStream is = Core.plugin.getResource("Interface/AccessoryGui.yml");
		YamlConfiguration defaultYaml = YamlConfiguration.loadConfiguration(is);
	    
	    boolean newMsg = false;
	    for (String key : defaultYaml.getKeys(true)) 
	    {
	    	if (!defaultYaml.isConfigurationSection(key)) 
	    	{
	    		if (aC.getString(key, null) == null)
	    		{
	    			aC.set(key, defaultYaml.getString(key));
	    			newMsg = true;
	    		}
	    	}
	    }
	    if (newMsg) 
	    {
	    	try{
	    		aC.save(aF);
	    	}catch (IOException ex){
	    		ex.printStackTrace();
	    	}
	    }
	}
	// getConfig
	public static FileConfiguration getConfig()
	{
		if(aC == null){reload();}
		return aC;
	}
	// save
	public static void saveConfig()
	{
		if((aC == null) || (aF == null)){return;}
		try{
			getConfig().save(aF);
		}catch(IOException e){
			e.printStackTrace();
			Bukkit.getLogger().log(Level.SEVERE, "Can not be saved." + aF, e );
		}
	}
}
