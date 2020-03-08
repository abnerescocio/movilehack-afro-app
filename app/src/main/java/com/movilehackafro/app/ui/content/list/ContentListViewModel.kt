package com.movilehackafro.app.ui.content.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movilehackafro.domain.models.Content
import com.movilehackafro.domain.repositories.ContentRepository
import kotlinx.coroutines.launch

class ContentListViewModel(
    private val contentRepository: ContentRepository
) : ViewModel() {
    private val _contents = MutableLiveData<List<Content>>()
    val contents: LiveData<List<Content>> = _contents

    private val _isListing = MutableLiveData<Boolean>()
    val isListing: LiveData<Boolean> = _isListing

    private val _error = MutableLiveData<Exception>()
    val error: LiveData<Exception> = _error

    fun list(schoolId: Long, disciplineId: Long) {
        viewModelScope.launch {
            try {
                _isListing.value = true
                _contents.value = contentRepository.list(schoolId, disciplineId)
            } catch (e: Exception) {
                e.printStackTrace()
                _error.value = e
            } finally {
                _isListing.value = false
            }
        }
    }
}