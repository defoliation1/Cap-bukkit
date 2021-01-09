package engine.command.util.node;

import engine.command.CommandSender;
import engine.command.argument.Argument;
import engine.command.suggestion.Suggester;
import engine.command.util.StringArgs;
import engine.command.util.context.Context;
import engine.command.util.context.DequeContext;

import java.util.List;
import java.util.Optional;

public class EmptyArgumentNode extends ArgumentNode {

    public EmptyArgumentNode() {
        super(new Argument() {
            @Override
            public String getName() {
                return "Empty";
            }

            @Override
            public Class responsibleClass() {
                return this.getClass();
            }

            @Override
            public Optional parse(Context context, String arg) {
                return Optional.empty();
            }

            @Override
            public Suggester getSuggester() {
                return null;
            }
        });
    }

    @Override
    public int getRequiredArgsNum() {
        return 0;
    }

    @Override
    public boolean parse(DequeContext context, StringArgs args) {
        return true;
    }

    @Override
    public List<Object> collect() {
        return List.of();
    }

    @Override
    public boolean hasTip() {
        return false;
    }

    @Override
    public boolean same(CommandNode node) {
        return super.same(node) && node instanceof EmptyArgumentNode;
    }
}
