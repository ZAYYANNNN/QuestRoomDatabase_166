package com.example.sembilan.ui.view.mahasiswa

import android.R.attr.text
import android.R.attr.title
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier = Modifier
){
    AlertDialog(onDismissRequest = { /* Do Nothing */}),
    title = { Text("Delete Data") },
    text = {Text("Apakah Anda Yakin Ingin Menghapus Data?") },
    modifier = modifier,
    dismissButton = {
        TextButton(onClick = onDeleteCancel) {
            Text(text = "Cancel")
        }
    },
    confirmButton = {
        TextButton(onClick = onDeleteConfirm) {
            Text(text = "Yes")
        }
    }

}