package engine.command.argument.base;

import engine.command.argument.SimpleArgument;
import engine.command.suggestion.Suggester;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShortArgument extends SimpleArgument {
    public ShortArgument() {
        super(Short.class,"Short");
    }

    @Override
    public Optional parse(String arg) {
        try {
            return Optional.of(Short.valueOf(arg));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Suggester getSuggester() {
        return (sender, command, args) -> Arrays.asList("[num]");
    }
}
