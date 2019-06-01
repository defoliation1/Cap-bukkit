package unknowndomain.command.argument;

import java.util.HashMap;

public class SimpleArgumentManager implements ArgumentManager{

    private HashMap<Class, Argument> argumentByClass = new HashMap<>();
    private HashMap<String, Argument> argumentByName = new HashMap<>();

    public SimpleArgumentManager() {
        appendArgument(new IntegerArgument());
        appendArgument(new StringArgument());
    }

    @Override
    public void setClassDefaultArgument(Argument argument) {
        argumentByClass.put(argument.responsibleClass(),argument);
        if(!argumentByName.containsKey(argument.getName()))
            appendArgument(argument);
    }

    @Override
    public void appendArgument(Argument argument) {
        if(argumentByName.containsKey(argument.getName()))
            throw new RuntimeException("argument already exist");
        if(!argumentByClass.containsKey(argument.responsibleClass()))
            argumentByClass.put(argument.responsibleClass(),argument);
        argumentByName.put(argument.getName(),argument);
    }

    @Override
    public void removeArgument(Argument argument) {
        removeArgument(argument.getName());
    }

    @Override
    public void removeArgument(String argumentName) {
        argumentByName.remove(argumentName);
    }

    @Override
    public Argument getArgument(Class clazz) {
        return argumentByClass.get(clazz);
    }

    @Override
    public Argument getArgument(String argumentName) {
        return argumentByName.get(argumentName);
    }
}
