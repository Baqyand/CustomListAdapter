package com.baqynra.withbaqyand.customlistview

import android.app.AlertDialog
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


//we need to extend the ArrayAdapter class as we are building an adapter
class MyListAdapter(//activity context
    private var context: Context, //the layout resource file for the list items
    var resource: Int, heroList: List<Hero>
) :
    ArrayAdapter<Hero?>(context, resource, heroList) {
    //the list values in the List of type hero
    var heroList: List<Hero>

    //this will return the ListView Item as a View
    override fun getView(
        position: Int, convertView: View?,
        parent: ViewGroup
    ): View {
//we need to get the view of the xml for our list item
//And for this we need a layoutinflater
        val layoutInflater = LayoutInflater.from(context)
        //getting the view
        val view = layoutInflater.inflate(resource, null, false)
        //getting the view elements of the list from the view
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewTeam = view.findViewById<TextView>(R.id.textViewTeam)
        val buttonDelete = view.findViewById<Button>(R.id.buttonDelete)
        //getting the hero of the specified position
        val hero = heroList[position]
        //adding values to the list item
        imageView.setImageDrawable(context.resources.getDrawable(hero.image))
        textViewName.text = hero.name
        textViewTeam.text = hero.team
        //adding a click listener to the button to remove item from the list
        buttonDelete.setOnClickListener { //we will call this method to remove the selected value from the list
            //we are passing the position which is to be removed in the method
            removeHero(position)
        }
        //finally returning the view
        return view
    }

    //this method will remove the item from the list
    private fun removeHero(position: Int) {
//Creating an alert dialog to confirm the deletion
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Are you sure you want to delete this?")
        //if the response is positive in the alert
        builder.setPositiveButton(
            "Yes"
        ) { dialogInterface, i -> //removing the item
            heroList.removeAt(position)

            //reloading the list
            notifyDataSetChanged()
        }
        //if response is negative nothing is being done
        builder.setNegativeButton(
            "No"
        ) { dialogInterface, i -> }
        //creating and displaying the alert dialog
        val alertDialog = builder.create()
        alertDialog.show()
    }

    //constructor initializing the values
    init {
        resource = resource
        this.heroList = heroList
    }

}