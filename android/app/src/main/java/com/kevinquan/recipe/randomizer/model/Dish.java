package com.kevinquan.recipe.randomizer.model;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.kevinquan.android.model.BaseGsonModel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Dish extends BaseGsonModel {

    @SuppressWarnings("Unused")
    private static final String TAG = Dish.class.getSimpleName();

    public enum DishType {
        Unknown(0),
        Veggies(1),
        Meats(2),
        Fish(3),
        MeatsAndVeggies(4),
        Soup(10),
        ;

        protected int mId;

        DishType(int id) {
            mId = id;
        }

        public int getId() {
            return mId;
        }

        public DishType from(int id) {
            for (DishType dishType : values()) {
                if (dishType.getId() == id) {
                    return dishType;
                }
            }
            return Unknown;
        }

        public DishType from(String value) {
            if (TextUtils.isEmpty(value)) {
                return Unknown;
            }
            value = value.trim();
            for (DishType dishType : values()) {
                if (dishType.name().equalsIgnoreCase(value)) {
                    return dishType;
                }
            }
            return Unknown;
        }
    }

    public enum DishDifficulty {
        Unknown(0),
        Easy(3),
        Medium(5),
        Hard(8),
        ;
        protected int mId;

        DishDifficulty(int id) {
            mId = id;
        }

        public int getId() {
            return mId;
        }

        public DishDifficulty from(int id) {
            for (DishDifficulty difficulty : values()) {
                if (difficulty.getId() == id) {
                    return difficulty;
                }
            }
            return Unknown;
        }

        public DishDifficulty from(String value) {
            if (TextUtils.isEmpty(value)) {
                return Unknown;
            }
            value = value.trim();
            for (DishDifficulty difficulty : values()) {
                if (difficulty.name().equalsIgnoreCase(value)) {
                    return difficulty;
                }
            }
            return Unknown;
        }
    }

    public enum CookingMethod {
        Unknown(0),
        Pan(1),
        Oven(2),
        SlowCooker(3),
        ;

        protected int mId;

        CookingMethod(int id) {
            mId = id;
        }

        public int getId() {
            return mId;
        }

        public CookingMethod from(int id) {
            for (CookingMethod method : values()) {
                if (method.getId() == id) {
                    return method;
                }
            }
            return Unknown;
        }

        public CookingMethod from(String value) {
            if (TextUtils.isEmpty(value)) {
                return Unknown;
            }
            value = value.trim();
            for (CookingMethod method : values()) {
                if (method.name().equalsIgnoreCase(value)) {
                    return method;
                }
            }
            return Unknown;
        }
    }

    protected String name;
    @SerializedName("type") protected DishType dishType;
    protected DishDifficulty difficulty;
    protected int preparationTime;
    protected int cookingTime;
    protected CookingMethod cookingMethod;
    protected Collection<Ingredient> ingredients;
    protected long createdAt;

    public Dish() {
        // For GSON
        ingredients = new ArrayList<>();
        createdAt = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public DishType getType() {
        return dishType;
    }

    public DishDifficulty getDifficulty() {
        return difficulty;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public CookingMethod getCookingMethod() {
        return cookingMethod;
    }

    public Collection<Ingredient> getIngredients() {
        if (ingredients == null) {
            return new ArrayList<>();
        }
        return ingredients;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override public int hashCode() {
        StringBuffer ingredients = new StringBuffer();
        for (Ingredient ingredient : getIngredients()) {
            ingredients.append(ingredient.hashCode());
        }
        return (name+ingredients.toString()+createdAt).hashCode();
    }

}
