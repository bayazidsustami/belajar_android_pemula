package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)
        list.addAll(HeroesData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallBack { data -> showSelectedHero(data) }
    }

    private fun showSelectedHero(hero: Hero) { //Toast.makeText(this, "Kamu memilih " + hero.getName(), Toast.LENGTH_SHORT).show();
        val intent = Intent(this@MainActivity, Main2Activity::class.java)
        intent.putExtra(Main2Activity.EXTRA_NAME, hero.name)
        intent.putExtra(Main2Activity.EXTRA_DETAIL, hero.detail)
        intent.putExtra(Main2Activity.EXTRA_PHOTO, hero.photo)
        intent.putExtra(Main2Activity.EXTRA_LINK, hero.linkBio)
        startActivity(intent)
    }
}