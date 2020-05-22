package com.example.kadesubmission1

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(private var items: List<Item>, private var listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(ItemList().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val leagueImg: ImageView = view.findViewById(R.id.imgId)
        private val leagueName: TextView = view.findViewById(R.id.nameId)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            items.image?.let { Picasso.get().load(it).fit().into(leagueImg) }
            leagueName.text = items.name
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}