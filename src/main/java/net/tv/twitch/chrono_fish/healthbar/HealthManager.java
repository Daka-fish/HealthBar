package net.tv.twitch.chrono_fish.healthbar;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class HealthManager implements Listener {
    Entity entity;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        entity = e.getEntity();
        if(entity.isDead()) return;
        LivingEntity le = (LivingEntity) entity;
        int currentHealth = (int) (le.getHealth()-e.getDamage());
        setHealthBar(le, currentHealth);
    }

    public void setHealthBar(LivingEntity e, int health){
        int count = 1;
        double maxHealth = e.getMaxHealth();
        double healthRate = (health/maxHealth)*10;

        StringBuilder healthBar = new StringBuilder(ChatColor.GREEN + "|");
        if(health < 1) healthRate = 0;

        for(int i=0; i<10; i++){
            if(count > healthRate){
                healthBar.append(" ");
                continue;
            }
            healthBar.append("■");
            count++;
        }
        healthBar.append("|");

        String hp = " ("+health+"/"+maxHealth+")";
        healthBar.append(hp);
        entity.setCustomName(healthBar.toString());
        entity.setCustomNameVisible(true);

    }
}
