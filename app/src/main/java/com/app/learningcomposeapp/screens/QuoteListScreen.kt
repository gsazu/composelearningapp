package com.app.learningcomposeapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.learningcomposeapp.models.Quote

@Preview
@Composable
fun QuoteListScreenPreview() {
    QuoteListScreen(arrayOf(
        Quote("dsdsd", "sddddsdasdsadasdsadadsadsadasdsadsadsadasdsadsadsadsadsa")
        //
    ))
}


@Composable
fun QuoteListScreen(data: Array<Quote>) {
    Card (elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        modifier = Modifier.fillMaxWidth().padding(4.dp)) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = "quote",
                colorFilter = ColorFilter.tint(color = Color.White),
                modifier = Modifier.rotate(180f).background(color = Color.Black).padding(all = 8.dp))
            Spacer(modifier = Modifier.size(10.dp))
            Column {
                Text(data.first().quote, style = TextStyle(
                    color = Color.Black, fontSize = 16.sp
                ))
                Spacer(modifier = Modifier.height(5.dp))
                Divider(thickness = 1.dp, color = Color.Gray,
                    modifier = Modifier.fillMaxWidth(0.5f))
                Spacer(modifier = Modifier.height(5.dp))
                Text(data.first().author, style = TextStyle(
                    color = Color.DarkGray, fontSize = 16.sp
                ))

            }

        }
    }
}