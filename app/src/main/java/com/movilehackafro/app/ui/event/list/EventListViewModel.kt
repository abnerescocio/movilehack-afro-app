package com.movilehackafro.app.ui.event.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movilehackafro.domain.models.Event
import com.movilehackafro.domain.repositories.EventRepository
import kotlinx.coroutines.launch

class EventListViewModel(
    private val eventRepository: EventRepository
) : ViewModel() {
    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> = _events

    private val _isListing = MutableLiveData<Boolean>()
    val isListing: LiveData<Boolean> = _isListing

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun list(schoolId: Long) {
        viewModelScope.launch {
            try {
                _isListing.value = true
                _events.value = eventRepository.list(schoolId)
            } catch (e: Exception) {
                e.printStackTrace()
                _error.value = e
            } finally {
                _isListing.value = false
            }
        }
    }
}