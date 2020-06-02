package uk.bobbytables.draftykites;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = "draftykites")
@Mod.EventBusSubscriber
public class DKConfig {
    @Config.Name("Updraft time (ticks)")
    public static int UPDRAFT_TIME = 40;

    @Config.Name("Minimum time between updrafts (ticks)")
    public static int COOLDOWN_MIN = 200;

    @Config.Name("Maximum time between updrafts (ticks)")
    public static int COOLDOWN_MAX = 400;

    @SubscribeEvent
    public static void onConfigChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (!event.getModID().equals("draftykites")) {
            return;
        }
        ConfigManager.sync("draftykites", Config.Type.INSTANCE);
    }
}
