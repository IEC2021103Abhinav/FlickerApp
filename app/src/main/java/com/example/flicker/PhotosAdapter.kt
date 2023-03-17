package com.example.flicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PhotosAdapter(val images:MutableList<Image> = mutableListOf())
    :RecyclerView.Adapter<PhotosAdapter.PhotosViewModel>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewModel {
        val viewHolder=PhotosViewModel(LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_recycler,parent,false))
        return viewHolder
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: PhotosViewModel, position: Int) {
        holder.bind(images[position])
    }


    inner class PhotosViewModel(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        fun bind(image: Image)
        {
            Picasso.get().load(image.url)
                .resize(512,512)
                .centerCrop()
                .into(itemView.findViewById<ImageView>(R.id.pic_disp))

        }
    }
}