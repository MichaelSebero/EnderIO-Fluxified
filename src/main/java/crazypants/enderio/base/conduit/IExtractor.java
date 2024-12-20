package crazypants.enderio.base.conduit;

import javax.annotation.Nonnull;

import net.minecraft.util.EnumFacing;

import com.enderio.core.common.util.DyeColor;

import crazypants.enderio.base.machine.modes.RedstoneControlMode;

public interface IExtractor extends IConduit {

    void setExtractionRedstoneMode(@Nonnull RedstoneControlMode mode, @Nonnull EnumFacing dir);

    @Nonnull
    RedstoneControlMode getExtractionRedstoneMode(@Nonnull EnumFacing dir);

    void setExtractionSignalColor(@Nonnull EnumFacing dir, @Nonnull DyeColor col);

    @Nonnull
    DyeColor getExtractionSignalColor(@Nonnull EnumFacing dir);
}
