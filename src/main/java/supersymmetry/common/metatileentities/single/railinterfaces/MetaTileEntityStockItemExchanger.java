package supersymmetry.common.metatileentities.single.railinterfaces;

import cam72cam.immersiverailroading.entity.EntityRollingStock;
import cam72cam.immersiverailroading.entity.Freight;
import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Cuboid6;
import codechicken.lib.vec.Matrix4;
import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity;
import gregtech.client.utils.TooltipHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import supersymmetry.api.stockinteraction.IStockInteractor;
import supersymmetry.api.stockinteraction.StockHelperFunctions;
import supersymmetry.client.renderer.textures.SusyTextures;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.List;

public class MetaTileEntityStockItemExchanger  extends MetaTileEntity implements IStockInteractor
{
    public int ticksAlive;

    private byte filterIndex;
    public boolean validStockNearby;
    public boolean pulling;

    private boolean active; //purely for client side rendering, server checks if block is powered #fix# ask about update order (placing redstone wire borks it)

    public final Vec3d detectionArea = new Vec3d(5, 0, 5);

    private final int inventorySlots = 24;
    private ItemStackHandler itemTank;

    //locomotive, tank
    private final byte[] subClassMap = { 1, 3 };
    private final byte[] invClassMap = { -99, 0, -99, 1 };

    private final int PacketIDAll = 0x616C6C;
    private final int PacketIDValidNearby = 0x6E656172;
    private final int PacketIDTransferState = 0x7461726E;
    private final int PackIDFilterIndex = 0x696E64;
    private final int PackIDActive = 0x616374;

