package supersymmetry.mixins.bdsandm;

import funwayguy.bdsandm.inventory.capability.BdsmCapabilies;
import funwayguy.bdsandm.inventory.capability.CapabilityBarrel;
import funwayguy.bdsandm.items.ItemBarrel;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemBarrel.class)
public class ItemBarrelMixin extends ItemBlock {
    //Need to extend ItemBlock to use super.getNBTShareTag
    public ItemBarrelMixin(Block block) {
        super(block);
    }

    /**
     * @author The-Minecraft-Scientist (discord rsci.)
     */
    @Override
    // Hack that keeps a difficult to reproduce bug somewhere else in BDS&M from kicking players.
    // This hack omits adding the CapabilityBarrel NBT tag if CapabilityBarrel is not present on the given item stack.
    // The original BDS&M code had an assertion that assumed barrelCap was non-null, which would
    // fire from the network handler for a given player and kick them.
    // This hack reduces the scope of the bug to incorrect (not present) barrel metadata on the client.
    public NBTTagCompound getNBTShareTag(ItemStack stack) {
        CapabilityBarrel barrelCap = (CapabilityBarrel) stack.getCapability(BdsmCapabilies.BARREL_CAP, null);
        if (barrelCap == null) {
            return super.getNBTShareTag(stack);
        }
        stack.setTagInfo("barrelCap", barrelCap.serializeNBT());
        return super.getNBTShareTag(stack);
    }
}
