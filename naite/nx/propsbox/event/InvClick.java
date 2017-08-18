package nx.propsbox.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import nx.propsbox.gui.AccessoryGui;

public class InvClick implements Listener
{
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getInventory();
		
		if(inv.getName().equals(AccessoryGui.invName))
		{
			try{
				e.getCurrentItem().equals(null);
				e.getCurrentItem().getItemMeta().getDisplayName().equals(null);
			}catch(NullPointerException ex){
				e.setCancelled(true);
				return;
			}
			
			if(e.getClick() == ClickType.RIGHT || e.getClick() == ClickType.LEFT)
			{
				e.setCancelled(true);
			}else e.setCancelled(true);
		}
	}
}
