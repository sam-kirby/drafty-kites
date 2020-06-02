package uk.bobbytables.draftykites.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.bobbytables.draftykites.DraftyKites;
import uk.bobbytables.draftykites.entity.EntityVolarkiteExt;

public class EntityRegistration {
    public static void onPreInit() {
        EntityRegistry.registerModEntity(
                new ResourceLocation("thebetweenlands", "volarkite"),
                EntityVolarkiteExt.class,
                "thebetweenlands.volarkite",
                0,
                DraftyKites.INSTANCE,
                256,
                20,
                false
        );
    }
}
