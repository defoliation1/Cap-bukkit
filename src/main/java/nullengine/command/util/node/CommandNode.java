package nullengine.command.util.node;

import nullengine.command.CommandSender;
import nullengine.command.suggestion.Suggester;
import nullengine.command.util.CommandNodeUtil;

import java.util.*;
import java.util.function.Consumer;

public abstract class CommandNode implements Comparable<CommandNode>, Cloneable {

    private CommandNode parent;

    private Consumer<List<Object>> executor;

    private TreeSet<CommandNode> children = new TreeSet<>();

    private Set<String> needPermission = new HashSet();

    private Suggester suggester;

    private String tip;

    protected Object parseResult;

    public CommandNode() {
    }

    public boolean parse(CommandSender sender, String command, String... arg) {
        Object result = parseArgs(sender, command, arg);
        if (result != null) {
            parseResult = result;
            return true;
        }
        return false;
    }

    public List<Object> collect() {
        ArrayList list = new ArrayList();
        list.add(parseResult);
        if (parent != null) {
            list.addAll(parent.collect());
        }
        return list;
    }

    public abstract int getRequiredArgsNum();

    protected abstract Object parseArgs(CommandSender sender, String command, String... args);

    public CommandNode getParent() {
        return parent;
    }

    public Collection<CommandNode> getChildren() {
        return children;
    }

    public void addChild(CommandNode commandNode) {
        commandNode.setParent(this);
        this.children.add(commandNode);
    }

    public void removeChild(CommandNode commandNode) {
        this.children.remove(commandNode);
        commandNode.setParent(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommandNode node = (CommandNode) o;
        return Objects.equals(children, node.children) &&
                Objects.equals(needPermission, node.needPermission) &&
                Objects.equals(suggester, node.suggester) &&
                Objects.equals(tip, node.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(needPermission, suggester, tip);
    }

    public boolean canExecuteCommand() {
        return getExecutor() != null;
    }

    protected void setParent(CommandNode parent) {
        this.parent = parent;
    }

    public void setExecutor(Consumer<List<Object>> executor) {
        this.executor = executor;
    }

    public Consumer<List<Object>> getExecutor() {
        return executor;
    }

    public Set<String> getNeedPermission() {
        return needPermission;
    }

    public void setNeedPermission(Set<String> needPermission) {
        this.needPermission = needPermission;
    }

    public Suggester getSuggester() {
        return suggester;
    }

    public void setSuggester(Suggester suggester) {
        this.suggester = suggester;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean hasTip() {
        return tip != null;
    }

    @Override
    public CommandNode clone() {
        CommandNode node = null;
        try {
            node = (CommandNode) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        node.children = new TreeSet<>();
        for (CommandNode child : children) {
            node.addChild(child.clone());
        }
        return node;
    }

    @Override
    public int compareTo(CommandNode o) {
        return needPermission.size() - o.needPermission.size();
    }
}