package Cortex.CPermsPaper.Ranks;

import Cortex.CPermsPaper.Players.PlayerHandler;
import Cortex.CPermsPaper.Utils.ColorUtil;
import Cortex.CPermsPaper.Utils.Strings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;

public class RankHandler extends Ranks{
    Strings strings = new Strings();
    PlayerHandler playerHandler = new PlayerHandler();
    public int getPlayerRank(Player player){
        File PlayerData = new File(strings.PlayersData + player.getUniqueId() + strings.yml);
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(PlayerData);
        return yamlConfiguration.getInt("Rank: ");
    }
    public void setPlayerRank(Player player, int Rank){
        File PlayerData = new File(strings.PlayersData + player.getUniqueId() + strings.yml);
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.set("Rank: ", Rank);
        try { yamlConfiguration.save(PlayerData); } catch (IOException e) { e.printStackTrace(); }
    }
    public String getRankPrefix(int Rank){
        if(Rank == ADMIN) {
            return ColorUtil.Color(ADMINPREFIX);
        }else if(Rank == DEVELOPER){
            return ColorUtil.Color(DEVELOPERPREFIX);
        }else if (Rank == MODERATOR){
            return ColorUtil.Color(MODERATORPREFIX);
        }else{
            return ColorUtil.Color(USERPREFIX);
        }
    }
    public void RankGetter(){
        for(Player player : Bukkit.getOnlinePlayers()){
            Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
            for(Player player1 : Bukkit.getOnlinePlayers()){
                String prefix = getRankPrefix(getPlayerRank(player));
                Team team = scoreboard.registerNewTeam(player1.getDisplayName());
                team.setPrefix(prefix);
                team.addEntry(player1.getDisplayName());
            }
            player.setScoreboard(scoreboard);
        }
    }

}
