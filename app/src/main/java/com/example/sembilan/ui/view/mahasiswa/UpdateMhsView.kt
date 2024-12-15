package com.example.sembilan.ui.view.mahasiswa

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sembilan.ui.viewModel.PenyediaViewModel
import com.example.sembilan.ui.viewModel.UpdateMhsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun UpdateMhsView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: UpdateMhsViewModel = viewModel(factory = PenyediaViewModel.Factory) //Inisialisasi ViewModel
) {
    val uiState = viewModel.updateUIState // ambil uistate dari viewmodel
    val snackbarHostState = remember { SnackbarHostState() } // snackbar state
    val coroutineScope = rememberCoroutineScope()

    // Observasi perubahan snackbar message
    LaunchedEffect(uiState.snackBarMessage) {
        println("Launched Effect Triggered")
        uiState.snackBarMessage?.let { message ->
            println("SnackBarMessage Received: $message")
            coroutineScope.launch{
                println("Launching courouting for snackbar")
                snackbarHostState.showSnackbar(
                    message = message,
                    duration = SnackbarDuration.Long
                )
                viewModel.resetsnackBarMessage()
            }
        }
    }

}