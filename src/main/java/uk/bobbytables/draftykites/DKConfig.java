package uk.bobbytables.draftykites;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Config(modid = "draftykites")
@Mod.EventBusSubscriber
public class DKConfig {
    @Config.Name("Updraft time (ticks)")
    public static int UPDRAFT_TIME = 40;

    @Config.Name("Time between updrafts (ticks)")
    public static int COOLDOWN = 300;

    @Config.Name("Drafty Biomes")
    public static String[] DRAFTY_BIOMES_RAW = new String[]{"minecraft:void"};

    @Config.Ignore
    public static List<ResourceLocation> DRAFTY_BIOMES = new ArrayList<>();

    @SubscribeEvent
    public static void onConfigChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (!event.getModID().equals("draftykites")) {
            return;
        }
        ConfigManager.sync("draftykites", Config.Type.INSTANCE);

        reloadBiomes();
    }

    @SubscribeEvent
    public static void onWorldLoadEvent(WorldEvent.Load event) {
        reloadBiomes();
    }

    private static void reloadBiomes() {
        Logger logger = LogManager.getLogger();

        DRAFTY_BIOMES.clear();
        for (String possible_resource : DRAFTY_BIOMES_RAW) {
            ResourceLocation resourceLocation = new ResourceLocation(possible_resource);
            if (Biome.REGISTRY.containsKey(resourceLocation)) {
                DRAFTY_BIOMES.add(resourceLocation);
            } else {
                logger.error("No biome found for: {}", possible_resource);
            }
        }
    }
}
