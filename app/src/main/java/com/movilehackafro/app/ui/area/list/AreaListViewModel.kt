package com.movilehackafro.app.ui.area.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movilehackafro.domain.models.Area
import com.movilehackafro.domain.repositories.AreaRepository
import kotlinx.coroutines.launch

class AreaListViewModel(
    private val areaRepository: AreaRepository
) : ViewModel() {
    private val _areas = MutableLiveData<List<Area>>()
    val areas: LiveData<List<Area>> = _areas

    private val _isListing = MutableLiveData<Boolean>()
    val isListing: LiveData<Boolean> = _isListing

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun listByDisciplineId(disciplineId: Long) {
        viewModelScope.launch {
            try {
                _isListing.value = true
                _areas.value = areaRepository.listByDisciplineId(disciplineId)
            } catch (e: Exception) {
                e.printStackTrace()
                _error.value = e
            } finally {
                _isListing.value = false
            }
        }
    }
}