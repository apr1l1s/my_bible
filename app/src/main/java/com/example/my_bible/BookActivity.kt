package com.example.my_bible

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_bible.model.BookListAdapter

class BookActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<BookListAdapter.BookViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        val app = this.application.applicationContext as App
        val list = app.books
        findViewById<RecyclerView>(R.id.bookListView).apply{
            layoutManager = LinearLayoutManager(context)
            adapter = BookListAdapter(list) {
                app.currentBook = it
                val intent = Intent(this@BookActivity, RegActivity::class.java)
                startActivity(intent)
            }
        }




    }

}