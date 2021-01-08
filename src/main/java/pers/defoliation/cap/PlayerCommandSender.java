package pers.defoliation.cap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.objectweb.asm.Opcodes.*;

public class PlayerCommandSender {

    private static HashMap<String, Player> map = new HashMap<>();
    private static Constructor constructor;

    public static Player getSender(Player player) {
        if (map.containsKey(player.getName()))
            return map.get(player.getName());
        try {
            Player player1 = (Player) constructor.newInstance(player);
            map.put(player.getName(), player1);
            return player1;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void definePlayerCommandSender() {
        ClassNode classNode = new ClassNode();
        classNode.name = "PlayerCommandSender";
        classNode.superName = Type.getInternalName(CapCommandSender.class);
        classNode.interfaces = Collections.singletonList(Type.getInternalName(Player.class));
        classNode.version = V1_8;
        classNode.access = ACC_PUBLIC | ACC_SUPER;

        if (classNode.fields == null)
            classNode.fields = new ArrayList<>();
        classNode.fields.add(new FieldNode(ACC_PUBLIC, "player", Type.getDescriptor(String.class), null, null));

        if (classNode.methods == null)
            classNode.methods = new ArrayList<>();

        MethodNode constructorMethod = new MethodNode(ACC_PUBLIC, "<init>", "(" + Type.getDescriptor(Player.class) + ")V", null, null);

        constructorMethod.instructions = new InsnList();
        InsnList instructions = constructorMethod.instructions;
        instructions.add(new VarInsnNode(ALOAD, 0));
        instructions.add(new VarInsnNode(ALOAD, 1));
        instructions.add(new MethodInsnNode(INVOKESPECIAL, Type.getInternalName(CapCommandSender.class), "<init>", "(" + Type.getDescriptor(CommandSender.class) + ")V", false));
        instructions.add(new VarInsnNode(ALOAD, 0));
        instructions.add(new VarInsnNode(ALOAD, 1));
        instructions.add(new MethodInsnNode(INVOKEINTERFACE, Type.getInternalName(CommandSender.class), "getName", "()" + Type.getDescriptor(String.class)));
        instructions.add(new FieldInsnNode(PUTFIELD, classNode.name, "player", Type.getDescriptor(String.class)));
        instructions.add(new InsnNode(RETURN));

        classNode.methods.add(constructorMethod);

        MethodNode getPlayerMethod = new MethodNode(ACC_PUBLIC, "getPlayerByName", "()" + Type.getDescriptor(Player.class), null, null);
        getPlayerMethod.instructions = new InsnList();
        instructions = getPlayerMethod.instructions;
        instructions.add(new VarInsnNode(ALOAD, 0));
        instructions.add(new FieldInsnNode(GETFIELD, classNode.name, "player", Type.getDescriptor(String.class)));
        instructions.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(Bukkit.class), "getPlayer", "(" + Type.getDescriptor(String.class) + ")" + Type.getDescriptor(Player.class)));
        instructions.add(new InsnNode(ARETURN));

        classNode.methods.add(getPlayerMethod);

        List<MethodNode> implementMethod = new ArrayList<>();
        addImplementClass(Player.class, implementMethod, new HashSet<>());

        HashSet<String> methodName = new HashSet<>();

        for (MethodNode playerMethodNode : implementMethod) {
            if (methodName.contains(playerMethodNode.name + playerMethodNode.desc) && playerMethodNode.instructions != null) {
                methodName.add(playerMethodNode.name + playerMethodNode.desc);
                continue;
            }
            methodName.add(playerMethodNode.name + playerMethodNode.desc);
            MethodNode methodNode = new MethodNode(ACC_PUBLIC, playerMethodNode.name, playerMethodNode.desc, playerMethodNode.signature, playerMethodNode.exceptions.toArray(new String[0]));
            methodNode.instructions = new InsnList();
            InsnList instructions1 = methodNode.instructions;
            instructions1.add(new VarInsnNode(ALOAD, 0));
            instructions1.add(new MethodInsnNode(INVOKEVIRTUAL, classNode.name, "getPlayerByName", "()" + Type.getDescriptor(Player.class)));
            Type[] argumentTypes = Type.getArgumentTypes(playerMethodNode.desc);
            int offset = 1;
            for (Type argumentType : argumentTypes) {
                instructions1.add(new VarInsnNode(argumentType.getOpcode(ILOAD), offset));
                offset += argumentType.getSize();
            }
            instructions1.add(new MethodInsnNode(INVOKEINTERFACE, Type.getInternalName(Player.class), methodNode.name, methodNode.desc));
            Type returnType = Type.getReturnType(playerMethodNode.desc);
            instructions1.add(new InsnNode(returnType.getOpcode(IRETURN)));
            classNode.methods.add(methodNode);
        }
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
        byte[] bytes = classWriter.toByteArray();

        ClassLoader classLoader = PlayerCommandSender.class.getClassLoader();
        try {
            Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
            defineClass.setAccessible(true);
            try {
                Class clazz = (Class) defineClass.invoke(classLoader, bytes, 0, bytes.length);
                Field classes = classLoader.getClass().getDeclaredField("classes");
                classes.setAccessible(true);
                Map<String, Class<?>> o = (Map<String, Class<?>>) classes.get(classLoader);
                o.put(clazz.getName(), clazz);
                constructor = clazz.getConstructor(Player.class);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    private static void addImplementClass(Class clazz, List<MethodNode> methodNodes, Set<String> list) {
        ClassReader classReader = null;
        try {
            classReader = new ClassReader(clazz.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClassNode playerNode = new ClassNode();
        classReader.accept(playerNode, V1_8);
        for (MethodNode method : playerNode.methods) {
            if ((method.access & ACC_STATIC) != 0)
                continue;
            if (method.instructions != null && method.instructions.size() > 1) {
                list.add(method.name + method.desc);
                continue;
            }
            if (list.contains(method.name + method.desc))
                continue;
            list.add(method.name + method.desc);
            methodNodes.add(method);
        }
        for (Class anInterface : clazz.getInterfaces()) {
            addImplementClass(anInterface, methodNodes, list);
        }
    }

    public static void init() {
        definePlayerCommandSender();
    }

}
