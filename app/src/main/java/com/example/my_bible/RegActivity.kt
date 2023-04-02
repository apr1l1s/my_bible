package com.example.my_bible

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.my_bible.model.Order
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        val bb =  findViewById<Button>(R.id.openBooksButton)
        val cb = findViewById<Button>(R.id.openCustomersButton)
        val rb = findViewById<Button>(R.id.regButton)
        val db = findViewById<Button>(R.id.dateButton)
        val app = this.application.applicationContext as App
        if (app.currentBook !=null){
            bb.text = app.currentBook!!.title
        }
        if (app.currentCustomer!=null){
            cb.text = app.currentCustomer!!.name
        }
        bb.setOnClickListener {
            val intent = Intent(this@RegActivity,BookActivity::class.java)
            startActivity(intent)
        }
        cb.setOnClickListener {
            val intent = Intent(this@RegActivity,CustomerActivity::class.java)
            startActivity(intent)
        }
        rb.setOnClickListener {
            if (app.checkOrder()){
                app.orders.add(Order(app.currentCustomer!!, app.currentBook!!, app.currentDate!!))
                val intent = Intent(this@RegActivity,OrderActivity::class.java)
                startActivity(intent)
            }

        }
        db.setOnClickListener {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, _, _, _ ->
                val sdf = SimpleDateFormat("dd.MM.yyyy")
                db.text = sdf.format(c.timeInMillis)
                app.currentDate = sdf.format(c.timeInMillis)
            }, year, month, day)
            dpd.show()
        }


    }
}