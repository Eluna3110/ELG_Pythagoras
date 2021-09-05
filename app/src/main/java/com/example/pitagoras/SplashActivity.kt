package com.example.pitagoras

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.pitagoras.databinding.SplashBinding

class SplashActivity : AppCompatActivity()
{
    private lateinit var binding : SplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.splash)

        binding.animationView.imageAssetsFolder = "assets"
        binding.animationView.setAnimation("animation_lottie.json")
        binding.animationView.repeatCount = 8
        binding.animationView.playAnimation()

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
                this@SplashActivity.startActivity(mainIntent)
                this@SplashActivity.finish()
                binding.animationView.cancelAnimation()
            }, 2000)
    }
}