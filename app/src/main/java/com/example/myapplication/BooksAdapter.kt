package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val booklist:ArrayList<Books>)
    :RecyclerView.Adapter<BookAdapter.BookViewHolder>(){

    class BookViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.poto)
        val textView:TextView=itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.fragment_wignebis,parent,false)
        return BookViewHolder(view)

    }
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book=booklist[position]
        holder.imageView.setImageResource(book.image)
        holder.textView.text=book.name



    }


    override fun getItemCount(): Int {
       return booklist.size

    }



}