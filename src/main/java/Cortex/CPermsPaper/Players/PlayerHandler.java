package Cortex.CPermsPaper.Players;

import Cortex.CPermsPaper.Ranks.Ranks;
import Cortex.CPermsPaper.Utils.Strings;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerHandler {
    static Ranks ranks = new Ranks();
    static Strings strings = new Strings();
    public static void setupPlayer(Player player){
        File playerFile = new File(strings.PlayersData + player.getUniqueId() + ".yml");
        if(!playerFile.exists()){ try { playerFile.createNewFile(); } catch (IOException e) { e.printStackTrace(); } }
        YamlConfiguration yamlConfiguration = new YamlConfiguration();
        yamlConfiguration.addDefault("PlayerName: ", player.getName());
        yamlConfiguration.addDefault("Rank: ", ranks.USER);
        yamlConfiguration.options().copyDefaults(true);
        try { yamlConfiguration.save(playerFile); } catch (IOException e) { e.printStackTrace(); }
    }
    public final Player getPlayer (Player player){ return player; }
}
