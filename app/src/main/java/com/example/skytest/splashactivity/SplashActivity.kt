package com.example.skytest.splashactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.skytest.R
import com.example.skytest.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashPb.visibility = View.VISIBLE
        setProgress()
    }

    fun setProgress(){
        Handler().postDelayed({
            splashPb.visibility = View.GONE
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
