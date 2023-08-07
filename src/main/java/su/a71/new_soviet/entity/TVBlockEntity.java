package su.a71.new_soviet.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class TVBlockEntity extends BlockEntity {
    /*
    Digit 	Color
    0 	black
    1 	red
    2 	green
    3 	yellow
    4 	blue
    5 	magenta
    6 	cyan
    7 	white
     */
    public int[][] display;
    public TVBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        //nbt.putIntArray();
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }
}
