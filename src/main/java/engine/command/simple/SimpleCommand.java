package engine.command.simple;

import engine.command.ArgumentCheckResult;
import engine.command.Command;
import engine.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class SimpleCommand extends Command {

    private CommandExecutor executor;
    private CommandSuggester completer;
    private CommandArgumentChecker argumentChecker;
    private CommandTips tips;

    public SimpleCommand(String name) {
        super(name);
    }

    public SimpleCommand(String name, CommandExecutor executor) {
        super(name);
        this.executor = executor;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        executor.execute(sender, this, args);
    }

    @Override
    public List<String> suggest(CommandSender sender, String[] args) {
        if (completer == null) return Collections.emptyList();
        return completer.suggest(sender, this, args);
    }

    @Override
    public List<String> getTips(CommandSender sender, String[] args) {
        if (tips == null) return Collections.emptyList();
        return tips.getTips(sender, args);
    }

    @Override
    public ArgumentCheckResult checkLastArgument(CommandSender sender, String[] args) {
        if (argumentChecker != null) return argumentChecker.checkArguments(sender, args);
        return ArgumentCheckResult.Valid();
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public void setCompleter(CommandSuggester completer) {
        this.completer = completer;
    }

    public void setArgumentChecker(CommandArgumentChecker argumentChecker) {
        this.argumentChecker = argumentChecker;
    }

    public void setTips(CommandTips tips) {
        this.tips = tips;
    }
}
