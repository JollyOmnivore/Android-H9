package com.example.hw9

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.hw9.R

// Recycler view requires a custom adapter
class ItemAdapter(private val itemAdapterListener: ItemAdapterListener) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    interface  ItemAdapterListener{
        fun click(position: Int)
    }



    class ViewHolder(itemView:View,private val itemAdapterListener: ItemAdapterListener) : RecyclerView.ViewHolder(itemView){//View holder takes the item layout
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                itemAdapterListener.click(position)
            }
        }
        private val textViewName:TextView = itemView.findViewById(R.id.bookName)
        private val textViewDescription:TextView = itemView.findViewById(R.id.bookDescription)
        private val textViewID:ImageView = itemView.findViewById(R.id.bookImage)// this gets switched for image view

        fun update(item:Item){
            textViewName.text = item.name.toString()
            textViewDescription.text = item.description.toString()
            textViewID.setImageResource(item.ImageReasourceID)
            textViewName.setBackgroundColor(Color.rgb(255, 165, 0))
            textViewDescription.setBackgroundColor(Color.rgb(255, 165, 0))
            textViewID.setBackgroundColor(Color.rgb(255, 165, 0))
        }
    }



    // you need to implement these 3 functions

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view,itemAdapterListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = Model.items[position]
        holder.update(item)
    }
    override fun getItemCount(): Int {
        return Model.items.size
    }

}
