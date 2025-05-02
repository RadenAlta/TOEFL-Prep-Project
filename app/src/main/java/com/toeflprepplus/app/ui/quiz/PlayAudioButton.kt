package com.toeflprepplus.app.ui.quiz

import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.toeflprepplus.app.ui.theme.TOEFLPrepPlusTheme
import androidx.compose.ui.platform.LocalContext

@Composable
fun PlayAudioButton(
    modifier: Modifier = Modifier
) {

    var isPlaying by remember { mutableStateOf(false) }

    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    val context = LocalContext.current

    DisposableEffect(key1 = isPlaying) {
        onDispose {
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    Button(
        onClick = {
            if (isPlaying) {
                mediaPlayer?.pause()
                isPlaying = false
            } else {
                mediaPlayer = MediaPlayer.create(context, com.toeflprepplus.app.R.raw.sample_audio)
                mediaPlayer?.start()
                isPlaying = true
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = if (isPlaying) "Pause Audio" else "Play Audio",
            fontSize = 18.sp
        )
    }

    if (!isPlaying) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Audio is paused",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayAudioButtonPreview() {
    TOEFLPrepPlusTheme {
        PlayAudioButton()
    }
}
