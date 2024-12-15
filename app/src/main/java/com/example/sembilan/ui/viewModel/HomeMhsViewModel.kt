package com.example.sembilan.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sembilan.data.entity.Mahasiswa
import com.example.sembilan.repository.RepositoryMhs
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class HomeMhsViewModel(
    private val repositoryMhs: RepositoryMhs
) : ViewModel() {

    val homeUIState: StateFlow<HomeUiState> = repositoryMhs.getAllMhs()
        .filterNotNull()
        .map {
            HomeUiState(
                listMhs = it.toList(),
                isloading = false
            )
        }
        .onStart {
            emit(HomeUiState(isloading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeUiState(
                    isloading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiState(
                isloading = true
            )
        )

}

data class HomeUiState(
    val listMhs: List<Mahasiswa> = listOf(),
    val isloading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)