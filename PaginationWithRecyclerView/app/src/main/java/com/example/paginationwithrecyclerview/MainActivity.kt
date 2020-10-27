package com.example.paginationwithrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        /*adapter.dendede(object : RecyclerViewAdapter.OnBottomReachedListener{
            override fun onBottomReached(position: Int) {
                adapter.addItems(generateList(mainPage))
            }
        })
        nestedScrollView.viewTreeObserver?.addOnScrollChangedListener {

            val view = nestedScrollView.getChildAt(nestedScrollView.childCount - 1)

            val diff = view.bottom - (nestedScrollView.height + nestedScrollView.scrollY)

            if(diff == 0){
                adapter.addItems(generateList(mainPage))
            }


        }*/

        nestedScrollView.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener{
            override fun onScrollChange(
                v: NestedScrollView?,
                scrollX: Int,
                scrollY: Int,
                oldScrollX: Int,
                oldScrollY: Int
            ) {
                var aa = v?.getChildAt(0)?.measuredHeight
                var bbb = v?.measuredHeight

                aa?.let {
                    if(scrollY == (aa - bbb!!)){
                        val aff = generateList(mainPage)
                        adapter.addItems(aff)
                    }
                } ?: run{

                }


            }
        })

        /*var a = 0

        paginationRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val ll = paginationRecyclerView.layoutManager as LinearLayoutManager

                a = ll.findLastCompletelyVisibleItemPosition()
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if(a == 25)
                    Toast.makeText(applicationContext, "awfafa", Toast.LENGTH_LONG).show()
            }
        })*/

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
