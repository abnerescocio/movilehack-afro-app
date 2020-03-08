package com.movilehackafro.app.ui.discipline.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movilehackafro.domain.models.Discipline
import com.movilehackafro.domain.repositories.DisciplineRepository
import kotlinx.coroutines.launch

class DisciplineListViewModel(
    private val disciplineRepository: DisciplineRepository
) : ViewModel() {

    private val _disciplines = MutableLiveData<List<Discipline>>()
    val disciplines: LiveData<List<Discipline>> = _disciplines

    private val _isListing = MutableLiveData<Boolean>()
    val isListing: LiveData<Boolean> = _isListing

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun list() {
        viewModelScope.launch {
            try {
                _isListing.value = true
                _disciplines.value = disciplineRepository.list()
            } catch (e: Exception) {
                e.printStackTrace()
                _error.value = e
            } finally {
                _isListing.value = false
            }
        }
    }
}