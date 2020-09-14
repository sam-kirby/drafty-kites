package uk.bobbytables.draftykites.entity;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import thebetweenlands.common.entity.EntityVolarkite;
import twilightforest.TFFeature;
import uk.bobbytables.draftykites.DKConfig;

public class EntityVolarkiteExt extends EntityVolarkite {

    private int voidTicks = 0;
    private boolean nearProtectedStructure = false;

    public EntityVolarkiteExt(World world) {
        super(world);
    }

    @Override
    protected void updateUpdraft() {
        if (this.dimension == 7) {
            double distanceToNearestStructure = TFFeature.getNearestCenterXYZ(this.chunkCoordX, this.chunkCoordZ, this.world).distanceSq(this.getPosition());
            if (!nearProtectedStructure && distanceToNearestStructure < 4096) {
                this.nearProtectedStructure = true;
                if (this.getControllingPassenger() instanceof EntityPlayerMP) {
                    EntityPlayerMP player = (EntityPlayerMP) this.getControllingPassenger();
                    player.sendMessage(new TextComponentTranslation("draftykites.structurewarning"));
                }
            } else if (this.dimension == 7 && nearProtectedStructure && distanceToNearestStructure > 4096) {
                nearProtectedStructure = false;
            }
        }

        if (this.world.getHeight((int) this.posX, (int) this.posZ) == 0
                && (DKConfig.DRAFTY_BIOMES.contains(this.world.getBiome(new BlockPos(this.posX, this.posY, this.posZ)).getRegistryName())
                || this.dimension == 7 && !nearProtectedStructure)
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
