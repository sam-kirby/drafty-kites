package uk.bobbytables.draftykites.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.bobbytables.draftykites.item.ItemVolarkiteExt;

@Mod.EventBusSubscriber
@GameRegistry.ObjectHolder("draftykites")
public class ItemRegistration {
    @GameRegistry.ObjectHolder("thebetweenlands:volarkite")
    public static final Item VOLARKITE = null;

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void itemRegistration(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(
                new ItemVolarkiteExt()
                        .setRegistryName("thebetweenlands:volarkite")
                        .setTranslationKey("thebetweenlands.volarkite")
        );
    }
}
