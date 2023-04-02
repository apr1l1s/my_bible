package com.example.my_bible

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_bible.model.BookListAdapter
import com.example.my_bible.model.CustomerListAdapter


class CustomerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        val app = this.application.applicationContext as App
        val list = app.customers
        findViewById<RecyclerView>(R.id.customerListView).apply{
            layoutManager = LinearLayoutManager(context)
            adapter = CustomerListAdapter(list) {
                app.currentCustomer = it
                val intent = Intent(this@CustomerActivity, RegActivity::class.java)
                startActivity(intent)
            }
        }
    }
}