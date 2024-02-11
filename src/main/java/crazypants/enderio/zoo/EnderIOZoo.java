package crazypants.enderio.zoo;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import crazypants.enderio.api.EIOTags;
import org.apache.commons.lang3.tuple.Triple;

import com.enderio.core.common.util.NNList;

import crazypants.enderio.api.addon.IEnderIOAddon;
import crazypants.enderio.base.config.ConfigHandlerEIO;
import crazypants.enderio.base.config.recipes.RecipeFactory;
import crazypants.enderio.zoo.config.Config;
import crazypants.enderio.zoo.init.CommonProxy;
import crazypants.enderio.zoo.spawn.MobSpawns;
import info.loenwind.autoconfig.ConfigHandler;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = EnderIOZoo.MODID, name = EnderIOZoo.MOD_NAME, version = EnderIOZoo.VERSION, dependencies = EnderIOZoo.DEPENDENCIES)
@EventBusSubscriber
public class EnderIOZoo implements IEnderIOAddon {

  public static final @Nonnull String MODID = "enderiozoo";
  public static final @Nonnull String DOMAIN = "enderio";
  public static final @Nonnull String MOD_NAME = "Ender IO Zoo";
  public static final @Nonnull String VERSION = EIOTags.VERSION;

  private static final @Nonnull String DEFAULT_DEPENDENCIES = "after:" + crazypants.enderio.base.EnderIO.MODID;
  public static final @Nonnull String DEPENDENCIES = DEFAULT_DEPENDENCIES;

  @SidedProxy(clientSide = "crazypants.enderio.zoo.init.ClientProxy", serverSide = "crazypants.enderio.zoo.init.CommonProxy")
  public static CommonProxy proxy;
  @SuppressWarnings("unused")
  private static ConfigHandler configHandler;

  @EventHandler
  public static void init(@Nonnull FMLPreInitializationEvent event) {
    configHandler = new ConfigHandlerEIO(event, Config.F);
    proxy.preInit();
  }

  @EventHandler
  public static void init(FMLInitializationEvent event) {
  }

  @EventHandler
  public static void init(FMLPostInitializationEvent event) {
    MobSpawns.instance.loadSpawnConfig();
  }

  @Override
  @Nullable
  public Configuration getConfiguration() {
    return Config.F.getConfig();
  }

  @Override
  @Nonnull
  public NNList<Triple<Integer, RecipeFactory, String>> getRecipeFiles() {
    return new NNList<>(Triple.of(2, null, "spawner_zoo"), Triple.of(4, null, "potions_zoo"), Triple.of(4, null, "hiding_zoo"));
  }

}
