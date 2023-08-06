package su.a71.new_soviet.registration;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.util.Rarity;
import su.a71.new_soviet.NewSoviet;
import su.a71.new_soviet.items.DiceD20Item;
import su.a71.new_soviet.items.DiceD4Item;
import su.a71.new_soviet.items.DiceItem;

public class NSE_Items {
    // Like an iron axe but a hoe and slightly faster (-2.8f vs -3.1f) and a bit weaker (6 vs 6.5 damage)
    public static final ToolItem SICKLE = new HoeItem(ToolMaterials.IRON, 6, -2.8F, new Item.Settings());

    public static final FoodComponent COCONUT_FC = (new FoodComponent.Builder()).hunger(4).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0), 1.0F).alwaysEdible().build();
    public static final Item COCONUT = new Item(new Item.Settings().food(COCONUT_FC).rarity(Rarity.EPIC));

    public static final DiceItem DICE_D6 = new DiceItem(new Item.Settings().maxCount(6));
    public static final DiceD4Item DICE_D4 = new DiceD4Item(new Item.Settings().maxCount(6));
    public static final DiceD20Item DICE_D20 = new DiceD20Item(new Item.Settings().maxCount(6));
    public static final SoundEvent DICE_SOUND = SoundEvent.of(new Identifier("new_soviet", "dice_sound"));

    public static final Item LIGHT_BULB = new Item(new Item.Settings());

    private static final ItemGroup NSE_ITEMS_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SICKLE))
            .displayName(Text.translatable("itemGroup.new_soviet.items"))
            .build();

    private static void register(String name, Supplier<? extends Item> supplier, ItemGroup tab)
    {
        Registry.register(Registries.ITEM, new Identifier(NewSoviet.MOD_ID, name), supplier.get());

        Optional<RegistryKey<ItemGroup>> key = Registries.ITEM_GROUP.getKey(tab);
        key.ifPresent(itemGroupRegistryKey -> ItemGroupEvents.modifyEntriesEvent(itemGroupRegistryKey).register(content -> {
            content.add(supplier.get());
        }));
    }

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("new_soviet", "items"), NSE_ITEMS_TAB);
        register("sickle", () -> SICKLE, NSE_ITEMS_TAB);
        register("coconut", () -> COCONUT, NSE_ITEMS_TAB);
        register("dice_d6", () -> DICE_D6, NSE_ITEMS_TAB);
        register("dice_d4", () -> DICE_D4, NSE_ITEMS_TAB);
        register("dice_d20", () -> DICE_D20, NSE_ITEMS_TAB);
        register("light_bulb_item", () -> LIGHT_BULB, NSE_ITEMS_TAB);

        Registry.register(Registries.SOUND_EVENT, new Identifier("new_soviet", "dice_sound"), DICE_SOUND);
    }
}
