package Cortex.CPermsPaper.Commands;

import Cortex.CPermsPaper.Ranks.RankHandler;
import Cortex.CPermsPaper.Utils.ColorUtil;
import Cortex.CPermsPaper.Utils.GlobalMessages;
import Cortex.CPermsPaper.Utils.RankMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SetPlayerRank implements CommandExecutor{
    GlobalMessages globalMessages = new GlobalMessages();
    RankMessages rankMessages = new RankMessages();
    RankHandler rankHandler = new RankHandler();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(globalMessages.PLAYERONLYCMD);
            return false;
        }
        Player player = (Player) sender;
        Player target = Bukkit.getPlayer(args[0]);
        int Rank = rankHandler.getPlayerRank(player);
        if(!(Rank>=75)){
            sender.sendMessage(globalMessages.PERMS);
            return false;
        }
        if(args.length > 2){
            sender.sendMessage(globalMessages.PLUGINPREFIX + rankMessages.usage);
            return false;
        }
        if(target == null && !target.isOnline()){
            sender.sendMessage(globalMessages.PLAYERNOTFOUND+rankMessages.usage);
            return false;
        }

        String FirstArg = ColorUtil.Color(target.getName() + rankMessages.updated);
        switch (args[1]){
            case "ADMIN":
                rankHandler.setPlayerRank(target, rankHandler.ADMIN);
                rankHandler.RankGetter();
                player.sendMessage(ColorUtil.Color(FirstArg + rankHandler.ADMINPREFIX));
                break;
            case "DEV":
                rankHandler.setPlayerRank(target, rankHandler.DEVELOPER);
                rankHandler.RankGetter();
                player.sendMessage(ColorUtil.Color(FirstArg + rankHandler.DEVELOPERPREFIX));
                break;
            case "MOD":
                rankHandler.setPlayerRank(target, rankHandler.MODERATOR);
                rankHandler.RankGetter();
                player.sendMessage(ColorUtil.Color(FirstArg + rankHandler.MODERATORPREFIX));
                break;
            case "USER":
                rankHandler.setPlayerRank(target, rankHandler.USER);
                rankHandler.RankGetter();
                player.sendMessage(ColorUtil.Color(FirstArg + rankHandler.USERPREFIX));
                break;
            default:
                player.sendMessage(ColorUtil.Color(globalMessages.PLUGINPREFIX + rankMessages.ranknotfound));
                break;
        }
        return true;
    }
}
