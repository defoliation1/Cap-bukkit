package pers.defoliation.cap;

import engine.command.Command;
import engine.command.CommandManager;
import engine.command.anno.MethodAnnotationCommand;
import engine.command.argument.ArgumentManager;
import engine.command.argument.SimpleArgumentManager;
import engine.command.impl.SimpleCommandManager;
import engine.command.suggestion.SimpleSuggesterManager;
import engine.command.suggestion.SuggesterManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

public class CapCommandManager {

    private static SimpleCommandMap simpleCommandMap;

    private Plugin plugin;

    private SimpleCommandManager simpleCommandManager = new SimpleCommandManager();

    private ArgumentManager argumentManager = new SimpleArgumentManager();

    private SuggesterManager suggesterManager = new SimpleSuggesterManager();

    public CapCommandManager(Plugin plugin) {
        argumentManager.setClassDefaultArgument(new WorldArgument());
        argumentManager.setClassDefaultArgument(new PlayerArgument());
        this.plugin = plugin;
    }

    public CommandManager getCommandManager() {
        return simpleCommandManager;
    }

    public SuggesterManager getSuggesterManager() {
        return suggesterManager;
    }

    public ArgumentManager getArgumentManager() {
        return argumentManager;
    }

    public AnnotationCommandBuilder getBuilder() {
        return new AnnotationCommandBuilder();
    }

    public class AnnotationCommandBuilder {

        private MethodAnnotationCommand.AnnotationCommandBuilder builder = MethodAnnotationCommand.getBuilder(simpleCommandManager)
                .setArgumentManager(argumentManager)
                .setSuggesterManager(suggesterManager)
                .addProvider(new LocationProvider());

        public AnnotationCommandBuilder addProvider(Object object) {
            builder.addProvider(object);
            return this;
        }

        public AnnotationCommandBuilder addCommandHandler(Object object) {
            builder.addCommandHandler(object);
            return this;
        }

        public void register() {
            builder.register();
            for (Command command : simpleCommandManager.registeredCommands()) {
                if (simpleCommandMap.getCommand(plugin.getDescription().getName() + ":" + command.getName()) == null) {
                    simpleCommandMap.register(plugin.getDescription().getName(), new CapCommand(command.getName(), command.getDescription(), command.getHelpMessage()));
                }
            }
        }

    }

    private class CapCommand extends BukkitCommand {

        protected CapCommand(String name, String description, String usageMessage) {
            super(name, description, usageMessage, Collections.emptyList());
        }

        @Override
        public boolean execute(CommandSender sender, String commandLabel, String[] args) {
            StringBuilder stringBuilder = new StringBuilder(commandLabel + " ");
            for (String arg : args) {
                stringBuilder.append(arg + " ");
            }
            simpleCommandManager.execute(CapCommandSender.getCapSender(sender), stringBuilder.substring(0, stringBuilder.length() - 1));
            return true;
        }

        @Override
        public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
            StringBuilder stringBuilder = new StringBuilder(alias + " ");
            for (String arg : args) {
                stringBuilder.append(arg + " ");
            }
            return simpleCommandManager.complete(CapCommandSender.getCapSender(sender), stringBuilder.substring(0, stringBuilder.length() - 1));
        }
    }

    static {
        try {
            Field simpleCommandMapField = SimplePluginManager.class.getDeclaredField("commandMap");
            simpleCommandMapField.setAccessible(true);
            simpleCommandMap = (SimpleCommandMap) simpleCommandMapField.get(Bukkit.getPluginManager());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
