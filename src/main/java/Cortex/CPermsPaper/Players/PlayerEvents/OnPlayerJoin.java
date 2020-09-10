package Cortex.CPermsPaper.Players.PlayerEvents;

import Cortex.CPermsPaper.Players.PlayerHandler;
import Cortex.CPermsPaper.Ranks.RankHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
    RankHandler rankHandler = new RankHandler();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent){
        Player player  = playerJoinEvent.getPlayer();
        PlayerHandler.setupPlayer(player);
        rankHandler.RankGetter();
    }
}
