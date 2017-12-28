package de.teamlapen.vampirism.player.vampire.actions;

import de.teamlapen.vampirism.api.entity.player.vampire.DefaultVampireAction;
import de.teamlapen.vampirism.api.entity.player.vampire.IVampirePlayer;
import de.teamlapen.vampirism.config.Balance;
import de.teamlapen.vampirism.core.ModPotions;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;


public class RegenVampireAction extends DefaultVampireAction {

    public RegenVampireAction() {
        super(null);
    }

    @Override
    public int getCooldown() {
        return Balance.vpa.REGEN_COOLDOWN * 0;
    }


    @Override
    public int getMinU() {
        return 80;
    }

    @Override
    public int getMinV() {
        return 0;
    }

    @Override
    public String getUnlocalizedName() {
        return "action.vampirism.vampire.regen";
    }

    @Override
    public boolean isEnabled() {
        return Balance.vpa.REGEN_ENABLED;
    }

    @Override
    public boolean onActivated(IVampirePlayer vampire) {
        EntityPlayer player = vampire.getRepresentingPlayer();
        int dur = Balance.vpa.REGEN_DURATION * 1000000;
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, dur, 255));
        player.addPotionEffect(new PotionEffect(ModPotions.thirst, dur, 2));
        return true;
    }
}
