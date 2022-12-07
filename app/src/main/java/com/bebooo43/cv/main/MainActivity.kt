package com.bebooo43.cv.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bebooo43.cv.R
import com.bebooo43.cv.databinding.ActivityMainBinding
import com.bebooo43.cv.utils.openExternalApp
import com.bebooo43.cv.utils.sendEmail
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.home_tab_title)
                1 -> tab.text = getString(R.string.about_tab_title)
                2 -> tab.text = getString(R.string.work_tab_title)
                3 -> tab.text = getString(R.string.contact_tab_title)
            }
        }.attach()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.telegramBtn -> openExternalApp("http://www.telegram.me/DDefalt")
            R.id.linkedinBtn -> openExternalApp("https://www.linkedin.com/in/abanoub-n-george/")
            R.id.whatsappBtn -> openExternalApp("https://api.whatsapp.com/send?phone=+16412332395")
            R.id.gmailBtn -> sendEmail(arrayListOf("Abanoub.N.George@gmail.com"), "", "")
        }
        return super.onOptionsItemSelected(item)
    }
}