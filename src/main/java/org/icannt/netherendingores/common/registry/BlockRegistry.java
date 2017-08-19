package org.icannt.netherendingores.common.registry;

import java.util.HashSet;
import java.util.Set;

import org.icannt.netherendingores.NetherendingOres;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndModded1;
import org.icannt.netherendingores.common.block.blocks.BlockOreEndVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherModded1;
import org.icannt.netherendingores.common.block.blocks.BlockOreNetherVanilla;
import org.icannt.netherendingores.common.block.blocks.BlockOreOther1;
import org.icannt.netherendingores.common.block.itemblock.ItemBlockOreModded1;
import org.icannt.netherendingores.common.block.itemblock.ItemBlockOreOther1;
import org.icannt.netherendingores.common.block.itemblock.ItemBlockOreVanilla;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by ICannt on 17/08/17.
 */

@GameRegistry.ObjectHolder(NetherendingOres.MOD_ID)
public class BlockRegistry {

    @GameRegistry.ObjectHolder("ore_nether_vanilla")
    public static final BlockOreNetherVanilla ORE_NETHER_VANILLA = new BlockOreNetherVanilla();
    
    @GameRegistry.ObjectHolder("ore_nether_modded_1")
    public static final BlockOreNetherModded1 ORE_NETHER_MODDED_1 = new BlockOreNetherModded1();
    
    @GameRegistry.ObjectHolder("ore_end_vanilla")
    public static final BlockOreEndVanilla ORE_END_VANILLA = new BlockOreEndVanilla();
    
    @GameRegistry.ObjectHolder("ore_end_modded_1")
    public static final BlockOreEndModded1 ORE_END_MODDED_1 = new BlockOreEndModded1();
    
    @GameRegistry.ObjectHolder("ore_other_1")
    public static final BlockOreOther1 ORE_OTHER_1 = new BlockOreOther1();

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            final IForgeRegistry<Block> registry = event.getRegistry();

            final Block[] blocks = {
                    ORE_NETHER_VANILLA,
                    ORE_NETHER_MODDED_1,
                    ORE_END_VANILLA,
                    ORE_END_MODDED_1,
                    ORE_OTHER_1
            };

            registry.registerAll(blocks);
        }

        @SubscribeEvent
        public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();

            final ItemBlock[] items = {
                new ItemBlockOreVanilla(ORE_NETHER_VANILLA),
                new ItemBlockOreModded1(ORE_NETHER_MODDED_1),
                new ItemBlockOreVanilla(ORE_END_VANILLA),
                new ItemBlockOreModded1(ORE_END_MODDED_1),
                new ItemBlockOreOther1(ORE_OTHER_1)
            };

            for (ItemBlock item : items) {
                registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
                ITEM_BLOCKS.add(item);
            }
        }

    }

    @SideOnly(Side.CLIENT)
    public static void initBlockModels() {
        ORE_NETHER_VANILLA.initClient();
        ORE_NETHER_MODDED_1.initClient();
        ORE_END_VANILLA.initClient();
        ORE_END_MODDED_1.initClient();
        ORE_OTHER_1.initClient();
    }
}