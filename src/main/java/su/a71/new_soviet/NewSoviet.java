package su.a71.new_soviet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewSoviet implements ModInitializer {
    public static final String MOD_ID = "new_soviet";
    public static final String MOD_NAME = "New Soviet Era";
    public static final Logger LOG;
    public static final Gson GSON;

    static {
        LOG = LoggerFactory.getLogger(MOD_NAME);
        GSON = (new GsonBuilder()).setPrettyPrinting().create();
    }

    @Override
    public void onInitialize() {
        NSE_Blocks.init();
        NSE_Items.init();
    }
}