package com.example.sembilan.ui.view.mahasiswa

import android.R.attr.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sembilan.ui.costumwidget.TopAppBar
import com.example.sembilan.ui.viewModel.PenyediaViewModel
import com.example.sembilan.ui.viewModel.UpdateMhsViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }, //tempatkan snackbar di scaffold
        topBar = {
            TopAppBar(
                judul = "Edit Mahasiswa",
                showBackButton = true,
                onBack = onBack,
            )
        }
    ){ padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ){

            //Isi Body
            InsertBodyMhs(
                uiState = uiState,
                onValueChange = {updatedEvent ->
                    viewModel.updateState(updatedEvent) //update state di viewmodel
                },
                onClick = {
                    coroutineScope.launch{
                        if (viewModel.validateFields()) {
                            viewModel.updateData()
                            delay(600)
                            withContext(Dispatchers.Main){
                                onNavigate() // Navigasi di main thread
                            }
                        }
                    }
                }
            )

        }

    }
}