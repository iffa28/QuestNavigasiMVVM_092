package com.example.project5.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project5.model.DataMahasiswa

@Composable
fun DetailMahasiswaView(
    modifier: Modifier = Modifier,
    uiStateMahasiswa: DataMahasiswa,
    onClickButton: () -> Unit
){
    val listDataMhs = listOf(
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Gender", uiStateMahasiswa.gender),
        Pair("Alamat", uiStateMahasiswa.alamat)
    )

    Column {
        listDataMhs.forEach { items ->
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }
    }
}
@Composable
fun CardSection(judulParam:String, isiParam:String){
    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween)//memberikan jarak ujung ke ujung
        {
            Text(text = judulParam, modifier = Modifier.weight(0.8f)) // weight untuk mengatur space isi data
            Text(text = " : ", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f))
        }
    }
}

