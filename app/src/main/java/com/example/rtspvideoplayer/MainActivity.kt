package com.example.rtspvideoplayer

import android.widget.MediaController
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.VideoView
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    private lateinit var videoPlayer: VideoView
    private lateinit var mediaController: MediaController
    private val rtspUri = "rtsp://dev.gradotech.eu:8554/stream"
    private val videoUri= "https://videos.pexels.com/video-files/8392764/8392764-hd_1080_1920_25fps.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        videoPlayer = findViewById(R.id.videoPlayer)

        val uri = videoUri.toUri()

        videoPlayer.setVideoURI(uri)

        mediaController = MediaController(this)
        mediaController.setAnchorView(videoPlayer)
        mediaController.setMediaPlayer(videoPlayer)

        videoPlayer.setMediaController(mediaController)
        videoPlayer.start()
    }

}