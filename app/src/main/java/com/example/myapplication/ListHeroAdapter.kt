package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.ListHeroAdapter.ListViewHolder
import java.util.*

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListViewHolder>() {
    private var onItemClickCallBack: OnItemClickCallback? = null
    fun setOnItemClickCallBack(onItemClickCallBack: (Nothing) -> Unit) {
        this.onItemClickCallBack = OnItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_hero, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context)
                .load(hero.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)
        holder.tvName.text = hero.name
        holder.tvDetail.text = hero.detail
        holder.itemView.setOnClickListener { onItemClickCallBack!!.onItemClicked(listHero[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class ListViewHolder(itemView: View) : ViewHolder(itemView) {
        var imgPhoto: ImageView
        var tvName: TextView
        var tvDetail: TextView

        init {
            imgPhoto = itemView.findViewById(R.id.img_item_photo)
            tvName = itemView.findViewById(R.id.tv_item_name)
            tvDetail = itemView.findViewById(R.id.tv_item_detail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero?)
    }

}