package pers.defoliation.cap;

import engine.command.CommandManager;
import engine.command.anno.MethodAnnotationCommand;
import engine.command.argument.ArgumentManager;
import engine.command.argument.SimpleArgumentManager;
import engine.command.impl.SimpleCommandManager;
import engine.command.suggestion.SimpleSuggesterManager;
import engine.command.suggestion.SuggesterManager;

public class BukkitCommand {

    public static final BukkitCommand INSTANCE = new BukkitCommand();

    private SimpleCommandManager simpleCommandManager = new SimpleCommandManager();

    private ArgumentManager argumentManager = new SimpleArgumentManager();

    private SuggesterManager suggesterManager = new SimpleSuggesterManager();

    private BukkitCommand() {
        argumentManager.setClassDefaultArgument(new WorldArgument());
        argumentManager.setClassDefaultArgument(new PlayerArgument());
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

    public MethodAnnotationCommand.AnnotationCommandBuilder getBuilder() {
        return MethodAnnotationCommand.getBuilder(simpleCommandManager)
                .setArgumentManager(argumentManager)
                .setSuggesterManager(suggesterManager)
                .addProvider(new LocationProvider());
    }

}
