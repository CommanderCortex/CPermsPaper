package Cortex.CPermsPaper;

import Cortex.CPermsPaper.Commands.SetPlayerRank;
import Cortex.CPermsPaper.Files.FileHandler;
import Cortex.CPermsPaper.Players.PlayerEvents.OnPlayerChat;
import Cortex.CPermsPaper.Players.PlayerEvents.OnPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class CPermsPaperMain extends JavaPlugin {

    @Override
    public void onEnable() {
        FileHandler.setup();
        GetEvents();
        GetCommands();
    }
    private void GetEvents(){
        getServer().getPluginManager().registerEvents(new OnPlayerChat(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
    }
    private void GetCommands(){
        getServer().getPluginCommand("rango").setExecutor(new SetPlayerRank());
    }
}
