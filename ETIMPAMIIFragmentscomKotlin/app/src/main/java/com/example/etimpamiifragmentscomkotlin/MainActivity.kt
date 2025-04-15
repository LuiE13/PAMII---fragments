package com.example.etimpamiifragmentscomkotlin

import android.os.Bundle
import android.widget.TableLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.etimpamiifragmentscomkotlin.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        enableEdgeToEdge()
        setContentView(view)

        binding.tableLayout.addOnTabSelectedListener(
            object: TabLayout.OnTabSelectedListener{
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when(tab?.position){
                        0-> supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragmentConteinerView, FirstFragment())
                            .commit()
                        1-> supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragmentConteinerView, SecondFragment())
                            .commit()
                        2-> supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragmentConteinerView, ThirdFragment())
                            .commit()
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            }

        )
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}