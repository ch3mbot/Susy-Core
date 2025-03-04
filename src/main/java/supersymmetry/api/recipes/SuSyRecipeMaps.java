package supersymmetry.api.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.builders.FuelRecipeBuilder;
import gregtech.api.recipes.builders.PrimitiveRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.core.sound.GTSoundEvents;
import gregtechfoodoption.recipe.GTFORecipeMaps;
import supersymmetry.api.gui.SusyGuiTextures;
import supersymmetry.api.recipes.builders.*;

public class SuSyRecipeMaps {

    public static final RecipeMap<CoilingCoilRecipeBuilder> COOLING_RECIPES = new RecipeMap<>("magnetic_refrigerator", 1, 3, 0, 3, 0, 0, 0, 1, new CoilingCoilRecipeBuilder(), false)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SinteringRecipeBuilder> SINTERING_RECIPES = new RecipeMap<>("sintering_oven", 1, 4, 1, 4, 1, 2, 0, 2, new SinteringRecipeBuilder(), false)
            .setSound(GTSoundEvents.COMBUSTION);

    public static final RecipeMap<PrimitiveRecipeBuilder> COAGULATION_RECIPES = new RecipeMap<>("coagulation_tank", 0, 2, 1, 1, 1, 2, 0, 0, new PrimitiveRecipeBuilder(), false);

    public static final RecipeMap<PseudoMultiRecipeBuilder> LATEX_COLLECTOR_RECIPES = new RecipeMap<>("latex_collector", 0, 2, 1, 2, new PseudoMultiRecipeBuilder(), false)
            .setProgressBar(SusyGuiTextures.PROGRESS_BAR_EXTRACTION, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTSoundEvents.DRILL_TOOL);

    public static final RecipeMap<CatalystRecipeBuilder> VULCANIZATION_RECIPES = new RecipeMap<>("vulcanizing_press", 4, 2, 2, 1, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.MOLD_OVERLAY)
            .setSound(GTSoundEvents.COMBUSTION);

    public static final RecipeMap<CatalystRecipeBuilder> ROASTER_RECIPES = new RecipeMap<>("roaster", 1, 2, 0, 2, 0, 2, 0, 3, new CatalystRecipeBuilder(), false)
            .setSound(GTSoundEvents.COMBUSTION);

    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_CHAMBER = new RecipeMap<>("vacuum_chamber", 1, 4, 1, 1, 0, 2, 0, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.CENTRIFUGE);

