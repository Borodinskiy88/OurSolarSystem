package ru.borodinskiy.aleksei.oursolarsystem

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.oursolarsystem.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout = binding.drawerLayout
        val navView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Передача каждого идентификатора меню как набора идентификаторов, поскольку каждый
        // меню следует рассматривать как пункты назначения верхнего уровня.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_photo_day,
                R.id.nav_sun, R.id.nav_mercury, R.id.nav_venus, R.id.nav_earth, R.id.nav_mars,
                R.id.nav_jupiter, R.id.nav_saturn, R.id.nav_uranus, R.id.nav_neptune
            ), drawerLayout
        )
        //Цветные иконки в меню
        navView.itemIconTintList = null
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Цвет нижней панели
        window.navigationBarColor = ContextCompat.getColor(this, R.color.black)
        //Цвет верхней панели
//        window.statusBarColor = ContextCompat.getColor(this, R.color.black)
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Раздуть меню; это добавляет элементы на панель действий, если она присутствует.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}