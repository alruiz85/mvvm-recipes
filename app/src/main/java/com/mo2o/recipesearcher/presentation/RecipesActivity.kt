package com.mo2o.recipesearcher.presentation

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mo2o.recipesearcher.R
import com.mo2o.recipesearcher.domain.model.Recipe
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class RecipesActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    @Inject
    lateinit var recipesViewModelFactory: RecipesViewModelFactory

    lateinit var recipesViewModel: RecipesViewModel

    private val recipesAdapter = RecipesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpViewModel()
        setUpObserver()
        recipesViewModel.search()
    }

    private fun setUpObserver() {
        //Recipes
        recipesViewModel.getRecipes().observe(this, Observer {
            if (it.isNotEmpty()) {
                updateRecipes(it)
            } else {
                showError()
            }
        })

        //Error
        recipesViewModel.getError().observe(this, Observer {
            showError(it)
        })
    }

    private fun setUpViewModel() {
        recipesViewModel = ViewModelProviders.of(this, recipesViewModelFactory).get(RecipesViewModel::class.java)
    }


    private fun setUpRecyclerView() {
        recipesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@RecipesActivity)
            adapter = recipesAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        val searchItem = menu.findItem(R.id.menu_search)
        val searchView = searchItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    // region OnQueryTextListener

    override fun onQueryTextSubmit(textUpdate: String): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        recipesViewModel.search(newText)
        return true
    }

    // endregion

    // region RecipeView

    fun updateRecipes(recipes: List<Recipe>) {
        recipesRecyclerView.visibility = View.VISIBLE
        textNotFound.visibility = View.GONE
        recipesAdapter.addRecipes(recipes)
    }

    fun showError() {
        Toast.makeText(this, "Something goes wrong...", Toast.LENGTH_SHORT).show()
    }

    fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    fun noRecipesFound() {
        recipesRecyclerView.visibility = View.GONE
        textNotFound.visibility = View.VISIBLE
    }

    // endregion
}
