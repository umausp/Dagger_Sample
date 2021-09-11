package com.tb.dagger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tb.dagger.model.BeerDataModelItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TestViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val beerLiveData = MutableLiveData<List<BeerDataModelItem?>>()

    init {
        getBeerData()
    }

    private fun getBeerData() {
        viewModelScope.launch {
            val data = repository.getBeerData()
            when (data.isSuccessful) {
                true -> {
                    with(data.body().orEmpty()) {
                        beerLiveData.postValue(this)
                    }
                }
            }
        }

    }
}
