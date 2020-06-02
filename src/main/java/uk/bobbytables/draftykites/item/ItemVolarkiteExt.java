package uk.bobbytables.draftykites.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import thebetweenlands.common.item.misc.ItemVolarkite;
import uk.bobbytables.draftykites.entity.EntityVolarkiteExt;

public class ItemVolarkiteExt extends ItemVolarkite {
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {
            if (!player.isRiding() && player.getRecursivePassengersByType(EntityVolarkiteExt.class).isEmpty()) {
                EntityVolarkiteExt entity = new EntityVolarkiteExt(world);
                entity.setLocationAndAngles(player.posX, player.posY, player.posZ, player.rotationYaw, 0);
                entity.motionX = player.motionX;
                entity.motionY = player.motionY;
                entity.motionZ = player.motionZ;
                entity.velocityChanged = true;

                world.spawnEntity(entity);

                player.startRiding(entity);

                world.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, SoundCategory.PLAYERS, 1, 1);
            }
        }

        return new ActionResult<>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }
}
