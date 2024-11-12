package com.emart.groceriesstore.presentation.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.emart.groceriesstore.data.repository.RecipeRepository
import com.emart.groceriesstore.domain.models.RecipeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    private var _recipesList: MutableLiveData<List<RecipeModel>> =
        recipeRepository.getFromLocal().stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        ).asLiveData() as MutableLiveData<List<RecipeModel>>
    val recipesList: LiveData<List<RecipeModel>> = _recipesList

}
