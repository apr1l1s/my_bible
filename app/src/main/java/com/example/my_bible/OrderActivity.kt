package com.example.my_bible

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_bible.model.BookListAdapter
import com.example.my_bible.model.OrderListAdapter

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val app = this.application.applicationContext as App
        val list = app.orders
        findViewById<RecyclerView>(R.id.orderListView).apply{
            layoutManager = LinearLayoutManager(context)
            adapter = OrderListAdapter(list)
        }
        val bb = findViewById<Button>(R.id.backButton).setOnClickListener{
            app.currentCustomer = null
            app.currentBook = null
            app.currentDate = null
            val intent = Intent(this@OrderActivity, RegActivity::class.java)
            startActivity(intent)
        }
    }
}