package su.a71.new_soviet.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import su.a71.new_soviet.NewSoviet;

import net.minecraft.block.BrushableBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.item.BrushItem;



public class LandMineBlock extends Block implements Waterloggable {
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape SHAPE;

    public LandMineBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !this.canPlaceAt(state, world, pos)) {
            explode((World) world, pos);
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!world.isClient && entity.canModifyAt(world, pos)) {
            explode(world, pos);
        }
        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient) {
            explode(world, pos);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        if (!world.isClient) {
            BlockPos blockPos = hit.getBlockPos();
            if (projectile.canModifyAt(world, blockPos)) {
                explode(world, blockPos);
            }
        }

    }

    // With a shovel, 25% chance of explosion on break
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient() && !player.isCreative() && !(player.getHandItems().iterator().next().getItem() instanceof ShovelItem)) {
            if (NewSoviet.RANDOM.nextBetween(1, 4) != 1) {
                explode(world, pos);
            }
        }
        super.onBreak(world, pos, state, player);
    }

    // Only explode every 2/3rd of times to prevent instant explosion chains
    @Override
    public void onDestroyedByExplosion(World world, BlockPos pos, Explosion explosion) {
        if (!world.isClient) {
            int chance = NewSoviet.RANDOM.nextBetween(0, 2);
            if (chance != 0) {
                explode(world, pos);
            }
        }
        super.onDestroyedByExplosion(world, pos, explosion);
    }

    // Without a shovel, 80% chance of explosion on contact
    @Override
    public void onBlockBreakStart(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (!world.isClient() && !(player.getHandItems().iterator().next().getItem() instanceof ShovelItem))
        {
            if (NewSoviet.RANDOM.nextBetween(1, 10) < 2) {
                explode(world, pos);
            }
        }
        super.onBlockBreakStart(state, world, pos, player);
    }

    // On contact explode
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            explode(world, pos);
        }
        return ActionResult.success(world.isClient);
    }

    public void explode(World world, BlockPos pos) {
        world.removeBlock(pos, false);
        float f = 4.0F;
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4.0F, World.ExplosionSourceType.TNT);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return (BlockState)this.getDefaultState().with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Vec3d vec3d = state.getModelOffset(world, pos);
        return SHAPE.offset(vec3d.getX(), vec3d.getY(), vec3d.getZ());
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = Direction.DOWN;
        return Block.sideCoversSmallSquare(world, pos.offset(direction), direction.getOpposite());
    }

    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return true;
    }

    public boolean shouldDropItemsOnExplosion(Explosion explosion) {
        return false;
    }

    static {
        SHAPE = Block.createCuboidShape(4, 0, 4, 12, 4, 12); // VoxelShapes.cuboid(0.4, 0, 0.4, 0.6, 0.3, 0.6);  //

//        SHAPE = Block.createCuboidShape(5, 0, 5, 11, 3, 11); // VoxelShapes.cuboid(0.4, 0, 0.4, 0.6, 0.3, 0.6);  //
        WATERLOGGED = Properties.WATERLOGGED;
    }
}
