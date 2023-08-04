package su.a71.new_soviet;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import su.a71.new_soviet.registration.NSE_Blocks;
import su.a71.new_soviet.registration.NSE_Custom;

@Environment(EnvType.CLIENT)
public class NewSovietClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(NSE_Blocks.CRATE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NSE_Custom.LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NSE_Custom.CEILING_FAN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(NSE_Custom.SIREN, RenderLayer.getCutout());
    }
}