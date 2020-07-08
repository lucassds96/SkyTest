package com.example.skytest.ui.splashactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.skytest.R
import com.example.skytest.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setProgress()
    }

    private fun setProgress(){
        Handler().postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
