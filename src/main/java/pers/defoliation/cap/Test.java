package pers.defoliation.cap;

import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.command.CommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.*;

public class Test extends CapCommandSender implements Player {

    public Player player;

    public Test(final Player player) {
        super((CommandSender) player);
        this.player = player;
    }

    public String getDisplayName() {
        return this.player.getDisplayName();
    }

    public void setDisplayName(final String displayName) {
        this.player.setDisplayName(displayName);
    }

    public String getPlayerListName() {
        return this.player.getPlayerListName();
    }

    public void setPlayerListName(final String playerListName) {
        this.player.setPlayerListName(playerListName);
    }

    public void setCompassTarget(final Location compassTarget) {
        this.player.setCompassTarget(compassTarget);
    }

    public Location getCompassTarget() {
        return this.player.getCompassTarget();
    }

    public InetSocketAddress getAddress() {
        return this.player.getAddress();
    }

    public void sendRawMessage(final String s) {
        this.player.sendRawMessage(s);
    }

    public void kickPlayer(final String s) {
        this.player.kickPlayer(s);
    }

    public void chat(final String s) {
        this.player.chat(s);
    }

    public boolean performCommand(final String s) {
        return this.player.performCommand(s);
    }

    public boolean isSneaking() {
        return this.player.isSneaking();
    }

    public void setSneaking(final boolean sneaking) {
        this.player.setSneaking(sneaking);
    }

    public boolean isSprinting() {
        return this.player.isSprinting();
    }

    public void setSprinting(final boolean sprinting) {
        this.player.setSprinting(sprinting);
    }

    public void saveData() {
        this.player.saveData();
    }

    public void loadData() {
        this.player.loadData();
    }

    public void setSleepingIgnored(final boolean sleepingIgnored) {
        this.player.setSleepingIgnored(sleepingIgnored);
    }

    public boolean isSleepingIgnored() {
        return this.player.isSleepingIgnored();
    }

    public void playNote(final Location location, final byte b, final byte b2) {
        this.player.playNote(location, b, b2);
    }

    public void playNote(final Location location, final Instrument instrument, final Note note) {
        this.player.playNote(location, instrument, note);
    }

    public void playSound(final Location location, final Sound sound, final float n, final float n2) {
        this.player.playSound(location, sound, n, n2);
    }

    public void playSound(final Location location, final String s, final float n, final float n2) {
        this.player.playSound(location, s, n, n2);
    }

    public void playSound(final Location location, final Sound sound, final SoundCategory soundCategory, final float n, final float n2) {
        this.player.playSound(location, sound, soundCategory, n, n2);
    }

    public void playSound(final Location location, final String s, final SoundCategory soundCategory, final float n, final float n2) {
        this.player.playSound(location, s, soundCategory, n, n2);
    }

    public void stopSound(final Sound sound) {
        this.player.stopSound(sound);
    }

    public void stopSound(final String s) {
        this.player.stopSound(s);
    }

    public void stopSound(final Sound sound, final SoundCategory soundCategory) {
        this.player.stopSound(sound, soundCategory);
    }

    public void stopSound(final String s, final SoundCategory soundCategory) {
        this.player.stopSound(s, soundCategory);
    }

    public void playEffect(final Location location, final Effect effect, final int n) {
        this.player.playEffect(location, effect, n);
    }

    public <T> void playEffect(final Location location, final Effect effect, final T t) {
        this.player.playEffect(location, effect, (Object) t);
    }

    public void sendBlockChange(final Location location, final Material material, final byte b) {
        this.player.sendBlockChange(location, material, b);
    }

    public boolean sendChunkChange(final Location location, final int n, final int n2, final int n3, final byte[] array) {
        return this.player.sendChunkChange(location, n, n2, n3, array);
    }

    public void sendBlockChange(final Location location, final int n, final byte b) {
        this.player.sendBlockChange(location, n, b);
    }

    public void sendSignChange(final Location location, final String[] array) throws IllegalArgumentException {
        this.player.sendSignChange(location, array);
    }

