package com.example.m1andm2_diksha

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.m1andm2_diksha.databinding.ActivityHomeRecyclerBinding
import com.example.m1andm2_diksha.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeRecycler : AppCompatActivity() {

//    BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

    private lateinit var binding : ActivityHomeRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityHomeRecyclerBinding.inflate(layoutInflater)
        val view =binding.root
       // for the default view in fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, HomeFragment()).commit()

        setContentView(view)

        binding.bottomNav.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home_menu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, HomeFragment())
                        .commit()
                }

                R.id.home_menu2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MessageFragment())
                        .commit()
                }

                R.id.home_menuu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FabFragment())
                        .commit()
                }

                R.id.home_menu3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ChatFragment())
                        .commit()
                }

                R.id.home_menu4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AccountFragment())
                        .commit()
                }

            }
            return@setOnItemSelectedListener true
        }
    }
}