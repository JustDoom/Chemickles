package com.imjustdoom.chemickles.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class PickleJar extends Block {

    private static final VoxelShape SHAPE = Stream.of(
            Block.box(4, 0, 4, 12, 10, 12),
            Block.box(5, 1, 5, 11, 9, 11),
            Block.box(5.5, 10, 5.5, 10.5, 11, 10.5),
            Block.box(5, 11, 5, 11, 12, 11),
            Block.box(5.5, 12, 5.5, 10.5, 12.75, 10.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();;

    public PickleJar(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}