    public void sendMap(final MapView mapView) {
        this.player.sendMap(mapView);
    }

    public void updateInventory() {
        this.player.updateInventory();
    }

    public void awardAchievement(final Achievement achievement) {
        this.player.awardAchievement(achievement);
    }

    public void removeAchievement(final Achievement achievement) {
        this.player.removeAchievement(achievement);
    }

    public boolean hasAchievement(final Achievement achievement) {
        return this.player.hasAchievement(achievement);
    }

    public void incrementStatistic(final Statistic statistic) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic);
    }

    public void decrementStatistic(final Statistic statistic) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic);
    }

    public void incrementStatistic(final Statistic statistic, final int n) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, n);
    }

    public void decrementStatistic(final Statistic statistic, final int n) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, n);
    }

    public void setStatistic(final Statistic statistic, final int n) throws IllegalArgumentException {
        this.player.setStatistic(statistic, n);
    }

    public int getStatistic(final Statistic statistic) throws IllegalArgumentException {
        return this.player.getStatistic(statistic);
    }

    public void incrementStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, material);
    }

    public void decrementStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, material);
    }

    public int getStatistic(final Statistic statistic, final Material material) throws IllegalArgumentException {
        return this.player.getStatistic(statistic, material);
    }

    public void incrementStatistic(final Statistic statistic, final Material material, final int n) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, material, n);
    }

    public void decrementStatistic(final Statistic statistic, final Material material, final int n) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, material, n);
    }

    public void setStatistic(final Statistic statistic, final Material material, final int n) throws IllegalArgumentException {
        this.player.setStatistic(statistic, material, n);
    }

    public void incrementStatistic(final Statistic statistic, final EntityType entityType) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, entityType);
    }

    public void decrementStatistic(final Statistic statistic, final EntityType entityType) throws IllegalArgumentException {
        this.player.decrementStatistic(statistic, entityType);
    }

    public int getStatistic(final Statistic statistic, final EntityType entityType) throws IllegalArgumentException {
        return this.player.getStatistic(statistic, entityType);
    }

    public void incrementStatistic(final Statistic statistic, final EntityType entityType, final int n) throws IllegalArgumentException {
        this.player.incrementStatistic(statistic, entityType, n);
    }

    public void decrementStatistic(final Statistic statistic, final EntityType entityType, final int n) {
        this.player.decrementStatistic(statistic, entityType, n);
    }

    public void setStatistic(final Statistic statistic, final EntityType entityType, final int n) {
        this.player.setStatistic(statistic, entityType, n);
    }

    public void setPlayerTime(final long n, final boolean b) {
        this.player.setPlayerTime(n, b);
    }

    public long getPlayerTime() {
        return this.player.getPlayerTime();
    }

    public long getPlayerTimeOffset() {
        return this.player.getPlayerTimeOffset();
    }

    public boolean isPlayerTimeRelative() {
        return this.player.isPlayerTimeRelative();
    }

    public void resetPlayerTime() {
        this.player.resetPlayerTime();
    }

    public void setPlayerWeather(final WeatherType playerWeather) {
        this.player.setPlayerWeather(playerWeather);
    }

    public WeatherType getPlayerWeather() {
        return this.player.getPlayerWeather();
    }

    public void resetPlayerWeather() {
        this.player.resetPlayerWeather();
    }

    public void giveExp(final int n) {
        this.player.giveExp(n);
    }

    public void giveExpLevels(final int n) {
        this.player.giveExpLevels(n);
    }

    public float getExp() {
        return this.player.getExp();
    }

    public void setExp(final float exp) {
        this.player.setExp(exp);
    }

    public int getLevel() {
        return this.player.getLevel();
    }

    public void setLevel(final int level) {
        this.player.setLevel(level);
    }

    public int getTotalExperience() {
        return this.player.getTotalExperience();
    }

    public void setTotalExperience(final int totalExperience) {
        this.player.setTotalExperience(totalExperience);
    }

    public float getExhaustion() {
        return this.player.getExhaustion();
    }

    public void setExhaustion(final float exhaustion) {
        this.player.setExhaustion(exhaustion);
    }

    public float getSaturation() {
        return this.player.getSaturation();
    }

    public void setSaturation(final float saturation) {
        this.player.setSaturation(saturation);
    }

    public int getFoodLevel() {
        return this.player.getFoodLevel();
    }

    public void setFoodLevel(final int foodLevel) {
        this.player.setFoodLevel(foodLevel);
    }

    public Location getBedSpawnLocation() {
        return this.player.getBedSpawnLocation();
    }

    public void setBedSpawnLocation(final Location bedSpawnLocation) {
        this.player.setBedSpawnLocation(bedSpawnLocation);
    }

    public void setBedSpawnLocation(final Location location, final boolean b) {
        this.player.setBedSpawnLocation(location, b);
    }

    public boolean getAllowFlight() {
        return this.player.getAllowFlight();
    }

    public void setAllowFlight(final boolean allowFlight) {
        this.player.setAllowFlight(allowFlight);
    }

    public void hidePlayer(final Player player) {
        this.player.hidePlayer(player);
    }

    public void hidePlayer(final Plugin plugin, final Player player) {
        this.player.hidePlayer(plugin, player);
    }

    public void showPlayer(final Player player) {
        this.player.showPlayer(player);
    }

    public void showPlayer(final Plugin plugin, final Player player) {
        this.player.showPlayer(plugin, player);
    }

    public boolean canSee(final Player player) {
        return this.player.canSee(player);
    }

    public boolean isFlying() {
        return this.player.isFlying();
    }

    public void setFlying(final boolean flying) {
        this.player.setFlying(flying);
    }

    public void setFlySpeed(final float flySpeed) throws IllegalArgumentException {
        this.player.setFlySpeed(flySpeed);
    }

    public void setWalkSpeed(final float walkSpeed) throws IllegalArgumentException {
        this.player.setWalkSpeed(walkSpeed);
    }

    public float getFlySpeed() {
        return this.player.getFlySpeed();
    }

    public float getWalkSpeed() {
        return this.player.getWalkSpeed();
    }

    public void setTexturePack(final String texturePack) {
        this.player.setTexturePack(texturePack);
    }

    public void setResourcePack(final String resourcePack) {
        this.player.setResourcePack(resourcePack);
    }

    public void setResourcePack(final String s, final byte[] array) {
        this.player.setResourcePack(s, array);
    }

    public Scoreboard getScoreboard() {
        return this.player.getScoreboard();
    }

    public void setScoreboard(final Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        this.player.setScoreboard(scoreboard);
    }

    public boolean isHealthScaled() {
        return this.player.isHealthScaled();
    }

    public void setHealthScaled(final boolean healthScaled) {
        this.player.setHealthScaled(healthScaled);
    }

    public void setHealthScale(final double healthScale) throws IllegalArgumentException {
        this.player.setHealthScale(healthScale);
    }

    public double getHealthScale() {
        return this.player.getHealthScale();
    }

    public Entity getSpectatorTarget() {
        return this.player.getSpectatorTarget();
    }

    public void setSpectatorTarget(final Entity spectatorTarget) {
        this.player.setSpectatorTarget(spectatorTarget);
    }

    public void sendTitle(final String s, final String s2) {
        this.player.sendTitle(s, s2);
    }

    public void sendTitle(final String s, final String s2, final int n, final int n2, final int n3) {
        this.player.sendTitle(s, s2, n, n2, n3);
    }

    public void resetTitle() {
        this.player.resetTitle();
    }

    public void spawnParticle(final Particle particle, final Location location, final int n) {
        this.player.spawnParticle(particle, location, n);
    }

    public void spawnParticle(final Particle particle, final double n, final double n2, final double n3, final int n4) {
        this.player.spawnParticle(particle, n, n2, n3, n4);
    }

    public <T> void spawnParticle(final Particle particle, final Location location, final int n, final T t) {
        this.player.spawnParticle(particle, location, n, (Object) t);
    }

    public <T> void spawnParticle(final Particle particle, final double n, final double n2, final double n3, final int n4, final T t) {
        this.player.spawnParticle(particle, n, n2, n3, n4, (Object) t);
    }

    public void spawnParticle(final Particle particle, final Location location, final int n, final double n2, final double n3, final double n4) {
        this.player.spawnParticle(particle, location, n, n2, n3, n4);
    }

    public void spawnParticle(final Particle particle, final double n, final double n2, final double n3, final int n4, final double n5, final double n6, final double n7) {
        this.player.spawnParticle(particle, n, n2, n3, n4, n5, n6, n7);
    }

    public <T> void spawnParticle(final Particle particle, final Location location, final int n, final double n2, final double n3, final double n4, final T t) {
        this.player.spawnParticle(particle, location, n, n2, n3, n4, (Object) t);
    }

    public <T> void spawnParticle(final Particle particle, final double n, final double n2, final double n3, final int n4, final double n5, final double n6, final double n7, final T t) {
        this.player.spawnParticle(particle, n, n2, n3, n4, n5, n6, n7, (Object) t);
    }

    public void spawnParticle(final Particle particle, final Location location, final int n, final double n2, final double n3, final double n4, final double n5) {
        this.player.spawnParticle(particle, location, n, n2, n3, n4, n5);
    }

    public void spawnParticle(final Particle particle, final double n, final double n2, final double n3, final int n4, final double n5, final double n6, final double n7, final double n8) {
        this.player.spawnParticle(particle, n, n2, n3, n4, n5, n6, n7, n8);
    }

    public <T> void spawnParticle(final Particle particle, final Location location, final int n, final double n2, final double n3, final double n4, final double n5, final T t) {
        this.player.spawnParticle(particle, location, n, n2, n3, n4, n5, (Object) t);
    }

    public <T> void spawnParticle(final Particle particle, final double n, final double n2, final double n3, final int n4, final double n5, final double n6, final double n7, final double n8, final T t) {
        this.player.spawnParticle(particle, n, n2, n3, n4, n5, n6, n7, n8, (Object) t);
    }

    public AdvancementProgress getAdvancementProgress(final Advancement advancement) {
        return this.player.getAdvancementProgress(advancement);
    }

    public String getLocale() {
        return this.player.getLocale();
    }

    public Player.Spigot spigot() {
        return this.player.spigot();
    }

    public String getName() {
        return this.player.getName();
    }

    public PlayerInventory getInventory() {
        return this.player.getInventory();
    }

    public Inventory getEnderChest() {
        return this.player.getEnderChest();
    }

    public MainHand getMainHand() {
        return this.player.getMainHand();
    }

    public boolean setWindowProperty(final InventoryView.Property inventoryView$Property, final int n) {
        return this.player.setWindowProperty(inventoryView$Property, n);
    }

    public InventoryView getOpenInventory() {
        return this.player.getOpenInventory();
    }

    public InventoryView openInventory(final Inventory inventory) {
        return this.player.openInventory(inventory);
    }

    public InventoryView openWorkbench(final Location location, final boolean b) {
        return this.player.openWorkbench(location, b);
    }

    public InventoryView openEnchanting(final Location location, final boolean b) {
        return this.player.openEnchanting(location, b);
    }

    public void openInventory(final InventoryView inventoryView) {
        this.player.openInventory(inventoryView);
    }

    public InventoryView openMerchant(final Villager villager, final boolean b) {
        return this.player.openMerchant(villager, b);
    }

    public InventoryView openMerchant(final Merchant merchant, final boolean b) {
        return this.player.openMerchant(merchant, b);
    }

    public void closeInventory() {
        this.player.closeInventory();
    }

    public ItemStack getItemInHand() {
        return this.player.getItemInHand();
    }

    public void setItemInHand(final ItemStack itemInHand) {
        this.player.setItemInHand(itemInHand);
    }

    public ItemStack getItemOnCursor() {
        return this.player.getItemOnCursor();
    }

    public void setItemOnCursor(final ItemStack itemOnCursor) {
        this.player.setItemOnCursor(itemOnCursor);
    }

    public boolean hasCooldown(final Material material) {
        return this.player.hasCooldown(material);
    }

    public int getCooldown(final Material material) {
        return this.player.getCooldown(material);
    }

    public void setCooldown(final Material material, final int n) {
        this.player.setCooldown(material, n);
    }

    public boolean isSleeping() {
        return this.player.isSleeping();
    }

    public int getSleepTicks() {
        return this.player.getSleepTicks();
    }

    public GameMode getGameMode() {
        return this.player.getGameMode();
    }

    public void setGameMode(final GameMode gameMode) {
        this.player.setGameMode(gameMode);
    }

    public boolean isBlocking() {
        return this.player.isBlocking();
    }

    public boolean isHandRaised() {
        return this.player.isHandRaised();
    }

    public int getExpToLevel() {
        return this.player.getExpToLevel();
    }

    public Entity getShoulderEntityLeft() {
        return this.player.getShoulderEntityLeft();
    }

    public void setShoulderEntityLeft(final Entity shoulderEntityLeft) {
        this.player.setShoulderEntityLeft(shoulderEntityLeft);
    }

    public Entity getShoulderEntityRight() {
        return this.player.getShoulderEntityRight();
    }

    public void setShoulderEntityRight(final Entity shoulderEntityRight) {
        this.player.setShoulderEntityRight(shoulderEntityRight);
    }

    public double getEyeHeight() {
        return this.player.getEyeHeight();
    }

    public double getEyeHeight(final boolean b) {
        return this.player.getEyeHeight(b);
    }

    public Location getEyeLocation() {
        return this.player.getEyeLocation();
    }

    public List<Block> getLineOfSight(final Set<Material> set, final int n) {
        return (List<Block>) this.player.getLineOfSight((Set) set, n);
    }

    public Block getTargetBlock(final Set<Material> set, final int n) {
        return this.player.getTargetBlock((Set) set, n);
    }

    public List<Block> getLastTwoTargetBlocks(final Set<Material> set, final int n) {
        return (List<Block>) this.player.getLastTwoTargetBlocks((Set) set, n);
    }

    public int getRemainingAir() {
        return this.player.getRemainingAir();
    }

    public void setRemainingAir(final int remainingAir) {
        this.player.setRemainingAir(remainingAir);
    }

    public int getMaximumAir() {
        return this.player.getMaximumAir();
    }

    public void setMaximumAir(final int maximumAir) {
        this.player.setMaximumAir(maximumAir);
    }

    public int getMaximumNoDamageTicks() {
        return this.player.getMaximumNoDamageTicks();
    }

    public void setMaximumNoDamageTicks(final int maximumNoDamageTicks) {
        this.player.setMaximumNoDamageTicks(maximumNoDamageTicks);
    }

    public double getLastDamage() {
        return this.player.getLastDamage();
    }

    public void setLastDamage(final double lastDamage) {
        this.player.setLastDamage(lastDamage);
    }

    public int getNoDamageTicks() {
        return this.player.getNoDamageTicks();
    }

    public void setNoDamageTicks(final int noDamageTicks) {
        this.player.setNoDamageTicks(noDamageTicks);
    }

    public Player getKiller() {
        return this.player.getKiller();
    }

    public boolean addPotionEffect(final PotionEffect potionEffect) {
        return this.player.addPotionEffect(potionEffect);
    }

    public boolean addPotionEffect(final PotionEffect potionEffect, final boolean b) {
        return this.player.addPotionEffect(potionEffect, b);
    }

    public boolean addPotionEffects(final Collection<PotionEffect> collection) {
        return this.player.addPotionEffects((Collection) collection);
    }

    public boolean hasPotionEffect(final PotionEffectType potionEffectType) {
        return this.player.hasPotionEffect(potionEffectType);
    }

    public PotionEffect getPotionEffect(final PotionEffectType potionEffectType) {
        return this.player.getPotionEffect(potionEffectType);
    }

    public void removePotionEffect(final PotionEffectType potionEffectType) {
        this.player.removePotionEffect(potionEffectType);
    }

    public Collection<PotionEffect> getActivePotionEffects() {
        return (Collection<PotionEffect>) this.player.getActivePotionEffects();
    }

    public boolean hasLineOfSight(final Entity entity) {
        return this.player.hasLineOfSight(entity);
    }

    public boolean getRemoveWhenFarAway() {
        return this.player.getRemoveWhenFarAway();
    }

    public void setRemoveWhenFarAway(final boolean removeWhenFarAway) {
        this.player.setRemoveWhenFarAway(removeWhenFarAway);
    }

    public EntityEquipment getEquipment() {
        return this.player.getEquipment();
    }

    public void setCanPickupItems(final boolean canPickupItems) {
        this.player.setCanPickupItems(canPickupItems);
    }

    public boolean getCanPickupItems() {
        return this.player.getCanPickupItems();
    }

    public boolean isLeashed() {
        return this.player.isLeashed();
    }

    public Entity getLeashHolder() throws IllegalStateException {
        return this.player.getLeashHolder();
    }

    public boolean setLeashHolder(final Entity leashHolder) {
        return this.player.setLeashHolder(leashHolder);
    }

    public boolean isGliding() {
        return this.player.isGliding();
    }

    public void setGliding(final boolean gliding) {
        this.player.setGliding(gliding);
    }

    public void setAI(final boolean ai) {
        this.player.setAI(ai);
    }

    public boolean hasAI() {
        return this.player.hasAI();
    }

    public void setCollidable(final boolean collidable) {
        this.player.setCollidable(collidable);
    }

    public boolean isCollidable() {
        return this.player.isCollidable();
    }

    public AttributeInstance getAttribute(final Attribute attribute) {
        return this.player.getAttribute(attribute);
    }

    public Location getLocation() {
        return this.player.getLocation();
    }

    public Location getLocation(final Location location) {
        return this.player.getLocation(location);
    }

    public void setVelocity(final Vector velocity) {
        this.player.setVelocity(velocity);
    }

    public Vector getVelocity() {
        return this.player.getVelocity();
    }

    public double getHeight() {
        return this.player.getHeight();
    }

    public double getWidth() {
        return this.player.getWidth();
    }

    public boolean isOnGround() {
        return this.player.isOnGround();
    }

    public World getWorld() {
        return this.player.getWorld();
    }

    public boolean teleport(final Location location) {
        return this.player.teleport(location);
    }

    public boolean teleport(final Location location, final PlayerTeleportEvent.TeleportCause playerTeleportEvent$TeleportCause) {
        return this.player.teleport(location, playerTeleportEvent$TeleportCause);
    }

    public boolean teleport(final Entity entity) {
        return this.player.teleport(entity);
    }

    public boolean teleport(final Entity entity, final PlayerTeleportEvent.TeleportCause playerTeleportEvent$TeleportCause) {
        return this.player.teleport(entity, playerTeleportEvent$TeleportCause);
    }

    public List<Entity> getNearbyEntities(final double n, final double n2, final double n3) {
        return (List<Entity>) this.player.getNearbyEntities(n, n2, n3);
    }

    public int getEntityId() {
        return this.player.getEntityId();
    }

    public int getFireTicks() {
        return this.player.getFireTicks();
    }

    public int getMaxFireTicks() {
        return this.player.getMaxFireTicks();
    }

    public void setFireTicks(final int fireTicks) {
        this.player.setFireTicks(fireTicks);
    }

    public void remove() {
        this.player.remove();
    }

    public boolean isDead() {
        return this.player.isDead();
    }

    public boolean isValid() {
        return this.player.isValid();
    }

    public Server getServer() {
        return this.player.getServer();
    }

    public Entity getPassenger() {
        return this.player.getPassenger();
    }

    public boolean setPassenger(final Entity passenger) {
        return this.player.setPassenger(passenger);
    }

    public List<Entity> getPassengers() {
        return (List<Entity>) this.player.getPassengers();
    }

    public boolean addPassenger(final Entity entity) {
        return this.player.addPassenger(entity);
    }

    public boolean removePassenger(final Entity entity) {
        return this.player.removePassenger(entity);
    }

    public boolean isEmpty() {
        return this.player.isEmpty();
    }

    public boolean eject() {
        return this.player.eject();
    }

    public float getFallDistance() {
        return this.player.getFallDistance();
    }

    public void setFallDistance(final float fallDistance) {
        this.player.setFallDistance(fallDistance);
    }

    public void setLastDamageCause(final EntityDamageEvent lastDamageCause) {
        this.player.setLastDamageCause(lastDamageCause);
    }

    public EntityDamageEvent getLastDamageCause() {
        return this.player.getLastDamageCause();
    }

    public UUID getUniqueId() {
        return this.player.getUniqueId();
    }

    public int getTicksLived() {
        return this.player.getTicksLived();
    }

    public void setTicksLived(final int ticksLived) {
        this.player.setTicksLived(ticksLived);
    }

    public void playEffect(final EntityEffect entityEffect) {
        this.player.playEffect(entityEffect);
    }

    public EntityType getType() {
        return this.player.getType();
    }

    public boolean isInsideVehicle() {
        return this.player.isInsideVehicle();
    }

    public boolean leaveVehicle() {
        return this.player.leaveVehicle();
    }

    public Entity getVehicle() {
        return this.player.getVehicle();
    }

    public void setCustomNameVisible(final boolean customNameVisible) {
        this.player.setCustomNameVisible(customNameVisible);
    }

    public boolean isCustomNameVisible() {
        return this.player.isCustomNameVisible();
    }

    public void setGlowing(final boolean glowing) {
        this.player.setGlowing(glowing);
    }

    public boolean isGlowing() {
        return this.player.isGlowing();
    }

    public void setInvulnerable(final boolean invulnerable) {
        this.player.setInvulnerable(invulnerable);
    }

    public boolean isInvulnerable() {
        return this.player.isInvulnerable();
    }

    public boolean isSilent() {
        return this.player.isSilent();
    }

    public void setSilent(final boolean silent) {
        this.player.setSilent(silent);
    }

    public boolean hasGravity() {
        return this.player.hasGravity();
    }

    public void setGravity(final boolean gravity) {
        this.player.setGravity(gravity);
    }

    public int getPortalCooldown() {
        return this.player.getPortalCooldown();
    }

    public void setPortalCooldown(final int portalCooldown) {
        this.player.setPortalCooldown(portalCooldown);
    }

    public Set<String> getScoreboardTags() {
        return (Set<String>) this.player.getScoreboardTags();
    }

    public boolean addScoreboardTag(final String s) {
        return this.player.addScoreboardTag(s);
    }

    public boolean removeScoreboardTag(final String s) {
        return this.player.removeScoreboardTag(s);
    }

    public PistonMoveReaction getPistonMoveReaction() {
        return this.player.getPistonMoveReaction();
    }

    public void setMetadata(final String s, final MetadataValue metadataValue) {
        this.player.setMetadata(s, metadataValue);
    }

    public List<MetadataValue> getMetadata(final String s) {
        return (List<MetadataValue>) this.player.getMetadata(s);
    }

    public boolean hasMetadata(final String s) {
        return this.player.hasMetadata(s);
    }

    public void removeMetadata(final String s, final Plugin plugin) {
        this.player.removeMetadata(s, plugin);
    }

    public void sendMessage(final String s) {
        this.player.sendMessage(s);
    }

    public void sendMessage(final String[] array) {
        this.player.sendMessage(array);
    }

    public boolean isPermissionSet(final String s) {
        return this.player.isPermissionSet(s);
    }

    public boolean isPermissionSet(final Permission permission) {
        return this.player.isPermissionSet(permission);
    }

    public boolean hasPermission(final String s) {
        return this.player.hasPermission(s);
    }

    public boolean hasPermission(final Permission permission) {
        return this.player.hasPermission(permission);
    }

    public PermissionAttachment addAttachment(final Plugin plugin, final String s, final boolean b) {
        return this.player.addAttachment(plugin, s, b);
    }

    public PermissionAttachment addAttachment(final Plugin plugin) {
        return this.player.addAttachment(plugin);
    }

    public PermissionAttachment addAttachment(final Plugin plugin, final String s, final boolean b, final int n) {
        return this.player.addAttachment(plugin, s, b, n);
    }

    public PermissionAttachment addAttachment(final Plugin plugin, final int n) {
        return this.player.addAttachment(plugin, n);
    }

    public void removeAttachment(final PermissionAttachment permissionAttachment) {
        this.player.removeAttachment(permissionAttachment);
    }

    public void recalculatePermissions() {
        this.player.recalculatePermissions();
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return (Set<PermissionAttachmentInfo>) this.player.getEffectivePermissions();
    }

    public boolean isOp() {
        return this.player.isOp();
    }

    public void setOp(final boolean op) {
        this.player.setOp(op);
    }

    public String getCustomName() {
        return this.player.getCustomName();
    }

    public void setCustomName(final String customName) {
        this.player.setCustomName(customName);
    }

    public void damage(final double n) {
        this.player.damage(n);
    }

    public void damage(final double n, final Entity entity) {
        this.player.damage(n, entity);
    }

    public double getHealth() {
        return this.player.getHealth();
    }

    public void setHealth(final double health) {
        this.player.setHealth(health);
    }

    public double getMaxHealth() {
        return this.player.getMaxHealth();
    }

    public void setMaxHealth(final double maxHealth) {
        this.player.setMaxHealth(maxHealth);
    }

    public void resetMaxHealth() {
        this.player.resetMaxHealth();
    }

    public <T extends Projectile> T launchProjectile(final Class<? extends T> clazz) {
        return (T) this.player.launchProjectile((Class) clazz);
    }

    public <T extends Projectile> T launchProjectile(final Class<? extends T> clazz, final Vector vector) {
        return (T) this.player.launchProjectile((Class) clazz, vector);
    }

    public boolean isConversing() {
        return this.player.isConversing();
    }

    public void acceptConversationInput(final String s) {
        this.player.acceptConversationInput(s);
    }

    public boolean beginConversation(final Conversation conversation) {
        return this.player.beginConversation(conversation);
    }

    public void abandonConversation(final Conversation conversation) {
        this.player.abandonConversation(conversation);
    }

    public void abandonConversation(final Conversation conversation, final ConversationAbandonedEvent conversationAbandonedEvent) {
        this.player.abandonConversation(conversation, conversationAbandonedEvent);
    }

    public boolean isOnline() {
        return this.player.isOnline();
    }

    public boolean isBanned() {
        return this.player.isBanned();
    }

    public boolean isWhitelisted() {
        return this.player.isWhitelisted();
    }

    public void setWhitelisted(final boolean whitelisted) {
        this.player.setWhitelisted(whitelisted);
    }

    public Player getPlayer() {
        return this.player.getPlayer();
    }

    public long getFirstPlayed() {
        return this.player.getFirstPlayed();
    }

    public long getLastPlayed() {
        return this.player.getLastPlayed();
    }

    public boolean hasPlayedBefore() {
        return this.player.hasPlayedBefore();
    }

    public Map<String, Object> serialize() {
        return (Map<String, Object>) this.player.serialize();
    }

    public void sendPluginMessage(final Plugin plugin, final String s, final byte[] array) {
        this.player.sendPluginMessage(plugin, s, array);
    }

    public Set<String> getListeningPluginChannels() {
        return (Set<String>) this.player.getListeningPluginChannels();
    }

    public static Player getSender(Player player) {
        return new Test(player);
    }

}
