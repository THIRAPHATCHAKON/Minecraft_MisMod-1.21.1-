package net.nom.jokmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.item.ModItem;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block>  BlOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, JokMod.MOD_ID);

    public static final RegistryObject<Block> MIS_BLOCK = registerBlock("mis_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toRetrun = BlOCKS.register(name, block);
        registerBlockItem(name, toRetrun);
        return  toRetrun;
    }

    private  static <T extends Block> void  registerBlockItem(String name, RegistryObject<T> block) {
        ModItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BlOCKS.register(eventBus);
    }
}
