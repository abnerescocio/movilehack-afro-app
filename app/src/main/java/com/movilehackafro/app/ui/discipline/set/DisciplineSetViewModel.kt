package com.movilehackafro.app.ui.discipline.set

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movilehackafro.domain.models.Discipline
import com.movilehackafro.domain.repositories.DisciplineRepository
import kotlinx.coroutines.launch

class DisciplineSetViewModel(
    private val disciplineRepository: DisciplineRepository
) : ViewModel() {

    private val _isSetting = MutableLiveData<Boolean>()
    val isSetting: LiveData<Boolean> = _isSetting

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun set(disciplines: List<Discipline>) {
        viewModelScope.launch {
            try {
                _isSetting.value = true
                disciplineRepository.set(disciplines)
            } catch (e: Exception) {
                e.printStackTrace()
                _error.value = e
            } finally {
                _isSetting.value = false
            }
        }
    }

}