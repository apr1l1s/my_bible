package com.example.my_bible.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.my_bible.R

class OrderListAdapter(
    private var orders:MutableList<Order>
): RecyclerView.Adapter<OrderListAdapter.OrderViewHolder>() {


    inner class OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val titleView: TextView = itemView.findViewById(R.id.orderListItemTitle)
        val customerView: TextView = itemView.findViewById(R.id.orderListItemName)
        val dateView: TextView = itemView.findViewById(R.id.orderListItemDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_list_item,parent,false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.titleView.text = order.book.title
        holder.customerView.text = order.customer.name
        holder.dateView.text = order.date
    }
}