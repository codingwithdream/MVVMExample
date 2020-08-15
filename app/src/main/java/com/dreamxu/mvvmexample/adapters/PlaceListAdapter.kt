package com.dreamxu.mvvmexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dreamxu.mvvmexample.R
import com.dreamxu.mvvmexample.models.NicePlace
import de.hdodenhof.circleimageview.CircleImageView

class PlaceListAdapter(private val nicePlaceList: List<NicePlace>, private val context: Context): RecyclerView.Adapter<PlaceListAdapter.PlaceListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceListViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.place_item, parent, false)
        return PlaceListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlaceListViewHolder, position: Int) {
        // Set the name of NicePlace
        holder.mTitle.text = nicePlaceList[position].placeName

        // Set the image
        val defaultOptions = RequestOptions().error(R.drawable.ic_launcher_background)
        Glide.with(context).setDefaultRequestOptions(defaultOptions)
            .load(nicePlaceList[position].imageUrl)
            .into((holder).mImage)
    }

    override fun getItemCount(): Int {
        return nicePlaceList.size
    }

    inner class PlaceListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mImage: CircleImageView = view.findViewById(R.id.place_image)
        val mTitle: TextView = view.findViewById(R.id.place_name)

    }
}