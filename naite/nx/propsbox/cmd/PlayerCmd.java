package nx.propsbox.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nx.propsbox.gui.AccessoryGui;

public class PlayerCmd implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("¡±cYou must be a player to use this commmand.");
			return false;
		}
		Player p = (Player) sender;
		if(lable.equalsIgnoreCase("ne"))
		{
			if(args.length > 0)
			{
				CmdMessage.Error_cmd(p);
			}else{
				p.closeInventory();
				AccessoryGui.openInterace(p);
			}
		}
	return false;
	}
}
