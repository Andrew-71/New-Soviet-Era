package su.a71.new_soviet.blocks;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
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
import su.a71.new_soviet.entity.TVBlockEntity;

public class TVBlock extends HorizontalFacingBlock implements BlockEntityProvider {
    public TVBlock(AbstractBlock.Settings settings) {
        super(settings.sounds(BlockSoundGroup.METAL).pistonBehavior(PistonBehavior.BLOCK).strength(1f, 2f));
        setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH, SOUTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.1875f, 1.0f, 0.8125f, 0.8125f);
            case EAST, WEST -> VoxelShapes.cuboid(0.1875f, 0.0f, 0.0f, 0.8125f, 0.8125f, 1.0f);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TVBlockEntity(pos, state);
    }
}