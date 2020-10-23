package pers.defoliation.cap;

import engine.command.argument.SimpleArgument;
import engine.command.suggestion.Suggester;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerArgument extends SimpleArgument<Player> {
    public PlayerArgument() {
        super(Player.class, "player");
    }

    @Override
    public Optional<Player> parse(String arg) {
        return Optional.ofNullable(Bukkit.getPlayer(arg));
    }

    @Override
    public Suggester getSuggester() {
        return (sender, command, args) -> Bukkit.getOnlinePlayers().stream().map(HumanEntity::getName).collect(Collectors.toList());
    }
}
