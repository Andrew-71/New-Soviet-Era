package su.a71.new_soviet.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import su.a71.new_soviet.registration.NSE_Custom;

public class SirenBlock extends HorizontalFacingBlock {
    public static final BooleanProperty ON;

    public SirenBlock() {
        super(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).notSolid().pistonBehavior(PistonBehavior.DESTROY).strength(1f, 2f));
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH).with(ON, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, ON);
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            boolean bl = (Boolean)state.get(ON);
            if (bl != world.isReceivingRedstonePower(pos)) {
                if (bl) {
                    world.scheduleBlockTick(pos, this, 4);
                } else {
                    world.playSound((PlayerEntity)null, pos.getX(), pos.getY(), pos.getZ(), NSE_Custom.SIREN_SOUND, SoundCategory.NEUTRAL, getSirenVolume(world, pos), 1f);
                    world.setBlockState(pos, (BlockState)state.cycle(ON), 2);
                    world.scheduleBlockTick(pos, this, 140);
                }
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return Block.createCuboidShape(3.5, 2, 11, 12.5, 15, 16);
            case SOUTH:
                return Block.createCuboidShape(3.5, 2, 0, 12.5, 15, 5);
            case EAST:
                return Block.createCuboidShape(0, 2, 3.5, 5, 15, 12.5);
            case WEST:
                return Block.createCuboidShape(11, 2, 3.5, 16, 15, 12.5);
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(ON, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = (Direction)state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return direction.getAxis().isHorizontal() && blockState.isSideSolidFullSquare(world, blockPos, direction);
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if ((Boolean)state.get(ON) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, (BlockState)state.cycle(ON), 2);
        } else {
            world.playSound((PlayerEntity)null, pos.getX(), pos.getY(), pos.getZ(), NSE_Custom.SIREN_SOUND, SoundCategory.NEUTRAL, getSirenVolume(world, pos), 1f);
            world.scheduleBlockTick(pos, this, 140);
        }
    }
    
    public float getSirenVolume(World world, BlockPos pos) {
        return switch (world.getReceivedRedstonePower(pos)) {
            case 4, 5, 6 -> 2f;
            case 7, 8, 9 -> 3f;
            case 10, 11, 12 -> 4f;
            case 13, 14, 15, 16 -> 5f;
            default -> 1f;
        };
    }

    static {
        ON = RedstoneTorchBlock.LIT;
    }
}