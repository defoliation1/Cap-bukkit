package engine.command.argument;

import engine.command.suggestion.Suggester;

import java.util.Optional;
import java.util.function.Function;

public class FunctionArgument<T> extends SimpleArgument<T> {

    private Function<String, Optional<T>> parseFunction;
    private Suggester suggester;

    private FunctionArgument(Class<T> responsibleClass, String argumentName) {
        super(responsibleClass, argumentName);
    }

    @Override
    public Optional<T> parse(String arg) {
        return parseFunction.apply(arg);
    }

    @Override
    public Suggester getSuggester() {
        return suggester;
    }

    public static class FunctionArgumentBuilder<T> {

        private FunctionArgument<T> argument;

        private FunctionArgumentBuilder(FunctionArgument<T> argument) {
            this.argument = argument;
        }

        public FunctionArgumentBuilder<T> setParse(Function<String, Optional<T>> function) {
            argument.parseFunction = function;
            return this;
        }

        public FunctionArgumentBuilder<T> setSuggester(Suggester suggester) {
            argument.suggester = suggester;
            return this;
        }

        public FunctionArgument<T> get() {
            return argument;
        }

    }

    public static <T> FunctionArgumentBuilder<T> getBuilder(Class<T> clazz, String name) {
        return new FunctionArgumentBuilder<>(new FunctionArgument<>(clazz, name));
    }

}
