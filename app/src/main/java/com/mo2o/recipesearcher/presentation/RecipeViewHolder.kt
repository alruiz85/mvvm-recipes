package com.mo2o.recipesearcher.presentation

import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.mo2o.recipesearcher.R
import com.mo2o.recipesearcher.domain.model.Recipe
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recipe_cell.view.*

class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(recipe: Recipe) {
        itemView.tvRecipeTitle.text = recipe.title
        itemView.tvIngredients.text = recipe.ingredients
        itemView.tvHref.text = recipe.href
        if (recipe.thumbnail.isNotEmpty()){
            Picasso.get().load(recipe.thumbnail).into(itemView.ivRecipe)
        }else{
            itemView.ivRecipe.setImageResource(R.mipmap.ic_launcher)
        }
        ViewCompat.setTransitionName(itemView.ivRecipe, recipe.title)
    }
}