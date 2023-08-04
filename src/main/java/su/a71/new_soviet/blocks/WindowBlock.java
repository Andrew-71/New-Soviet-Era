package su.a71.new_soviet.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class WindowBlock extends HorizontalFacingBlock {
    public static final IntProperty WIN_TYPE = IntProperty.of("window_type", 0, 2);
    public static final BooleanProperty BROKEN = Properties.CRACKED;

    public WindowBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(BROKEN, false)
                .with(WIN_TYPE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, WIN_TYPE, Properties.CRACKED);
    }

    public void onEntityCollision(World world, BlockPos pos, Entity entity) {
        if (entity instanceof ProjectileEntity) {
            world.getBlockState(pos);
        }
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
        BlockState above = ctx.getWorld().getBlockState(ctx.getBlockPos().up());
        BlockState below = ctx.getWorld().getBlockState(ctx.getBlockPos().down());
//        if ((above.getBlock() instanceof Window && ((Window) above.getBlock()).getStateManager().getProperty("broken") == true) || (below.getBlock() instanceof Window)) {
//
//        }
        return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
