package pers.defoliation.cap;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.objectweb.asm.Opcodes.*;

public class PlayerCommandSender {

    private static Constructor constructor;

    public static CapCommandSender getSender(Player player) {
        if (constructor == null) {
            definePlayerCommandSender();
        }
        try {
            return (CapCommandSender) constructor.newInstance(player);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException();
    }

    private static void definePlayerCommandSender() {
        ClassNode classNode = new ClassNode();
        classNode.name = "PlayerCommandSender";
        classNode.superName = Type.getInternalName(CapCommandSender.class);
        classNode.interfaces = Collections.singletonList(Type.getInternalName(Player.class));

        if (classNode.fields == null)
            classNode.fields = new ArrayList<>();
        classNode.fields.add(new FieldNode(ACC_PUBLIC, "player", Type.getDescriptor(Player.class), null, null));

        if (classNode.methods == null)
            classNode.methods = new ArrayList<>();

        MethodNode constructorMethod = new MethodNode(ACC_PUBLIC, "<init>", "(L" + Type.getDescriptor(Player.class) + ";)V", null, null);

        InsnList instructions = constructorMethod.instructions;
        instructions.add(new VarInsnNode(ALOAD, 0));
        instructions.add(new VarInsnNode(ALOAD, 1));
        instructions.add(new MethodInsnNode(INVOKESPECIAL, Type.getInternalName(CapCommandSender.class), "<init>", "(L" + Type.getDescriptor(CommandSender.class) + ";)V", false));
        instructions.add(new VarInsnNode(ALOAD, 0));
        instructions.add(new VarInsnNode(ALOAD, 1));
        instructions.add(new FieldInsnNode(PUTFIELD, classNode.name, "player", Type.getDescriptor(Player.class)));
        instructions.add(new InsnNode(RETURN));

        classNode.methods.add(constructorMethod);

        for (Method method : Player.class.getMethods()) {
            MethodNode methodNode = new MethodNode(ACC_PUBLIC, method.getName(), Type.getMethodDescriptor(method), null, Arrays.stream(method.getExceptionTypes()).map(Type::getInternalName).collect(Collectors.toList()).toArray(new String[0]));
            InsnList instructions1 = methodNode.instructions;
            instructions1.add(new VarInsnNode(ALOAD, 0));
            instructions1.add(new FieldInsnNode(GETFIELD, classNode.name, "player", Type.getDescriptor(Player.class)));
            for (int i = 0; i < method.getParameterTypes().length; i++) {
                instructions1.add(new VarInsnNode(ALOAD, i + 1));
            }
            instructions1.add(new MethodInsnNode(INVOKEVIRTUAL, Type.getInternalName(Player.class), method.getName(), Type.getMethodDescriptor(method)));
            if (method.getReturnType() != null) {
                if (method.getReturnType() == int.class) {
                    instructions1.add(new InsnNode(IRETURN));
                } else if (method.getReturnType() == long.class) {
                    instructions1.add(new InsnNode(LRETURN));
                } else if (method.getReturnType() == float.class) {
                    instructions1.add(new InsnNode(FRETURN));
                } else if (method.getReturnType() == double.class) {
                    instructions1.add(new InsnNode(DRETURN));
                } else
                    instructions1.add(new InsnNode(ARETURN));
            } else {
                instructions1.add(new InsnNode(RETURN));
            }
            classNode.methods.add(methodNode);
        }

        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
        byte[] bytes = classWriter.toByteArray();

        ClassLoader classLoader = PlayerCommandSender.class.getClassLoader();
        try {
            Method defineClass = classLoader.getClass().getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
            defineClass.setAccessible(true);
            try {
                Class clazz = (Class) defineClass.invoke(classLoader, bytes, 0, bytes.length);
                constructor = clazz.getConstructor(Player.class);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
