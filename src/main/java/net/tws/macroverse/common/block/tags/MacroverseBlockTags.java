package net.tws.macroverse.common.block.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.tws.macroverse.Main;

public class MacroverseBlockTags {

    public static final TagKey<Block> SUPPORTS_UMBRAL_VEGETATION = create("supports_umbral_vegetation");

    private MacroverseBlockTags() {

    }

    private static TagKey<Block> create(final String name) {
        return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Main.MOD_ID, name));
    }
}
