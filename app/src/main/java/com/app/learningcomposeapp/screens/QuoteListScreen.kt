package com.app.learningcomposeapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.learningcomposeapp.models.Quote

@Preview
@Composable
fun QuoteListScreenPreview() {
    QuoteListScreen(arrayOf(
        Quote("dsdsd", "sdddds")
    ))
}


@Composable
fun QuoteListScreen(data: Array<Quote>) {
    Card (elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.padding(4.dp)) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = "quote")
        }
    }
}