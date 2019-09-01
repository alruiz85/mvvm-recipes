package com.mo2o.recipesearcher.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mo2o.recipesearcher.R
import com.mo2o.recipesearcher.domain.model.Recipe

class RecipesAdapter: RecyclerView.Adapter<RecipeViewHolder>() {

    private var recipes : List<Recipe> = listOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): RecipeViewHolder {
        val view =  LayoutInflater.from(viewGroup.context).inflate(R.layout.recipe_cell, viewGroup, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    override fun onBindViewHolder(viewHolder: RecipeViewHolder, position: Int) {
        viewHolder.bind(recipes[position])
    }

    fun addRecipes(recipes: List<Recipe>) {
        this.recipes = recipes
        notifyDataSetChanged()
    }
}