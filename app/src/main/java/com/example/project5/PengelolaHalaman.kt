package com.example.project5

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project5.model.DataJenisKelamin
import com.example.project5.ui.view.DetailMahasiswaView
import com.example.project5.ui.view.FormMahasiswaView
import com.example.project5.ui.viewmodel.MahasiswaViewModel

enum class Halaman{
    Form,
    Data
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    viewModel: MahasiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    Scaffold { isipadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            modifier = modifier.padding(isipadding),
            navController = navHost, startDestination = Halaman.Form.name)
        {
            composable(route = Halaman.Form.name){
                val konteks = LocalContext.current
                FormMahasiswaView(
                    listJK = DataJenisKelamin.listJK.map {
                        list -> konteks.resources.getString(list)
                    },
                    onSubmitClicked = {
                        viewModel.saveDataMahasiswa(it)
                        navHost.navigate(Halaman.Data.name)
                    }
                )
            }
            composable(route = Halaman.Data.name){
                DetailMahasiswaView(
                    uiStateMahasiswa = uiState,
                ) { }
            }
        }

    }
}