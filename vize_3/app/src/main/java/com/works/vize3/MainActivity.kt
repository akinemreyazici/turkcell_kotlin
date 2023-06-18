package com.works.vize3


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favourites -> {
                // NavController ile FavouritesFragment'a yönlendirme yap
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.favouritesFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
