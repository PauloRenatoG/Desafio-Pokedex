package com.example.desafiopokedex.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.desafiopokedex.R
import com.example.desafiopokedex.databinding.ActivityMainBinding
import com.example.desafiopokedex.view.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
