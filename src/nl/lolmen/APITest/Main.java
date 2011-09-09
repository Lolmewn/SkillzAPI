package nl.lolmen.APITest;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public Logger log = Logger.getLogger("Minecraft");
	public plis plis = new plis(this);
	public SkillzLevelEventListener list = new SkillzLevelEventListener(this);

	@Override
	public void onDisable() {
		log.info("Disabled!");
	}

	@Override
	public void onEnable() {
		if(getSkills()){
			getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, plis, Priority.Normal, this);
			getServer().getPluginManager().registerEvent(Event.Type.CUSTOM_EVENT, list, Priority.Normal, this);
			log.info("Enabled!");
		}else{
			log.info("Skillz not found! Disabling!");
			getServer().getPluginManager().disablePlugin(this);
		}
	}

	private boolean getSkills() {
		Plugin test = getServer().getPluginManager().getPlugin("Skillz");
		if(test != null){
			return true;
		}else{
			return false;
		}
	}

}
