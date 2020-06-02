package uk.bobbytables.draftykites;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import uk.bobbytables.draftykites.init.EntityRegistration;
import uk.bobbytables.draftykites.init.ItemRegistration;

@Mod(modid = "draftykites", dependencies = "required-before:thebetweenlands@[3.5.0,)")
public class DraftyKites {
    @Mod.Instance
    public static DraftyKites INSTANCE;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        EntityRegistration.onPreInit();
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        LogManager.getLogger().info("Class of registered volarkite is: {}", ItemRegistration.VOLARKITE.getClass());
    }
}
