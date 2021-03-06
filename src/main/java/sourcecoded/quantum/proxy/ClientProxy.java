package sourcecoded.quantum.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.MinecraftForgeClient;
import sourcecoded.core.SourceCodedCore;
import sourcecoded.quantum.Constants;
import sourcecoded.quantum.QAClientCommand;
import sourcecoded.quantum.client.renderer.block.AdvancedTileProxy;
import sourcecoded.quantum.client.renderer.block.SimpleTileProxy;
import sourcecoded.quantum.client.renderer.entity.RenderEnergyPacket;
import sourcecoded.quantum.client.renderer.entity.RenderQuantumArrow;
import sourcecoded.quantum.client.renderer.item.*;
import sourcecoded.quantum.client.renderer.tile.*;
import sourcecoded.quantum.entity.EntityEnergyPacket;
import sourcecoded.quantum.entity.EntityQuantumArrow;
import sourcecoded.quantum.registry.QABlocks;
import sourcecoded.quantum.registry.QAItems;
import sourcecoded.quantum.tile.*;

import java.io.File;

public class ClientProxy implements IProxy {

    public static File quantumDir;
    public static File discoveriesDir;
    public static File discoveryExportDir;
    public static File discoveryImportDir;

    @Override
    public void register() {
        registerRenderers();
        startFileInit();

        ClientCommandHandler.instance.registerCommand(new QAClientCommand());
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    void startFileInit() {
        String root = SourceCodedCore.getForgeRoot();
        quantumDir = new File(root, "quantumAnomalies");
        discoveriesDir = new File(quantumDir, "discoveries");
        discoveryExportDir = new File(discoveriesDir, "export");
        discoveryImportDir = new File(discoveriesDir, "import");

        quantumDir.mkdirs();
        discoveriesDir.mkdirs();
        discoveryImportDir.mkdirs();
        discoveryExportDir.mkdirs();
    }

    void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityEnergyPacket.class, new RenderEnergyPacket());
        RenderingRegistry.registerEntityRenderingHandler(EntityQuantumArrow.class, new RenderQuantumArrow());

        RenderingRegistry.registerBlockHandler(new SimpleTileProxy());
        RenderingRegistry.registerBlockHandler(new AdvancedTileProxy());

        MinecraftForgeClient.registerItemRenderer(QAItems.SCEPTRE.getItem(), new ItemSceptreRenderer());

        MinecraftForgeClient.registerItemRenderer(QAItems.ENTROPIC_STAR.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/star/L0.png"), 0.02F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/star/L1.png"), 0.06F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/star/L2.png"), 0.08F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/star/L3.png"), 0.1F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.RIFT_AXE.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/axe_0.png"), 0.07F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/axe_1.png"), 0.02F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/axe_2.png"), 0.04F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/axe_3.png"), 0.1F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.RIFT_PICKAXE.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/pickaxe_0.png"), 0.07F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/pickaxe_1.png"), 0.02F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/pickaxe_2.png"), 0.04F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/pickaxe_3.png"), 0.1F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.RIFT_SHOVEL.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/shovel_0.png"), 0.07F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/shovel_1.png"), 0.02F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/shovel_2.png"), 0.04F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/shovel_3.png"), 0.1F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.RIFT_SWORD.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/sword_0.png"), 0.07F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/sword_1.png"), 0.02F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/sword_2.png"), 0.04F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/sword_3.png"), 0.08F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.INJECTED_STICK.getItem(), new ItemStickRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/stick_0.png"), 0.09F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/stick_1.png"), 0.04F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.INJECTED_STRING.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/string_1.png"), 0.05F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.RIFT_MAGNET.getItem(), new ItemDepthRenderer(
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/magnet_0.png"), 0.06F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/magnet_1.png"), 0.08F),
                new TexDepthMap(new ResourceLocation(Constants.MODID, "textures/items/tools/magnet_2.png"), 0.1F)
        ));

        MinecraftForgeClient.registerItemRenderer(QAItems.RIFT_BOW.getItem(), new ItemBowRenderer());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(QABlocks.RIFT_NODE.getBlock()), new ItemTransparencyRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileInjectedStone.class, new TESRInjectedStone());
        ClientRegistry.bindTileEntitySpecialRenderer(TileInjectedGlass.class, new TESRInjectedGlass());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDebug.class, new TESRDebug());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCornerstone.class, new TESRCornerstone());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRiftSmelter.class, new TESRRiftSmelter());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRiftInjector.class, new TESRRiftInjector());
        ClientRegistry.bindTileEntitySpecialRenderer(TileManipulation.class, new TESRManipulation());
        ClientRegistry.bindTileEntitySpecialRenderer(TileSync.class, new TESRSync());
        ClientRegistry.bindTileEntitySpecialRenderer(TileArrangement.class, new TESRArrangement());
        ClientRegistry.bindTileEntitySpecialRenderer(TilePlayer.class, new TESRPlayer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileShelf.class, new TESRShelf());
    }


}
