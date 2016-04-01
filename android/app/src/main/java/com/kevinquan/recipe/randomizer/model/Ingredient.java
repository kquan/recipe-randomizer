package com.kevinquan.recipe.randomizer.model;

import android.text.TextUtils;

import com.kevinquan.android.model.BaseGsonModel;

/**
 * Created by Kevin on 4/1/2016.
 */
public class Ingredient extends BaseGsonModel {

    @SuppressWarnings("Unused")
    private static final String TAG = Ingredient.class.getSimpleName();

    protected String name;
    protected String quantity;

    public Ingredient() {
        // For Gson
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override public int hashCode() {
        return ((TextUtils.isEmpty(name) ? "" : name) + (TextUtils.isEmpty(quantity) ? "" : quantity)).hashCode();
    }
}
