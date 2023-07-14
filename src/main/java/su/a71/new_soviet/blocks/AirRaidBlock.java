package su.a71.new_soviet.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import net.minecraft.block.TripwireHookBlock;
import net.minecraft.world.WorldView;

public class AirRaidBlock extends HorizontalFacingBlock {
    public AirRaidBlock() {
        super(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).notSolid().pistonBehavior(PistonBehavior.DESTROY));
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
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
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = (Direction)state.get(FACING);
        BlockPos blockPos = pos.offset(direction.getOpposite());
        BlockState blockState = world.getBlockState(blockPos);
        return direction.getAxis().isHorizontal() && blockState.isSideSolidFullSquare(world, blockPos, direction);
    }
}