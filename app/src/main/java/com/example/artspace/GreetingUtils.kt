package com.example.artspace

import android.graphics.fonts.FontStyle
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Year

// Define a simple data class. NOTE  don't use curly brackets because data classes are designed to store data and are mostly immutable

@Composable
fun ArtInfo(){
    var currentResult by remember { mutableStateOf(5) }
    val onPrevious = { currentResult = if (currentResult == 1) 5 else currentResult - 1}
    val onNext = { currentResult = if (currentResult == 1) 5 else currentResult - 1}

    val (triple, artist) = when (currentResult) {
        1 -> Triple(stringResource(R.string.Monalisa), 1519, R.drawable.image_one) to "Leonardo da Vinci"
        2 -> Triple(stringResource(R.string.sunflower_vase), 1889, R.drawable.image_two) to stringResource(R.string.vincent_van_gogh)
        3 -> Triple(stringResource(R.string.the_stary_night), 1889, R.drawable.image_three) to stringResource(R.string.vincent_van_gogh)
        4 -> Triple(stringResource(R.string.changeing_trees), 1885, R.drawable.image_four) to stringResource(R.string.vincent_van_gogh)
        else -> Triple(stringResource(R.string.sunflower), 1889, R.drawable.image_five) to stringResource(R.string.vincent_van_gogh)
    }

    val (titleResource, yearResource, imageResource) = triple

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(350.dp)
                .background(Color(0xFFF0F0F0))
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp) // Ensures the image fills the Box
                    .align(Alignment.Center) // Centers the image in the Box
            )
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth() // Column takes the full width
                .padding(16.dp) // Add padding to content inside the column
        ) {
            Text(
                text = titleResource,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold,letterSpacing = 0.5.sp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = yearResource.toString(),
                    style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 20.sp),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = artist,
                    style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 20.sp),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = onPrevious, modifier = Modifier.padding(8.dp)) {Text("Previous")}
            Button(onClick = onNext, modifier = Modifier.padding(8.dp)) {Text("Next")}
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        contentAlignment = Alignment.Center
    ) {
        ArtInfo()
    }
}