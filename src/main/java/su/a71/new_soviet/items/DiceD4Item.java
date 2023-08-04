package su.a71.new_soviet.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import su.a71.new_soviet.NewSoviet;
import su.a71.new_soviet.registration.NSE_Items;

import java.util.List;

public class DiceD4Item extends Item {
    public DiceD4Item(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 20 * itemStack.getCount());
        if (!world.isClient) {
            StringBuilder output = new StringBuilder();
            for (var i = 0; i < itemStack.getCount(); i++) {
                world.playSound((PlayerEntity)null, user.getX(), user.getY(), user.getZ(), NSE_Items.DICE_SOUND, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
                output.append(NewSoviet.RANDOM.nextBetween(1, this.getSides())).append(", ");
            }
            user.sendMessage(Text.translatable(itemStack.getCount() == 1 ? "item.new_soviet.dice.thrown" : "item.new_soviet.dice.thrown_multiple").append(" " + output.subSequence(0, output.length() - 2)));
        }

        user.increaseStat(Stats.USED.getOrCreateStat(this), itemStack.getCount());
        return TypedActionResult.success(itemStack, world.isClient());
    }

    public int getSides() {
        return 4;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.new_soviet.dice_d4.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
