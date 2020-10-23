package pers.defoliation.cap;

import engine.command.argument.SimpleArgument;
import engine.command.suggestion.Suggester;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.util.Optional;
import java.util.stream.Collectors;

public class WorldArgument extends SimpleArgument<World> {

    public WorldArgument() {
        super(World.class, "world");
    }

    @Override
    public Optional<World> parse(String arg) {
        return Optional.ofNullable(Bukkit.getWorld(arg));
    }

    @Override
    public Suggester getSuggester() {
        return (sender, command, args) -> Bukkit.getWorlds().stream().map(World::getName).collect(Collectors.toList());
    }
}
