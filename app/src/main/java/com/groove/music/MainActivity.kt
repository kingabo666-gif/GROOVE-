package com.groove.music

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.common.MediaItem

class MainActivity : Activity() {

    private var player: ExoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        player = ExoPlayer.Builder(this).build()

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(30, 30, 30, 30)
            setBackgroundColor(Color.BLACK)
        }

        val title = TextView(this).apply {
            text = "GROOVE"
            textSize = 38f
            setTextColor(Color.RED)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "YOUR MUSIC. YOUR VIBE."
            textSize = 15f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val playButton = Button(this).apply {
            text = "PLAY MUSIC"
            setOnClickListener {
                val songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
                val item = MediaItem.fromUri(songUrl)
                player?.setMediaItem(item)
                player?.prepare()
                player?.play()
            }
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(playButton)

        setContentView(layout)
    }

    override fun onDestroy() {
        player?.release()
        player = null
        super.onDestroy()
    }
}