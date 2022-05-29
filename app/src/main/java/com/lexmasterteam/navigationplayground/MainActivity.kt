package com.lexmasterteam.navigationplayground

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lexmasterteam.navigationplayground.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var  navController: NavController
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration


    private lateinit var listener: NavController.OnDestinationChangedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.fragment)
        drawerLayout = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)

        binding.navigationView.setupWithNavController(navController)

        // robisz to po to, żeby pasek się zmianiał przy nawigacji
        setupActionBarWithNavController(navController,appBarConfiguration)

        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.fragment1->{
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.teal_200)))
                }
                R.id.fragment2->{
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.black)))
                }
                R.id.fragment3->{
                    supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.teal_700)))
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
    }
    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}