package uk.bobbytables.draftykites.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thebetweenlands.common.entity.EntityVolarkite;
import uk.bobbytables.draftykites.DKConfig;

public class EntityVolarkiteExt extends EntityVolarkite {

    private int voidTicks = 0;

    public EntityVolarkiteExt(World world) {
        super(world);
    }

    @Override
    protected void updateUpdraft() {
        if (this.world.getHeight((int) this.posX, (int) this.posZ) == 0
                && DKConfig.DRAFTY_BIOMES.contains(this.world.getBiome(new BlockPos(this.posX, this.posY, this.posZ)).getRegistryName())
        ) {
            if (this.voidTicks <= 0) {
                this.updraftTicks = DKConfig.UPDRAFT_TIME;
                this.voidTicks = DKConfig.COOLDOWN;
            }
            this.voidTicks--;
        }
        super.updateUpdraft();
    }
}
