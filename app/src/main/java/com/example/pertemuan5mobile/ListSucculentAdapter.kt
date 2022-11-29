package com.example.pertemuan5mobile

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlin.collections.ArrayList


class ListSucculentAdapter(private val listSucculent: ArrayList<Succulent>) : //class with previous arraylist as parameter
    //extend recycleview adapter class into list viewholder
    RecyclerView.Adapter<ListSucculentAdapter.ListViewHolder>() {

    //declaring all view which for assigning other parameter later
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_subname)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        //declaring holder for click
        var clickSeeDetail: LinearLayout = itemView.findViewById(R.id.clickToDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        //immutable param for inflate layout to parent, and inflating each item row layout to parent
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        //returning listviewholder object with view parameter, contains view that will show when viewholder created
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        //returning the size of list of listsucculent class parameter
        return listSucculent.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //assigning array with specific position to immutable variable
        val succulent = listSucculent[position]

        //assigning data from array item data
        Glide.with(holder.itemView.context)
            .load(succulent.picture)
            .apply(RequestOptions().override(150, 150))
            .into(holder.imgPhoto)

        holder.tvName.text = succulent.name
        holder.tvDetail.text = succulent.common_name

        holder.clickSeeDetail.setOnClickListener {
            val context= holder.clickSeeDetail.context
            val SucculentDetailActivity = Intent(context, DetailedActivity::class.java)
            SucculentDetailActivity.putExtra("items",succulent)
            context.startActivity(SucculentDetailActivity)
        }
    }

}