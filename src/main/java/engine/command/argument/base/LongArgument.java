package engine.command.argument.base;

import engine.command.argument.SimpleArgument;
import engine.command.suggestion.Suggester;
import engine.command.util.context.Context;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LongArgument extends SimpleArgument {
    public LongArgument() {
        super(Long.class,"Long");
    }

    @Override
    public Optional parse(Context context, String arg) {
        try {
            return Optional.of(Long.valueOf(arg));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Suggester getSuggester() {
        return (sender, command, args) -> Arrays.asList("[num]");
    }
}
