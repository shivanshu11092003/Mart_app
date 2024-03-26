package com.example.kietmart

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kietmart.data.Books

class fashion_Recyclerview : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var BooksArrayLists: ArrayList<Books>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_recyclerview)
        changeStatusBarColor("#0074D9")

        recyclerview=findViewById(R.id.recyclerid)
        val imageArray= arrayOf(
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,
            R.drawable.fashion,


            )
        val booksname= arrayOf(
            "Product Name 1",
            "Product Name 2",
            "Product Name 3",
            "Product Name 4",
            "Product Name 5",
            "Product Name 6",
            "Product Name 7",
            "Product Name 8",
            "Product Name 9",
            "Product Name 10",
            "Product Name 11",
            "Product Name 12",
            "dbfebfg"
        )
        recyclerview.layoutManager = LinearLayoutManager(this)
        BooksArrayLists= arrayListOf<Books>()
        for(index in imageArray.indices){
            val news = Books(booksname[index],imageArray[index])
            BooksArrayLists.add(news)
        }


        var myAdapter= MyyAdapter(BooksArrayLists,this)
        recyclerview.adapter=myAdapter

    }
    private fun changeStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = android.graphics.Color.parseColor(color)
        }
    }
}