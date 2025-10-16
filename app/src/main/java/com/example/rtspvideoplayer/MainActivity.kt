package com.example.rtspvideoplayer

import android.media.browse.MediaBrowser
import android.widget.MediaController
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.rtsp.RtspMediaSource
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private lateinit var videoPlayer: PlayerView
    private lateinit var player: ExoPlayer
    private lateinit var mediaItem: MediaItem
    private val rtspUri = "rtsp://dev.gradotech.eu:8554/stream"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        videoPlayer = findViewById(R.id.videoPlayer)

        player = ExoPlayer.Builder(applicationContext).build()
        videoPlayer.player = player

        val uri = rtspUri.toUri()
        mediaItem = MediaItem.fromUri(uri)

        val mediaSource = RtspMediaSource.Factory().createMediaSource(mediaItem)

        player.setMediaSource(mediaSource)
        player.prepare()
        player.playWhenReady = true
    }
}