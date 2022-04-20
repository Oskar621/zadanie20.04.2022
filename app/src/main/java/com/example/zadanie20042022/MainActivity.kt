package com.example.zadanie20042022

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val przyciskzdj = findViewById<ImageButton>(R.id.imageButton)
        val kolorRed = findViewById<Button>(R.id.buttonRed)
        val kolorGreen = findViewById<ToggleButton>(R.id.toggleButtonGreen)

        przyciskzdj.setOnClickListener {
            przyciskzdj.setImageResource(R.drawable.maxresdefault)
        }
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.fototapety_ork_nerwowy_portret_twarz_jpg)
        val bitmapczerwony = BitmapFactory.decodeResource(resources, R.drawable._17830_2)
        val filterbitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)

        kolorRed.setOnClickListener {
            val paint = Paint()
            paint.alpha = 100
            val canvas = Canvas(filterbitmap)
            canvas.drawARGB(0,0,0,0)
            canvas.drawBitmap(bitmapczerwony, null, RectF(0f,0f,bitmap.width.toFloat(), bitmap.height.toFloat()),paint)
            canvas.drawBitmap(bitmap,0f,0f,paint)
            przyciskzdj.setImageBitmap(filterbitmap)
        }
        kolorGreen.setOnClickListener {
            if(kolorGreen.isChecked)
            {
                przyciskzdj.setColorFilter(R.color.zielonyjasny)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context,R.color.zielonyjasny))
            }
            else
            {
                przyciskzdj.setColorFilter(null)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.zielonyciemny))
            }
        }

    }
}