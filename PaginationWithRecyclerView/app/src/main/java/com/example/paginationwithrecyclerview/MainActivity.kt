package com.example.paginationwithrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mainPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RecyclerViewAdapter(generateList(mainPage))
        paginationRecyclerView.adapter = adapter
        paginationRecyclerView?.layoutManager = LinearLayoutManager(this)
        /*paginationRecyclerView?.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageChange(page: Int) {
                println("page = $page")
                //adapter.addItems(generateList(page))

                Thread(Runnable {
                    try {
                        Thread.sleep(28)//small amount of delay,below 20 doesn't seem to work
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                    runOnUiThread {
                        adapter.addItems(generateList(page))
                    }
                }).start()
            }
        })*/

        nestedScrollView.viewTreeObserver?.addOnScrollChangedListener {

            val view = nestedScrollView.getChildAt(nestedScrollView.childCount - 1)

            val diff = view.bottom - (nestedScrollView.height + nestedScrollView.scrollY)

            if(diff == 0){
                adapter.addItems(generateList(mainPage))
            }

        }


    }

    private fun generateList(page: Int): ArrayList<String> {
        val arrayList = ArrayList<String>()
        for (i in 0..25) {
            arrayList.add("Item $i page $page")
        }

        mainPage++

        return arrayList
    }
}
