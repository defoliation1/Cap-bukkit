package pers.defoliation.cap;

import engine.command.CommandException;
import engine.command.CommandSender;
import org.bukkit.Server;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;
import java.util.Set;

public class CapCommandSender implements CommandSender, org.bukkit.command.CommandSender {

    private org.bukkit.command.CommandSender bukkitSender;

    public CapCommandSender(org.bukkit.command.CommandSender bukkitSender) {
        this.bukkitSender = bukkitSender;
    }

    @Override
    public String getSenderName() {
        return bukkitSender.getName();
    }

    @Override
    public void sendMessage(String message) {
        bukkitSender.sendMessage(message);
    }

    @Override
    public void sendMessage(String[] messages) {
        bukkitSender.sendMessage(messages);
    }

    @Override
    public Server getServer() {
        return bukkitSender.getServer();
    }

    @Override
    public String getName() {
        return bukkitSender.getName();
    }

    @Override
    public Spigot spigot() {
        return bukkitSender.spigot();
    }

    @Override
    public void sendCommandException(CommandException exception) {
        sendMessage("§4"+exception.getType()+"§r message: "+exception.getMessage());
    }

    @Override
    public boolean isPermissionSet(String name) {
        return bukkitSender.isPermissionSet(name);
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return bukkitSender.isPermissionSet(perm);
    }

    @Override
    public boolean hasPermission(String permission) {
        return bukkitSender.hasPermission(permission);
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return bukkitSender.hasPermission(perm);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return bukkitSender.addAttachment(plugin, name, value);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return bukkitSender.addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return bukkitSender.addAttachment(plugin, name, value, ticks);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return bukkitSender.addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {
        bukkitSender.removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        bukkitSender.recalculatePermissions();
    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return bukkitSender.getEffectivePermissions();
    }

    @Override
    public void setPermission(String permission, boolean bool) {
        throw new NotImplementedException();
    }

    @Override
    public void removePermission(String permission) {
        throw new NotImplementedException();
    }

    @Override
    public void clearPermission() {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Boolean> toPermissionMap() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOp() {
        return bukkitSender.isOp();
    }

    @Override
    public void setOp(boolean value) {
        bukkitSender.setOp(value);
    }
}
