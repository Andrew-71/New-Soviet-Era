package su.a71.new_soviet.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.TorchBlock;
import org.jetbrains.annotations.Nullable;

public class CeilingFanBlock extends Block implements Waterloggable {
    protected static final VoxelShape SHAPE;
    public static final BooleanProperty ON;
    public static final BooleanProperty WATERLOGGED;

    public CeilingFanBlock(Block.Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(ON, false).with(WATERLOGGED, false));

    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState()
                .with(ON, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()))
                .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient) {
            boolean bl = (Boolean)state.get(ON);
            if (bl != world.isReceivingRedstonePower(pos)) {
                if (bl) {
                    world.scheduleBlockTick(pos, this, 4);
                } else {
                    world.setBlockState(pos, (BlockState)state.cycle(ON), 2);
                }
            }
        }
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return direction == Direction.UP && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if ((Boolean)state.get(ON) && !world.isReceivingRedstonePower(pos)) {
            world.setBlockState(pos, (BlockState)state.cycle(ON), 2);
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ON, WATERLOGGED});
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = Direction.UP;
        return Block.sideCoversSmallSquare(world, pos.offset(direction), direction.getOpposite());
    }

    static {
        SHAPE = VoxelShapes.union(Block.createCuboidShape(4.0, 2.0, 4.0, 12.0, 7.0, 12.0), Block.createCuboidShape(7.0, 7.0, 7.0, 9.0, 13.0, 9.0), Block.createCuboidShape(6.0, 13.0, 6.0, 10.0, 16.0, 10.0));
        ON = RedstoneTorchBlock.LIT;
        WATERLOGGED = Properties.WATERLOGGED;
    }
}