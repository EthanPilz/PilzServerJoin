package com.ethanpilz.pilzserverjoin.Listener;

import com.ethanpilz.pilzserverjoin.PilzServerJoin;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

/**
 * Created by austinpilz on 8/22/16.
 */
public class PlayerListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent pje) {
        Player p = pje.getPlayer();
        if (p.hasPermission("psj.firework")) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PilzServerJoin.instance, new Runnable() {
                public void run() {
                    Firework f = (Firework) pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);

                    FireworkMeta fm = f.getFireworkMeta();
                    fm.addEffect(FireworkEffect.builder()
                            .flicker(true)
                            .trail(true)
                            .with(FireworkEffect.Type.BURST)
                            .with(FireworkEffect.Type.BALL_LARGE)
                            .withColor(Color.AQUA)
                            .withColor(Color.GREEN)
                            .withFade(Color.PURPLE)
                            .withFade(Color.RED)
                            .withColor(Color.SILVER)
                            .build());
                    fm.setPower(1);
                    f.setFireworkMeta(fm);
                }
            }, 20L);
        }
    }
}
