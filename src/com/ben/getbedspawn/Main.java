package com.ben.getbedspawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		System.out.println("TEST PLUGIN ENABLED!");
	}
	
	@Override
	public void onDisable()
	{
		System.out.println("TEST PLUGIN DISABLED!");
	}
		
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
	{
		if (cmd.getName().equals("bedspawn"))
		{
			if (sender instanceof Player)
			{
				Player player = (Player) sender;
				
				if (player.hasPermission("getbedspawn.allowcmd")) //Checks perms
				{
					try
					{
						double bedXCoord = player.getBedSpawnLocation().getX();
						double bedYCoord = player.getBedSpawnLocation().getY();
						double bedZCoord = player.getBedSpawnLocation().getZ();
						player.sendMessage("Your bed spawn is located at " + ChatColor.BOLD + ChatColor.GOLD + 
								"\nX: " + bedXCoord + 
								"\nY: " + bedYCoord + 
								"\nZ: " + bedZCoord);
					}
					catch (NullPointerException e) //Null occurs when player has no detectable bed
					{
						player.sendMessage("Hmm, your bed was not detected. Try sleeping!");
					}
				}
				else
				{
					player.sendMessage(ChatColor.RED + "You don't have permission to use that command!");
				}
			}
			else
			{
				System.out.println("You cannot use this command through the console!");
			}
			
		}
		
		return false;
	}
}
