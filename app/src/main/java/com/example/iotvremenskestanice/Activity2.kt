package com.example.iotvremenskestanice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.AdapterView
import android.view.View




class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val al = ArrayList<Book>()
        val myObj = Book()

        al.add(myObj)
        //System.out.println(myObj.name)

        val arr = arrayOf(Book(),Book(),Book(),Book())

        val gridView = findViewById(R.id.gridView) as GridView
        val booksAdapter = BooksAdapter(this, arr)
        gridView.adapter = booksAdapter

        gridView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val book = booksAdapter.books[position]
                book.name = " ROBERT ";

                // This tells the GridView to redraw itself
                // in turn calling your BooksAdapter's getView method again for each cell
                booksAdapter.notifyDataSetChanged()
            }
        }
    }
}
