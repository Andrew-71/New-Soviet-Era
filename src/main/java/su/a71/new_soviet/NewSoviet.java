package su.a71.new_soviet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.math.random.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import su.a71.new_soviet.registration.NSE_Blocks;
import su.a71.new_soviet.registration.NSE_Combat;
import su.a71.new_soviet.registration.NSE_Custom;
import su.a71.new_soviet.registration.NSE_Items;

public class NewSoviet implements ModInitializer {
    public static final String MOD_ID = "new_soviet";
    public static final String MOD_NAME = "New Soviet Era";
    public static final Logger LOG;
    public static final Gson GSON;
    public static final Random RANDOM;

    static {
        LOG = LoggerFactory.getLogger(MOD_NAME);
        GSON = (new GsonBuilder()).setPrettyPrinting().create();
        RANDOM = Random.create();
    }

    @Override
    public void onInitialize() {
        NSE_Blocks.init();
        NSE_Blocks.initFlame();
        NSE_Items.init();
        NSE_Custom.init();
        NSE_Combat.init();
    }
}