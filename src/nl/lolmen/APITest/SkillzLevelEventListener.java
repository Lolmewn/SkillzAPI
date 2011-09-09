package nl.lolmen.APITest;

import nl.lolmen.API.SkillzLevelEvent;

import org.bukkit.entity.Player;
import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public class SkillzLevelEventListener extends CustomEventListener implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public SkillzLevelEventListener(Main main) {
		plugin = main;
	}
	
	public void onCustomEvent(Event event){
		if(event instanceof SkillzLevelEvent){
			doEvent((SkillzLevelEvent)event);
		}
	}

	private void doEvent(SkillzLevelEvent event) {
		Player p = event.getPlayer();
		String skill = event.getSkill();
		p.sendMessage("Skill " + skill + " leveled!");
	}

}
