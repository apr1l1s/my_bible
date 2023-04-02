package com.example.my_bible.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.my_bible.R

class BookListAdapter(
    private var books:MutableList<Book>,
    private var onclick:(Book)->Unit
):RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {


    inner class BookViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val titleView: TextView = itemView.findViewById(R.id.bookListItemTitle)
        val authorView: TextView = itemView.findViewById(R.id.bookListItemAuthor)
        val dateView: TextView = itemView.findViewById(R.id.bookListItemDate)
        val pageView: TextView = itemView.findViewById(R.id.bookListItemPageCount)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_list_item,parent,false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
       return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.titleView.text = book.title
        holder.authorView.text = book.author
        holder.dateView.text = book.date
        holder.pageView.text = book.page_que.toString()
        holder.itemView.findViewById<ConstraintLayout>(R.id.bookListItemLayout).setOnClickListener {
            onclick.invoke(book)
        }
    }
}