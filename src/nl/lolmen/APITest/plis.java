package nl.lolmen.APITest;

import nl.lolmen.Skillz.Skillz;
import nl.lolmen.API.SkillzAPI;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

public class plis extends BlockListener{
	
	public plis(Main main) {
	}

	public void onBlockBreak(BlockBreakEvent event){
		Block b = event.getBlock();
		Player p = event.getPlayer();
		SkillzAPI api = Skillz.api;
		Skillz.api.getSettings().use3Co();
		api.addXP(p, b.getType().name());
	}

}
