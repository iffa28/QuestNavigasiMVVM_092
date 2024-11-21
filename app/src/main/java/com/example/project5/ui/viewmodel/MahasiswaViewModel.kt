package com.example.project5.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.project5.model.DataMahasiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MahasiswaViewModel : ViewModel() {  //dinyatakan class viewmodel krn inheritnya
    //Request
    private val _uiState = MutableStateFlow(DataMahasiswa())
    val uiState:StateFlow<DataMahasiswa> = _uiState.asStateFlow()

    fun saveDataMahasiswa(listDM: List<String>) {
        _uiState.update { dataMhs ->
            dataMhs.copy(
                nama = listDM[0],
                gender = listDM[1],
                alamat = listDM[2]
            )
        }
    }
}