package com.baqynra.withbaqyand.customlistview

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    //a List of type hero for holding list items
    var heroList: MutableList<Hero>? = null

    //the listview
    var listView: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initializing objects
        heroList = ArrayList<Hero>()
        listView = findViewById<View>(R.id.listView) as ListView
        //adding some values to our list
        heroList!!.add(Hero(R.drawable.spiderman, "Spiderman", "Avengers"))
        heroList!!.add(Hero(R.drawable.joker, "Joker", "InjusticeGang"))
        heroList!!.add(Hero(R.drawable.ironman, "Iron Man", "Avengers"))
        heroList!!.add(Hero(R.drawable.doctorstrange, "Doctor Strange", "Avengers"))
        heroList!!.add(Hero(R.drawable.captainamerica, "Captain America", "Avengers"))
        heroList!!.add(Hero(R.drawable.batman, "Batman", "Justice League"))
        //creating the adapter
        val adapter = MyListAdapter(this, R.layout.my_custom_list,heroList)
        //attaching adapter to the listview
        listView!!.adapter = adapter
    }
}