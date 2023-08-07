package su.a71.new_soviet.entity;

import io.netty.channel.unix.Errors;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import su.a71.new_soviet.registration.NSE_Custom;

import java.util.Arrays;

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
    public int DISPLAY_SIZE = 8;  // The monitor is 8x8
    public TVBlockEntity(BlockPos pos, BlockState state) {
        super(NSE_Custom.TV_BLOCK_ENTITY, pos, state);
        display = new int[8][8];
        Arrays.fill(display, new int[]{0, 0, 0, 0, 0, 0, 0, 0});
    }

    public int getPixel(int x, int y) {
        if (x > 7 || y > 7 || x < 0 || y < 0) {
            throw new IndexOutOfBoundsException("Coordinates must be within 0-7 range");
        }
        return display[x][y];
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        for (int i = 0; i < DISPLAY_SIZE; i++) {
            nbt.putIntArray("display_row_" + i, display[i]);
        }
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        display = new int[8][8];
        for (int i = 0; i < DISPLAY_SIZE; i++) {
            display[i] = nbt.getIntArray("display_row_" + i);
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