    public MetaTileEntityStockItemExchanger(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId);
        this.ticksAlive = 0;
        this.filterIndex = 1;
    }

    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityStockItemExchanger(this.metaTileEntityId);
    }

    public int getLightOpacity() {
        return 1;
    }

    //#fix# should have comparitor interaction maybe
    public int getActualComparatorValue() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return true;
    }

    //#fix# pickaxe not it maybe
    public String getHarvestTool() {
        return "wrench";
    }

    public boolean hasFrontFacing() {
        return true;
    }

    protected void initializeInventory() {
        super.initializeInventory();
        this.itemTank = (new ItemStackHandler(this.inventorySlots));
        this.itemInventory = this.itemTank;
    }

    public void writeInitialSyncData(PacketBuffer buf) {
        super.writeInitialSyncData(buf);
        buf.writeByte(this.filterIndex);
        buf.writeBoolean(this.validStockNearby);
        buf.writeBoolean(this.pulling);
        buf.writeBoolean(this.active);

        for(int i = 0; i < this.inventorySlots; i++) {
            ItemStack stack = this.itemTank.getStackInSlot(i);
            NBTTagCompound tagCompound = new NBTTagCompound();
            stack.writeToNBT(tagCompound);
            buf.writeCompoundTag(tagCompound);
        }
    }

    public void receiveInitialSyncData(PacketBuffer buf) {
        super.receiveInitialSyncData(buf);
        this.filterIndex = buf.readByte();
        this.validStockNearby = buf.readBoolean();
        this.pulling = buf.readBoolean();
        this.active = buf.readBoolean();
        this.scheduleRenderUpdate();

        for(int i = 0; i < this.inventorySlots; i++) {
            NBTTagCompound tagCompound = null;
            try {
                ItemStack stack = new ItemStack(buf.readCompoundTag());
                this.itemTank.insertItem(i, stack, false);
            } catch (IOException e) {
            }
        }
    }

    public void receiveCustomData(int dataId, PacketBuffer buf) {
        super.receiveCustomData(dataId, buf);
        if (dataId == PacketIDAll)
        {
            this.filterIndex = buf.readByte();
            this.validStockNearby = buf.readBoolean();
            this.pulling = buf.readBoolean();
            this.scheduleRenderUpdate();
        }
        else if (dataId == PackIDFilterIndex)
        {
            this.filterIndex = buf.readByte();
            this.scheduleRenderUpdate();
        }
        else if (dataId == PacketIDValidNearby)
        {
            this.validStockNearby = buf.readBoolean();
            this.scheduleRenderUpdate();
        }
        else if (dataId == PacketIDTransferState) {
            this.pulling = buf.readBoolean();
            this.scheduleRenderUpdate();
        }
        else if (dataId == PackIDActive) {
            this.active = buf.readBoolean();
        }
    }

    public void update() {
        super.update();

        if(this.getWorld().isRemote)
            return;

        if(this.ticksAlive % 20 == 0)
        {
            List<EntityRollingStock> stocks = StockHelperFunctions.GetStockInArea(this.filterIndex, this.getFrontFacing(), this, this.getWorld());
            boolean newValidNearby = stocks.size() > 0;
            if(newValidNearby != this.validStockNearby || this.ticksAlive == 0)
            {
                //#fix# if buffer is sent to server, then this should be run twice? test.
                this.validStockNearby = newValidNearby;
                this.writeCustomData(PacketIDValidNearby, (buf) -> buf.writeBoolean(newValidNearby));
            }

            if(!validStockNearby || !this.isBlockRedstonePowered())
                return;

            Freight invStock = (Freight)stocks.get(0);
            cam72cam.immersiverailroading.inventory.FilteredStackHandler umodFilteredHandler = invStock.cargoItems;
            ItemStackHandler stockStackHandler = umodFilteredHandler.internal;

            if(pulling) {
                this.TransferAll(stockStackHandler, this.itemTank);
            }
            else {
                this.TransferAll(this.itemTank, stockStackHandler);
            }
        }

        this.ticksAlive++;
    }

    public void TransferAll(ItemStackHandler from, ItemStackHandler to) {
        for(int i = 0; i < from.getSlots(); i++) {
            if(!from.getStackInSlot(i).isEmpty())
            {
                for(int j = 0; j < to.getSlots(); j++) {
                    if(to.getStackInSlot(j).isEmpty() || ItemHandlerHelper.canItemStacksStack(from.getStackInSlot(i), to.getStackInSlot(j))) {
                        from.setStackInSlot(i, to.insertItem(j, from.getStackInSlot(i), false));
                        j = to.getSlots() + 1;
                    }
                }
            }
        }
    }

    public boolean onScrewdriverClick(EntityPlayer playerIn, EnumHand hand, EnumFacing wrenchSide, CuboidRayTraceResult hitResult) {
        if (!playerIn.isSneaking()) {
            if (this.getWorld().isRemote) {
                this.scheduleRenderUpdate();
            } else {
                this.cycleFilterUp();
                playerIn.sendMessage(new TextComponentTranslation("Filter set to " + (this.filterIndex == 0 ? "none" : StockHelperFunctions.ClassNameMap[filterIndex])));
            }
            return true;
        }
        return super.onScrewdriverClick(playerIn, hand, wrenchSide, hitResult);
    }
    public void onNeighborChanged() {
        this.updateInputRedstoneSignals();
        this.active = this.isBlockRedstonePowered();
        this.scheduleRenderUpdate();
        this.writeCustomData(PackIDActive, (buf) -> buf.writeBoolean(this.active));
    }

    public boolean onWrenchClick(EntityPlayer playerIn, EnumHand hand, EnumFacing wrenchSide, CuboidRayTraceResult hitResult) {
        if (!playerIn.isSneaking()) {
            if (this.getWorld().isRemote) {
                this.scheduleRenderUpdate();
            } else {
                this.CycleTransferState();
                playerIn.sendMessage(new TextComponentTranslation("Set transfer state to " + (this.pulling ? "taking from stock" : "giving to stock")));
            }
            return true;
        }
        return super.onWrenchClick(playerIn, hand, wrenchSide, hitResult);
    }

    public boolean needsSneakToRotate() {
        return true;
    }

    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        if (!this.active) {
            SusyTextures.STOCK_ITEM_EXCHANGER_INACTIVE.renderOrientedState(renderState, translation, pipeline, Cuboid6.full, this.getFrontFacing(), true, true);
        }
        else if (this.pulling) {
            SusyTextures.STOCK_ITEM_EXCHANGER_PULLING.renderOrientedState(renderState, translation, pipeline, Cuboid6.full, this.getFrontFacing(), true, true);
        }
        else {
            SusyTextures.STOCK_ITEM_EXCHANGER_PUSHING.renderOrientedState(renderState, translation, pipeline, Cuboid6.full, this.getFrontFacing(), true, true);
        }
    }

    //#fix# figure out how to add translations like with I18n instead of just english
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World player, @NotNull List<String> tooltip, boolean advanced) {
        if (TooltipHelper.isShiftDown()) {
            tooltip.add("Screwdriver to cycle filter");
            tooltip.add("Wrench to cycle transfer state");
        } else {
            tooltip.add(I18n.format("gregtech.tooltip.tool_hold_shift"));
        }
    }

    //#fix# what does this do
    public boolean showToolUsages() {
        return false;
    }

    protected ModularUI createUI(EntityPlayer entityPlayer) {
        int w = 96;
        int h = 128;
        int buffer = 16;
        ModularUI.Builder builder = ModularUI.builder(GuiTextures.BACKGROUND, w, h)
                .label(buffer, buffer / 2, getMetaFullName());

        int six = buffer * 2;
        int siy = buffer;
        int ibuf = 16;
        int wrap = 8;
        for(int i = 0; i < inventorySlots; i++) {
            int posx = six + (i & wrap) * ibuf;
            int posy = siy + Math.floorDiv(i, 8) * ibuf;
            builder = builder.widget(new SlotWidget(this.itemTank, i, posx, posy, true, true));
        }

        return builder.build(getHolder(), entityPlayer);
    }

    //#fix# does detected need to be saved or just refreshed on load? does ticks-alive need to be saved to prevent every one ticking at once?
    //update system based on chunk and global time instead of ticks alive?
    //should detection area be changeable and saved?
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setByte("filterIndex", this.filterIndex);
        data.setBoolean("validStockNearby", this.validStockNearby);
        data.setBoolean("pulling", this.pulling);
        return data;
    }

    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        this.filterIndex = data.getByte("filterIndex");
        this.validStockNearby = data.getBoolean("validStockNearby");
        this.pulling = data.getBoolean("pulling");
    }

    public boolean onRightClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        return super.onRightClick(playerIn, hand, facing, hitResult);
    }

    //#fix# what does this do
    protected boolean shouldSerializeInventories() {
        return false;
    }

    public Vec3d getInteractionArea() {
        return this.detectionArea;
    }

    public void setFilterIndex(byte index) {
        this.filterIndex = index;
    }

    public void cycleFilter(boolean up) {
        this.filterIndex = subClassMap[StockHelperFunctions.CycleFilter(invClassMap[this.filterIndex], up, (byte)subClassMap.length)];
        this.writeCustomData(PackIDFilterIndex, (buf) -> buf.writeByte(this.filterIndex));
    }

    public void cycleFilterUp() {
        this.cycleFilter(true);
    }

    public byte getFilterIndex() {
        return this.filterIndex;
    }

    public void CycleTransferState() {
        this.pulling = !this.pulling;
        this.writeCustomData(PacketIDTransferState, (buf) -> buf.writeBoolean(this.pulling));
    }

    public MetaTileEntity GetMetaTileEntity() {
        return this;
    }

    protected boolean canMachineConnectRedstone(EnumFacing side) {
        return true;
    }
}
