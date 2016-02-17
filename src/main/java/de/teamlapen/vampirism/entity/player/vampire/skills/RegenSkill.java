package de.teamlapen.vampirism.entity.player.vampire.skills;

import de.teamlapen.vampirism.api.entity.player.vampire.DefaultSkill;
import de.teamlapen.vampirism.api.entity.player.vampire.IVampirePlayer;
import de.teamlapen.vampirism.config.Balance;
import de.teamlapen.vampirism.core.ModPotions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;


public class RegenSkill extends DefaultSkill {

    public RegenSkill() {
        super(null);
    }

    @Override
    public int getMinLevel() {
        return Balance.vps.REGEN_MIN_LEVEL;
    }

    @Override
    public int getCooldown() {
        return Balance.vps.REGEN_COOLDOWN;
    }

    @Override
    public String getUnlocalizedName() {
        return "skill.vampirism.regen";
    }

    @Override
    public boolean onActivated(IVampirePlayer vampire) {
        EntityPlayer player = vampire.getRepresentingPlayer();
        int dur = Balance.vps.REGEN_DURATION * 20;
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, dur, 0));
        player.addPotionEffect(new PotionEffect(ModPotions.thirst.id, dur, 2));
        return true;
    }

    @Override
    public int getMinU() {
        return 80;
    }

    @Override
    public int getMinV() {
        return 0;
    }
}