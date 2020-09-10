package Cortex.CPermsPaper.Players.PlayerEvents;

import Cortex.CPermsPaper.Ranks.RankHandler;
import Cortex.CPermsPaper.Utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnPlayerChat implements Listener {
    RankHandler rankHandler = new RankHandler();
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent playerChatEvent){
        playerChatEvent.setCancelled(true);
        Player player = playerChatEvent.getPlayer();
        String MSG = playerChatEvent.getMessage();
        String NAME = player.getDisplayName();
        String PREFIX = rankHandler.getRankPrefix(rankHandler.getPlayerRank(player));
        String INDENT = " &b>> &r";
        String FORMAT = ColorUtil.Color(PREFIX+NAME+INDENT+MSG);
        Bukkit.broadcastMessage(FORMAT);
    }
}
