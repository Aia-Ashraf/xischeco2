package com.aashraf.mainscreenmodule.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aashraf.mainscreenmodule.R

class MainListAdapter(private val items: List<String>) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val nextArrowImageView: ImageView = view.findViewById(R.id.nextArrowImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = items[position] // Set the title
        holder.descriptionTextView.text = "Description for ${items[position]}" // Set the description
//        holder.nextArrowImageView.setImageResource(R.drawable.ic_next_arrow) // Set the next arrow icon
    }

    override fun getItemCount() = items.size
}