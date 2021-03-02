package com.example.androiddevchallenge

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun MatchHorizontal(arrangement: Arrangement.HorizontalOrVertical = Arrangement.Center, internal: @Composable () -> Unit) {
    Row(
        horizontalArrangement = arrangement, modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 4.dp)
    ) {
        internal()
    }
}

fun toast(str: String) = GlobalScope.launch(Dispatchers.Main) {
    Toast.makeText(app, str, Toast.LENGTH_SHORT).show()
}