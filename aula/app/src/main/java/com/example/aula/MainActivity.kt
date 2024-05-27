package com.example.aula

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.activity_main))

        val minhaImagem =  findViewById<ImageView>(R.id.imagemApp)

        getPhoto(intent, minhaImagem, this)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val minhaImagem =  findViewById<ImageView>(R.id.imagemApp)

        getPhoto(intent, minhaImagem, this)
    }

    fun getPhoto(intent: Intent, image: ImageView, context: Context) {
        val uriImage = intent?.getParcelableExtra(Intent.EXTRA_STREAM, Uri::class.java)

        Glide.with(context).load(uriImage).into(image)
    }

}