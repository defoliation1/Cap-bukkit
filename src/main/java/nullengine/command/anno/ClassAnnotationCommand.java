package nullengine.command.anno;

import nullengine.command.Command;
import nullengine.command.CommandManager;
import nullengine.command.argument.ArgumentManager;
import nullengine.command.suggestion.SuggesterManager;
import nullengine.command.util.CommandNodeUtil;
import nullengine.command.util.node.CommandNode;
import nullengine.command.util.node.Nodeable;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Consumer;

public class ClassAnnotationCommand extends NodeAnnotationCommand {

    public ClassAnnotationCommand(String name, String description, String helpMessage) {
        super(name, description, helpMessage);
    }

    public static class ClassAnnotationBuilder extends NodeBuilder{

        private List<CommandHandlerWrapper> commandHandlerList = new ArrayList<>();

        private ClassAnnotationBuilder(CommandManager commandManager) {
            super(commandManager);
        }

        @Override
        public ClassAnnotationBuilder setArgumentManager(ArgumentManager argumentManager) {
            return (ClassAnnotationBuilder) super.setArgumentManager(argumentManager);
        }

        @Override
        public ClassAnnotationBuilder setSuggesterManager(SuggesterManager suggesterManager) {
            return (ClassAnnotationBuilder) super.setSuggesterManager(suggesterManager);
        }

        @Override
        public ClassAnnotationBuilder addProvider(Object object) {
            return (ClassAnnotationBuilder) super.addProvider(object);
        }

        public ClassAnnotationBuilder caseCommand(String commandName, String desc, String helpMessage, Runnable commandHandler) {
            commandHandlerList.add(new CommandHandlerWrapper(commandName, desc, helpMessage, commandHandler));
            return this;
        }

        public ClassAnnotationBuilder caseCommand(String commandName, String desc, Runnable commandHandler) {
            return caseCommand(commandName, desc, "", commandHandler);
        }

        public ClassAnnotationBuilder caseCommand(String commandName, Runnable commandHandler) {
            return caseCommand(commandName, "", commandHandler);
        }

        protected List<Command> build() {
            List<Command> commands = new ArrayList<>();
            for (CommandHandlerWrapper wrapper : commandHandlerList) {
                Runnable commandHandler = wrapper.instance;
                String commandName = wrapper.commandName;
                String desc = wrapper.desc;
                String helpMessage = wrapper.help;

                CommandNodeUtil.ClassUtil innerUtil = CommandNodeUtil.getClassUtil(commandHandler, argumentManager, suggesterManager);

                List<CommandNode> nodeList = new ArrayList<>();

                Command command = commandManager.getCommand(commandName).orElse(null);

                if (command == null)
                    command = new ClassAnnotationCommand(commandName, desc, helpMessage);

                if (!(command instanceof Nodeable))
                    throw new RuntimeException("命令: " + commandName + " 已注册，且不支持");

                Nodeable nodeable = (Nodeable) command;

                nodeList.add(nodeable.getNode());

                Class clazz = commandHandler.getClass();

                Field[] fields = clazz.getFields();

                for (Field field : fields) {
                    if (field.getAnnotation(Ignore.class) != null)
                        continue;
                    List<CommandNode> fieldNodes = innerUtil.parseField(field);
                    ArrayList<CommandNode> branches = new ArrayList<>();
                    for (CommandNode node : nodeList){
                        for (CommandNode child : fieldNodes){
                            CommandNode topCloneChild = CommandNodeUtil.getTopParent(child).clone();
                            node.addChild(topCloneChild);
                            branches.addAll(CommandNodeUtil.getAllBottomNode(topCloneChild));
                        }
                    }
                    nodeList = branches;
                }

                Consumer<List<Object>> executeConsumer = objects -> {
                    int ignored = 0;
                    for (int i = 0; i < objects.size(); i++) {
                        Field field = fields[i + ignored];
                        if (field.getAnnotation(Ignore.class) != null) {
                            ignored++;
                            i--;
                            continue;
                        }
                        try {
                            field.setAccessible(true);
                            field.set(commandHandler, objects.get(i));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    commandHandler.run();
                };

                for (CommandNode node : nodeList) {
                    node.setExecutor(executeConsumer);
                }

                try {
                    Permission permission = commandHandler.getClass().getMethod("run",new Class[0]).getAnnotation(Permission.class);
                    Set<String> needPermission = new HashSet<>(Arrays.asList(permission.value()));
                    if(permission!=null)
                        nodeList.forEach(node -> node.setNeedPermission(needPermission));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                if (nodeable instanceof NodeAnnotationCommand)
                    ((NodeAnnotationCommand) nodeable).flush();
                commands.add(command);
            }
            return commands;
        }

        private class CommandHandlerWrapper {
            public final String commandName;
            public final String desc;
            public final String help;
            public final Runnable instance;

            public CommandHandlerWrapper(String commandName, String desc, String help, Runnable instance) {
                this.commandName = commandName;
                this.desc = desc;
                this.help = help;
                this.instance = instance;
            }
        }
    }

    public static ClassAnnotationBuilder getBuilder(CommandManager commandManager) {
        return new ClassAnnotationBuilder(commandManager);
    }

}