package nullengine.command.util.node;

import nullengine.command.CommandSender;
import nullengine.command.suggestion.Suggester;

import java.util.*;

public class SenderNode extends CommandNode {

    private Class<? extends CommandSender>[] allowedSenders;

    public SenderNode(Class<? extends CommandSender>... clazz) {
        allowedSenders = clazz;
    }

    @Override
    public int getRequiredArgsNum() {
        return 0;
    }

    @Override
    public Object parseArgs(CommandSender sender, String command, String... args) {
        if (allowedSender(sender)){
            return sender;
        }
        return null;
    }

    public boolean allowedSender(CommandSender sender) {
        for (Class clazz : allowedSenders){
            if (clazz.isAssignableFrom(sender.getClass())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SenderNode that = (SenderNode) o;
        return Arrays.equals(allowedSenders, that.allowedSenders);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(allowedSenders);
        return result;
    }

    @Override
    public String toString() {
        return "SenderNode{" +
                "allowedSender=" + Arrays.toString(allowedSenders) +
                '}';
    }

    public boolean hasTip() {
        return false;
    }

    @Override
    public Suggester getSuggester() {
        return (sender, command, args) -> allowedSender(sender)?getChildren()
                .stream()
                .map(node -> node.getSuggester().suggest(sender, command, args))
                .collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll): Collections.EMPTY_LIST;
    }
}