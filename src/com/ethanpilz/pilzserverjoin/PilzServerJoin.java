package com.ethanpilz.pilzserverjoin;

import com.ethanpilz.pilzserverjoin.Listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PilzServerJoin extends JavaPlugin
{
    public static final String pluginName = "PilzServerJoin";
    public static final String pluginVersion = "1.1";
    public static final String chatPrefix = ChatColor.LIGHT_PURPLE + "[PSJ] " + ChatColor.WHITE;
    public static final String consolePrefix = "";
    public static PilzServerJoin instance;
    public static final Logger log = Logger.getLogger("Minecraft");

    public void onEnable()
    {
        //Variables
        this.instance = this;

        //Register Listeners
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);

        PilzServerJoin.log.log(Level.INFO, PilzServerJoin.consolePrefix + "Startup complete!");
    }


}
