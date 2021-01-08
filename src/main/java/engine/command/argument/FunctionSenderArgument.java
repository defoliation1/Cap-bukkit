package engine.command.argument;

import engine.command.CommandSender;
import engine.command.suggestion.Suggester;

import java.util.Optional;
import java.util.function.BiFunction;

public class FunctionSenderArgument<T> extends SimpleArgument<T> implements SenderArgument {
    private CommandSender sender;
    private BiFunction<CommandSender, String, Optional<T>> parseFunction;
    private Suggester suggester;

    private FunctionSenderArgument(Class<T> responsibleClass, String argumentName) {
        super(responsibleClass, argumentName);
    }

    @Override
    public Optional<T> parse(String arg) {
        return parseFunction.apply(sender, arg);
    }

    @Override
    public Suggester getSuggester() {
        return suggester;
    }

    @Override
    public CommandSender getSender() {
        return sender;
    }

    @Override
    public void setSender(CommandSender sender) {
        this.sender = sender;
    }

    public static class FunctionArgumentBuilder<T> {

        private FunctionSenderArgument<T> argument;

        private FunctionArgumentBuilder(FunctionSenderArgument<T> argument) {
            this.argument = argument;
        }

        public FunctionArgumentBuilder<T> setParse(BiFunction<CommandSender, String, Optional<T>> function) {
            argument.parseFunction = function;
            return this;
        }

        public FunctionArgumentBuilder<T> setSuggester(Suggester suggester) {
            argument.suggester = suggester;
            return this;
        }

        public FunctionSenderArgument<T> get() {
            return argument;
        }

    }

    public static <T> FunctionArgumentBuilder<T> getBuilder(Class<T> clazz, String name) {
        return new FunctionArgumentBuilder<>(new FunctionSenderArgument<>(clazz, name));
    }

}
