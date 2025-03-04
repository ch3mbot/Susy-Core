package supersymmetry.api.recipes.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import org.jetbrains.annotations.NotNull;
import supersymmetry.api.recipes.properties.SinterProperty;

public class SinteringRecipeBuilder extends RecipeBuilder<SinteringRecipeBuilder> {

    public SinteringRecipeBuilder() {

    }

    public SinteringRecipeBuilder(SinteringRecipeBuilder builder) {
        super(builder);
    }

    @SuppressWarnings("unused")
    public SinteringRecipeBuilder(Recipe recipe, RecipeMap<SinteringRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    @Override
    public SinteringRecipeBuilder copy() {
        return new SinteringRecipeBuilder(this);
    }

    public SinteringRecipeBuilder usePlasma(boolean usePlasma) {
        this.applyProperty(SinterProperty.getInstance(), usePlasma);
        return this;
    }

    public SinteringRecipeBuilder usePlasma() {
        return this.usePlasma(true);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(SinterProperty.KEY)) {
            this.usePlasma((Boolean) value);
            return true;
        }
        return super.applyProperty(key, value);
    }

}
