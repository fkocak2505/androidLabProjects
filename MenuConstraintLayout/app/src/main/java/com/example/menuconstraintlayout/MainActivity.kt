package com.example.menuconstraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        feedSortedClose.setOnClickListener{
            feedSortedClose.visibility = View.GONE
            feedSortedOpen.visibility = View.VISIBLE

            rootConsLayout.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.deneme))

        }


        closeSortedMenu.setOnClickListener{
            feedSortedOpen.visibility = View.GONE
            feedSortedClose.visibility = View.VISIBLE

            rootConsLayout.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))

        }

        popularitySort.setOnClickListener{
            dateSort.background = resources.getDrawable(R.drawable.unselected_sort)
            dateSort.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
            dateSort.compoundDrawablePadding = 0
            dateSort.setTextColor(ContextCompat.getColor(applicationContext, R.color.unSelectedTextColor))

            popularitySort.background =
                resources.getDrawable(R.drawable.selected_sort)
            popularitySort.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_ok,
                0
            )
            popularitySort.compoundDrawablePadding = 5
            popularitySort.setTextColor(ContextCompat.getColor(applicationContext, R.color.selectedTextColor))

        }

        dateSort.setOnClickListener{
            dateSort.background = resources.getDrawable(R.drawable.selected_sort)
            dateSort.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_ok, 0)
            dateSort.compoundDrawablePadding = 5
            dateSort.setTextColor(ContextCompat.getColor(applicationContext, R.color.selectedTextColor))

            popularitySort.background =
                resources.getDrawable(R.drawable.unselected_sort)
            popularitySort.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
            popularitySort.compoundDrawablePadding = 0
            popularitySort.setTextColor(ContextCompat.getColor(applicationContext, R.color.unSelectedTextColor))
        }

    }
}