    public static final RecipeMap<CatalystRecipeBuilder> CSTR_RECIPES = new RecipeMap<>("continuous_stirred_tank_reactor", 0, 0, 4, 2, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, true, false, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> FIXED_BED_REACTOR_RECIPES = new RecipeMap<>("fixed_bed_reactor", 1, 1, 3, 2, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, false, SusyGuiTextures.CATALYST_BED_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> TRICKLE_BED_REACTOR_RECIPES = new RecipeMap<>("trickle_bed_reactor", 1, 0, 3, 2, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, false, SusyGuiTextures.CATALYST_PELLET_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> BUBBLE_COLUMN_REACTOR_RECIPES = new RecipeMap<>("bubble_column_reactor", 1, 0, 3, 2, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, false, SusyGuiTextures.LARGE_REACTOR_ITEM_OVERLAY)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> BATCH_REACTOR_RECIPES = new RecipeMap<>("batch_reactor", 3, 3, 3, 3, new CatalystRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSlotOverlay(false, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(false, true, false, GuiTextures.BEAKER_OVERLAY_3)
            .setSlotOverlay(false, true, true, GuiTextures.BEAKER_OVERLAY_3)
            .setSlotOverlay(true, false, false, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, true, false, GuiTextures.BEAKER_OVERLAY_3)
            .setSlotOverlay(true, true, true, GuiTextures.BEAKER_OVERLAY_3)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> CRYSTALLIZER_RECIPES = new RecipeMap<>("crystallizer",3, 1, 3, 1, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> DRYER = new RecipeMap<>("dryer", 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> ION_EXCHANGE_COLUMN_RECIPES = new RecipeMap<>("ion_exchange_column", 1, 1, 2, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSlotOverlay(false, false, true, SusyGuiTextures.CUBIC_LATTICE_OVERLAY)
            .setSlotOverlay(false, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSlotOverlay(true, false, true, SusyGuiTextures.CUBIC_LATTICE_OVERLAY)
            .setSlotOverlay(true, true, true, GuiTextures.MOLECULAR_OVERLAY_4)
            .setSound(GTSoundEvents.BATH);

    public static final RecipeMap<SimpleRecipeBuilder> ZONE_REFINER_RECIPES = new RecipeMap<>("zone_refiner", 1, 1, 0, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(true, false, true, GuiTextures.CRYSTAL_OVERLAY)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<SimpleRecipeBuilder> TUBE_FURNACE_RECIPES = new RecipeMap<>("tube_furnace", 3, 1, 1, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSlotOverlay(false, false, false, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, false, true, GuiTextures.FURNACE_OVERLAY_1)
            .setSlotOverlay(false, true, true, GuiTextures.TURBINE_OVERLAY)
            .setSlotOverlay(true, false, true, SusyGuiTextures.CUBIC_LATTICE_OVERLAY)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> FLUIDIZED_BED_REACTOR_RECIPES = new RecipeMap<>("fluidized_bed_reactor", 2, 2, 3, 2, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, true, SusyGuiTextures.LARGE_REACTOR_FLUID_OVERLAY)
            .setSlotOverlay(true, true, SusyGuiTextures.LARGE_REACTOR_FLUID_OVERLAY)
            .setSlotOverlay(false, false, SusyGuiTextures.LARGE_REACTOR_ITEM_OVERLAY)
            .setSlotOverlay(true, false, SusyGuiTextures.LARGE_REACTOR_ITEM_OVERLAY)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> POLYMERIZATION_RECIPES = new RecipeMap<>("polymerization_tank", 2, 1, 2, 1, new CatalystRecipeBuilder(), false)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSlotOverlay(true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> ELECTROLYTIC_CELL_RECIPES = new RecipeMap<>("electrolytic_cell", 3, 3, 3, 4, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(true, true, GuiTextures.MOLECULAR_OVERLAY_3)
            .setSlotOverlay(false, false, SusyGuiTextures.ELECTRODE_OVERLAY)
            .setSlotOverlay(true, false, GuiTextures.MOLECULAR_OVERLAY_1)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> COKING_RECIPES = new RecipeMap<>("coking_tower", 1, 1, 3, 2, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.COMBUSTION);

    public static final RecipeMap<SimpleRecipeBuilder> VACUUM_DISTILLATION_RECIPES = new RecipeMap<>("vacuum_distillation", 1, 1, 1, 12, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<CatalystRecipeBuilder> CATALYTIC_REFORMER_RECIPES = new RecipeMap<>("catalytic_reformer_recipes", 1, 0, 2, 4, new CatalystRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<NoEnergyRecipeBuilder> SMOKE_STACK = new RecipeMap<>("smoke_stack", 0, 0, 1, 0, new NoEnergyRecipeBuilder(), false)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<SimpleRecipeBuilder> FERMENTATION_VAT_RECIPES = new RecipeMap<>("vat_fermentation", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.DUST_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> UV_RECIPES = new RecipeMap<>("uv_light_box", 2, 1, 1, 1, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<SimpleRecipeBuilder> ION_IMPLANTATION_RECIPES = new RecipeMap<>("ion_implantation", 3, 1, 2, 0, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> CVD_RECIPES = new RecipeMap<>("cvd", 3, 1, 2, 2, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<SimpleRecipeBuilder> ORE_SORTER_RECIPES = new RecipeMap<>("ore_sorter", 2, 20, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MACERATOR);

    public static final RecipeMap<SimpleRecipeBuilder> COOLING_TOWER_RECIPES = new RecipeMap<>("cooling_tower", 0, 0, 2, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> COOLING_UNIT_RECIPES = new RecipeMap<>("cooling_unit", 0, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> FLUID_DECOMPRESSOR_RECIPES = new RecipeMap<>("fluid_decompressor", 0, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMPRESSOR);

    public static final RecipeMap<SimpleRecipeBuilder> FLUID_COMPRESSOR_RECIPES = new RecipeMap<>("fluid_compressor", 0, 0, 1, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COMPRESSOR);

    public static final RecipeMap<NoEnergyRecipeBuilder> HEAT_EXCHANGER_RECIPES = new RecipeMap<>("heat_exchanger", 0, 0, 2, 2, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoEnergyRecipeBuilder> TAPPED_OFF_HEAT_EXCHANGER_RECIPES = new RecipeMap<>("tapped_off_heat_exchanger", 0, 0, 2, 3, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoEnergyRecipeBuilder> CONDENSER_RECIPES = new RecipeMap<>("condenser", 0, 0, 2, 2, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoEnergyRecipeBuilder> HEAT_RADIATOR_RECIPES = new RecipeMap<>("radiator", 0, 0, 1, 1, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_COMPRESS, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> QUENCHER_RECIPES = new RecipeMap<>("quencher", 2, 1, 2, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> WEAPONS_FACTORY_RECIPES = new RecipeMap<>("weapons_factory", 9, 1, 2, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> LARGE_WEAPONS_FACTORY_RECIPES = new RecipeMap<>("large_weapons_factory", 9, 1, 3, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CIRCUIT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> RAILROAD_ENGINEERING_STATION_RECIPES = new RecipeMap<>("railroad_engineering_station", 16, 1, 4, 0, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ASSEMBLER);

    public static final RecipeMap<SimpleRecipeBuilder> MINING_DRILL_RECIPES = new RecipeMap<>("mining_drill", 1, 1, 1, 1, new SimpleRecipeBuilder(), false)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEvents.MACERATOR);

    public static final RecipeMap<SimpleRecipeBuilder> GRAVITY_SEPARATOR_RECIPES = new RecipeMap<>("gravity_separator", 1, 6, 1, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MACERATE, ProgressWidget.MoveType.VERTICAL)
            .setSlotOverlay(false, false, true, SusyGuiTextures.ORE_CHUNK_OVERLAY)
            .setSlotOverlay(false, true, false, SusyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSlotOverlay(false, true, true, SusyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSlotOverlay(true, false, false, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, true, false, SusyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSlotOverlay(true, true, true, SusyGuiTextures.SIFTER_FLUID_OVERLAY)
            .setSound(GTSoundEvents.MACERATOR);

    public static final RecipeMap<SimpleRecipeBuilder> REACTION_FURNACE_RECIPES = new RecipeMap<>("reaction_furnace", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<SimpleRecipeBuilder> PRESSURE_SWING_ADSORBER_RECIPES = new RecipeMap<>("pressure_swing_adsorption", 1, 1, 2, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.COMPRESSOR);

    public static final RecipeMap<FuelRecipeBuilder> MAGNETOHYDRODYNAMIC_FUELS = new RecipeMap<>("magnetohydrodynamic_generator", 0, 0, 1, 1, new FuelRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<SimpleRecipeBuilder> ADVANCED_ARC_FURNACE = new RecipeMap<>("advanced_arc_furnace", 4, 2, 3, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.ARC);

    public static final RecipeMap<NoEnergyRecipeBuilder> EVAPORATION_POOL = new RecipeMap<>("evaporation_pool", 1, 4, 1, 1, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> CLARIFIER = new RecipeMap<>("clarifier", 1, 1, 1, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSound(GTSoundEvents.CENTRIFUGE);

    public static final RecipeMap<SimpleRecipeBuilder> MULTI_STAGE_FLASH_DISTILLATION = new RecipeMap<>("multi_stage_flash_distillation", 0, 0, 3, 3, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoEnergyRecipeBuilder> FLARE_STACK = new RecipeMap<>("flare_stack", 0, 0, 1, 0, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<NoEnergyRecipeBuilder> DUMPING = new RecipeMap<>("dumping", 0, 0, 1, 0, new NoEnergyRecipeBuilder(), false)
            .setSound(GTSoundEvents.BATH);

    public static final RecipeMap<SimpleRecipeBuilder> FROTH_FLOTATION = new RecipeMap<>("froth_flotation", 3, 6, 3, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_MIXER, ProgressWidget.MoveType.CIRCULAR)
            .setSound(GTSoundEvents.BATH);

    public static final RecipeMap<SimpleRecipeBuilder> HIGH_TEMPERATURE_DISTILLATION = new RecipeMap<>("high_temperature_distillation", 1, 1, 1, 12, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTSoundEvents.CHEMICAL_REACTOR);

    public static final RecipeMap<SimpleRecipeBuilder> IN_SITU_LEACHER = new RecipeMap<>("in_situ_leacher", 2, 2, 2, 2, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.COMPRESSOR);

    public static final RecipeMap<SimpleRecipeBuilder> EUV_LITHOGRAPHY = new RecipeMap<>("euv_lithography", 3, 3, 3, 3, new SimpleRecipeBuilder(), false)
            .setSound(GTSoundEvents.ELECTROLYZER);

    public static final RecipeMap<SimpleRecipeBuilder> ROTARY_KILN = new RecipeMap<>("rotary_kiln", 3, 2, 3, 1, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.MACERATOR);

    public static final RecipeMap<SimpleRecipeBuilder> HIGH_PRESSURE_CRYOGENIC_DISTILLATION = new RecipeMap<>("high_puressure_cryogenic_distillation", 1, 0, 9, 9, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> LOW_PRESSURE_CRYOGENIC_DISTILLATION = new RecipeMap<>("low_pressure_cryogenic_distillation", 1, 0, 9, 9, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<SimpleRecipeBuilder> SINGLE_COLUMN_CRYOGENIC_DISTILLATION = new RecipeMap<>("single_column_cryogenic_distillation", 1, 0, 9, 9, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.COOLING);

    public static final RecipeMap<NoEnergyRecipeBuilder> REVERBERATORY_FURNACE = new RecipeMap<>("reverberatory_furnace", 3, 3, 3, 3, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.FURNACE);

    public static final RecipeMap<SimpleRecipeBuilder> PHASE_SEPARATOR = new RecipeMap<>("phase_separator", 0, 0, 2, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, ProgressWidget.MoveType.HORIZONTAL)
            .setSound(GTSoundEvents.BATH);

    public static final RecipeMap<SimpleRecipeBuilder> CONTACT_COOLER = new RecipeMap<>("contact_cooler", 0, 0, 2, 2, new SimpleRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL_DOWNWARDS)
            .setSound(GTSoundEvents.BATH);

    public static final RecipeMap<NoEnergyRecipeBuilder> BATH_CONDENSER = new RecipeMap<>("bath_condenser", 0, 0, 2, 2, new NoEnergyRecipeBuilder(), false)
            .setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.VERTICAL)
            .setSound(GTSoundEvents.BATH);

    public static void init(){
        RecipeMaps.SIFTER_RECIPES.setMaxFluidInputs(1);
        RecipeMaps.SIFTER_RECIPES.setMaxFluidOutputs(1);
        RecipeMaps.SIFTER_RECIPES.setMaxInputs(2);
        RecipeMaps.CENTRIFUGE_RECIPES.setMaxFluidInputs(2);
        RecipeMaps.CENTRIFUGE_RECIPES.setSlotOverlay(false, true, false, GuiTextures.CENTRIFUGE_OVERLAY);
        RecipeMaps.MIXER_RECIPES.setMaxFluidInputs(3);
        RecipeMaps.MIXER_RECIPES.setMaxFluidOutputs(2);
        RecipeMaps.ARC_FURNACE_RECIPES.setMaxInputs(4);
        RecipeMaps.ELECTROLYZER_RECIPES.setMaxInputs(4);
        RecipeMaps.ELECTROLYZER_RECIPES.setMaxFluidOutputs(3);
        RecipeMaps.ELECTROLYZER_RECIPES.setMaxOutputs(3);
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.setMaxFluidOutputs(2);
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.setMaxFluidInputs(1);
        GTFORecipeMaps.GREENHOUSE_RECIPES.setMaxFluidInputs(4);
        RecipeMaps.PYROLYSE_RECIPES.setMaxFluidOutputs(3);
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.setSlotOverlay(false, false, SusyGuiTextures.ELECTROMAGNETIC_SEPARATOR_ITEM_OVERLAY);
        RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES.setSlotOverlay(false, true, SusyGuiTextures.ELECTROMAGNETIC_SEPARATOR_FLUID_OVERLAY);
        RecipeMaps.SIFTER_RECIPES.setSlotOverlay(false, true, SusyGuiTextures.SIFTER_FLUID_OVERLAY);
        RecipeMaps.SIFTER_RECIPES.setSlotOverlay(true, true, SusyGuiTextures.SIFTER_FLUID_OVERLAY);
        RecipeMaps.SIFTER_RECIPES.setSlotOverlay(false, false, SusyGuiTextures.SIFTER_ITEM_INPUT_OVERLAY);
        RecipeMaps.SIFTER_RECIPES.setSlotOverlay(true, false, SusyGuiTextures.SIFTER_ITEM_OUTPUT_OVERLAY);
        RecipeMaps.LASER_ENGRAVER_RECIPES.setMaxFluidInputs(1);
        RecipeMaps.GAS_TURBINE_FUELS.setMaxFluidInputs(2);
        RecipeMaps.GAS_TURBINE_FUELS.setMaxFluidOutputs(1);
        RecipeMaps.AUTOCLAVE_RECIPES.setMaxFluidInputs(2);
        RecipeMaps.AUTOCLAVE_RECIPES.setMaxFluidOutputs(2);
    }
}
