package pers.defoliation.cap;

import engine.command.anno.Command;
import engine.command.anno.Sender;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CapPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        CapCommandManager capCommandManager = new CapCommandManager(this);
        capCommandManager.getBuilder().addCommandHandler(this).register();
    }

    @Command("tpTest")
    public void tpTest(@Sender Player player, Location location) {
        player.teleport(location);
    }

}
