package io.github.vertanzil.superiorskyblockprogress;

import com.bgsoftware.superiorskyblock.api.config.SettingsManager;
import com.bgsoftware.superiorskyblock.api.events.*;
import com.bgsoftware.superiorskyblock.api.missions.Mission;
import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Level;

public final class SuperiorSkyBlockProgress extends JavaPlugin implements Listener {
    private BossBar bb;
    private Mission mission = null;

    @Override
    public void onEnable() {
                getLogger().info("SuperiorSkyBlockProgress has been enabled!");
                getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        getLogger().info("SuperiorSkyBlockProgress has been disabled!");
    }

    @EventHandler
    public void ProgressUpdate(PlayerInteractEvent event) {
        if (mission.getIslandMission()) {
            bb = Bukkit.createBossBar(mission.getName(), BarColor.BLUE, BarStyle.SOLID);
            bb.setProgress(mission.getProgress((SuperiorPlayer) event.getPlayer()));
            if (!mission.getName().equalsIgnoreCase(mission.getName())) {
            }
        }
    }

    //Join events
    @EventHandler
    public void onIslandJoin(IslandJoinEvent event) {
        bb.addPlayer((Player) event.getPlayer());
    }

    //QUIT / BAN /  KiCK EVENTS
    @EventHandler
    public void onCompleteMission(MissionCompleteEvent event) {
        bb.removePlayer((Player) event.getPlayer());
    }
    @EventHandler
    public void resetMission(MissionResetEvent event) {
        bb.removePlayer((Player) event.getPlayer());
    }
    @EventHandler
    public void onIslandKick(IslandKickEvent event) {
        bb.removePlayer((Player) event.getPlayer());
    }

    @EventHandler
    public void onIslandBan(IslandBanEvent event) {
        bb.removePlayer((Player) event.getPlayer());
    }
    @EventHandler
    public void onIslandQuit(IslandQuitEvent event) {
        bb.removePlayer((Player) event.getPlayer());
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        bb.removePlayer((Player) event.getPlayer());
    }
    @EventHandler
    public void onplayerKick(PlayerKickEvent event){
        bb.removePlayer((Player) event.getPlayer());
    }

}