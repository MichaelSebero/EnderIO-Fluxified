package crazypants.enderio.base.integration;

import javax.annotation.Nonnull;

import net.minecraftforge.registries.IForgeRegistryEntry;

import com.enderio.core.common.util.UserIdent;

public interface IIntegration extends IForgeRegistryEntry<IIntegration> {

    default boolean isInSameTeam(@Nonnull UserIdent identA, @Nonnull UserIdent identB) {
        return false;
    };
}
