package com.example.my_bible.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.my_bible.R

class CustomerListAdapter(
    private var customers:MutableList<Customer>,
    private var onclick:(Customer)->Unit
): RecyclerView.Adapter<CustomerListAdapter.CustomerViewHolder>() {


    inner class CustomerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameView: TextView = itemView.findViewById(R.id.customerListItemName)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.customer_list_item,parent,false)
        return CustomerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = customers[position]
        holder.nameView.text = customer.name
        holder.itemView.findViewById<ConstraintLayout>(R.id.customerListItemLayout).setOnClickListener {
            onclick.invoke(customer)
        }
    }
}