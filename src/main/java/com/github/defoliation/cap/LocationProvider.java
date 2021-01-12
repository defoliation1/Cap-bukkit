package com.github.defoliation.cap;

import engine.command.anno.Provide;
import engine.command.anno.Sender;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LocationProvider {

    @Provide
    public Location playerWorld(@Sender Player player, double x, double y, double z) {
        return setWorld(player.getWorld(), x, y, z);
    }

    @Provide
    public Location setWorld(World world, double x, double y, double z) {
        return new Location(world, x, y, z);
    }

}
