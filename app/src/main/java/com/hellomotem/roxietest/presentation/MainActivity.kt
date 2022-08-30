package com.hellomotem.roxietest.presentation

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.hellomotem.roxietest.R
import com.hellomotem.roxietest.databinding.ActivityMainBinding
import com.hellomotem.roxietest.presentation.ui.OrderDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun showOrderDetailsScreen() {
        val fragment = OrderDetailFragment()
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.fade_in,
                R.anim.fade_out
            )
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        back()
        return super.onSupportNavigateUp()
    }

    override fun back() {
        supportFragmentManager.popBackStack()
    }
}