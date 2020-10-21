package nullengine.command.util.node;

import nullengine.command.CommandSender;
import nullengine.command.argument.Argument;
import nullengine.command.suggestion.Suggester;
import nullengine.command.util.StringArgs;

import java.util.Collections;
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
            public Optional parse(String arg) {
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
    public boolean parse(CommandSender sender, StringArgs args) {
        return true;
    }

    @Override
    public List<Object> collect() {
        return Collections.emptyList();
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
