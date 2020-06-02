package uk.bobbytables.draftykites.entity;

import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import thebetweenlands.common.entity.EntityVolarkite;
import uk.bobbytables.draftykites.DKConfig;

public class EntityVolarkiteExt extends EntityVolarkite {

    private int voidTicks = 0;

    public EntityVolarkiteExt(World world) {
        super(world);
        LogManager.getLogger().info("This is my volakite");
    }

    @Override
    protected void updateUpdraft() {
        if (this.voidTicks <= 0 && this.world.getHeight((int) this.posX, (int) this.posZ) == 0) {
            this.updraftTicks = DKConfig.UPDRAFT_TIME;
            this.voidTicks = DKConfig.COOLDOWN_MIN + world.rand.nextInt(DKConfig.COOLDOWN_MAX - DKConfig.COOLDOWN_MIN);
            LogManager.getLogger().info("Adding updraft");
        }
        this.voidTicks--;
        super.updateUpdraft();
    }
}
