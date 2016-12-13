package org.paradrops.materialsample.view.top

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.paradrops.materialsample.R

class TopViewContentAdapter(private val context: Context) : RecyclerView.Adapter<TopViewContentAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
    var onItemClickListener: OnItemClickListener? = null

    private val items = arrayOf(
            "Activity Transition",
            "Fragment Transition",
            "Dialog Transition")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_top_content_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.index.text = (position + 1).toString()
        holder.title.text = items[position]

        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(it, position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val index: TextView
        val title: TextView

        init {
            this.index = itemView.findViewById(R.id.index) as TextView
            this.title = itemView.findViewById(R.id.title) as TextView
        }
    }
}