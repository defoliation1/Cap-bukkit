package pers.defoliation.cap;

import org.bukkit.plugin.java.JavaPlugin;

public class CapPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerCommandSender.init();
    }

}
