package unknowndomain.command.argument.base;


import com.google.common.collect.Sets;
import unknowndomain.command.CommandSender;
import unknowndomain.command.argument.SingleArgument;
import unknowndomain.command.completion.Completer;

import java.util.Optional;
import java.util.Set;

public class IntegerArgument extends SingleArgument {

    public IntegerArgument() {
        super(Integer.class,"Integer");
    }

    @Override
    public Optional parse(String arg) {
        try {
            return Optional.of(Integer.valueOf(arg));
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Completer getCompleter() {
        return (sender, command, args) -> Sets.newHashSet("[num]");
    }
}
