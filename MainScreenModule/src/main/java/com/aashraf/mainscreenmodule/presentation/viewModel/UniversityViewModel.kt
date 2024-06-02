package com.aashraf.mainscreenmodule.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aashraf.mainscreenmodule.data.dataModel.University
import com.aashraf.mainscreenmodule.usecase.GetUniversitiesUseCase
import javax.inject.Inject

class UniversityViewModel @Inject constructor(
    private val getUniversitiesUseCase: GetUniversitiesUseCase
) : ViewModel() {
    private val _universities = MutableLiveData<List<University>>()
    val universities: LiveData<List<University>> = _universities

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    suspend fun getUniversities() {
            try {
                val universities = getUniversitiesUseCase()
                _universities.value = universities
            } catch (e: Exception) {
                _error.value = e.message ?: "Unknown error"
            }
    }
}