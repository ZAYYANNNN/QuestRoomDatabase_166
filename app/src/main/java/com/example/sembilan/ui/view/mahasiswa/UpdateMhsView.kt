package com.example.sembilan.ui.view.mahasiswa

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sembilan.ui.viewModel.PenyediaViewModel
import com.example.sembilan.ui.viewModel.UpdateMhsViewModel

@Composable
fun UpdateMhsView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateMhsViewModel = viewModel(factory = PenyediaViewModel.Factory) //Inisialisasi ViewModel
) {


}