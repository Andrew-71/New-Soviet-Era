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

public class RadioBlock extends HorizontalFacingBlock {
    public RadioBlock() {
        super(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).notSolid().pistonBehavior(PistonBehavior.DESTROY).strength(1f, 2f).mapColor(MapColor.PALE_YELLOW));
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
            case NORTH, SOUTH -> VoxelShapes.cuboid(0.0625f, 0.0f, 0.3125f, 0.9375f, 0.5625f, 0.6875f);
            case EAST, WEST -> VoxelShapes.cuboid(0.3125f, 0.0f, 0.0625f, 0.6875f, 0.5625f, 0.9375f);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}