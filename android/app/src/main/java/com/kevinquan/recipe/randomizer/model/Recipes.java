package com.kevinquan.recipe.randomizer.model;

import com.kevinquan.android.model.BaseGsonModel;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Recipes extends BaseGsonModel {

    @SuppressWarnings("Unused")
    private static final String TAG = Recipes.class.getSimpleName();

    protected Collection<Dish> dishes;
    protected long createdAt;

    public Recipes() {
        // For GSON
        dishes = new ArrayList<>();
        createdAt = System.currentTimeMillis();
    }

    public Collection<Dish> getDishes() {
        if (dishes == null) {
            return new ArrayList<Dish>();
        }
        return dishes;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
