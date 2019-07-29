package unknowndomain.command.anno.node;

import unknowndomain.command.CommandSender;
import unknowndomain.command.completion.Completer;
import unknowndomain.command.exception.CommandException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public abstract class CommandNode implements Comparable<CommandNode> {

    private CommandNode parent;

    private Method method;

    private Object instance;

    private TreeSet<CommandNode> children = new TreeSet<>();

    private Set<String> needPermission = new HashSet();

    private Completer completer;

    public CommandNode() {
    }

    protected Object parseResult;

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
        if (parent != null)
            list.addAll(parent.collect());
        return list;
    }

    public abstract int getNeedArgs();

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

    public abstract boolean equals(Object obj);

    public boolean canExecuteCommand() {
        return getMethod() != null;
    }

    protected void setParent(CommandNode parent) {
        this.parent = parent;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public Method getMethod() {
        return method;
    }

    public Object getInstance() {
        return instance;
    }

    public Set<String> getNeedPermission() {
        return needPermission;
    }

    public void setNeedPermission(Set<String> needPermission) {
        this.needPermission = needPermission;
    }

    public void execute(Object... args) {
        try {
            method.invoke(instance, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (CommandException e) {
        }
    }

    public Completer getCompleter() {
        return completer;
    }

    public void setCompleter(Completer completer) {
        this.completer = completer;
    }

    @Override
    public int compareTo(CommandNode o) {
        return needPermission.size() - o.needPermission.size();
    }
}
