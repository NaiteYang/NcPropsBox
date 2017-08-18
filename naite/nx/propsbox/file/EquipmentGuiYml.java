package nx.propsbox.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import nx.propsbox.core.Core;

public class EquipmentGuiYml 
{
	static Core main;
	public EquipmentGuiYml(Core core){main = core;}
	public static YamlConfiguration eC = null;
	public static File eF = null;
	
	// reload
	@SuppressWarnings("deprecation")
	public static void reload()
	{
		if (eF == null) 
			eF = new File(Core.plugin.getDataFolder() + File.separator + "Interface" + File.separator + "EquipmentGui.yml");
		if (!eF.exists())
		{
			new File(Core.plugin.getDataFolder() + File.separator + "Interface").mkdir();
			Core.plugin.saveResource("Interface/EquipmentGui.yml", true);
		}
		eC = YamlConfiguration.loadConfiguration(eF);
		
		// =================== ½T»{ÀÉ®×¬O§_·l¥¢¡AÁ×§K»~§R
	    InputStream is = Core.plugin.getResource("Interface/EquipmentGui.yml");
		YamlConfiguration defaultYaml = YamlConfiguration.loadConfiguration(is);
	    
	    boolean newMsg = false;
	    for (String key : defaultYaml.getKeys(true)) 
	    {
	    	if (!defaultYaml.isConfigurationSection(key)) 
	    	{
	    		if (eC.getString(key, null) == null)
	    		{
	    			eC.set(key, defaultYaml.getString(key));
	    			newMsg = true;
	    		}
	    	}
	    }
	    if (newMsg) 
	    {
	    	try{
	    		eC.save(eF);
	    	}catch (IOException ex){
	    		ex.printStackTrace();
	    	}
	    }
	}
	// getConfig
	public static FileConfiguration getConfig()
	{
		if(eC == null){reload();}
		return eC;
	}
	// save
	public static void saveConfig()
	{
		if((eC == null) || (eF == null)){return;}
		try{
			getConfig().save(eF);
		}catch(IOException e){
			e.printStackTrace();
			Bukkit.getLogger().log(Level.SEVERE, "Can not be saved." + eF, e );
		}
	}
}