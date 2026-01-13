package com.example.profiler.ui.profiles.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profiler.R
import com.example.profiler.data.entity.ProfileEntity

class ProfileAdapter(
    private var profiles: List<ProfileEntity>,
    private val onItemClick: (ProfileEntity) -> Unit
): RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.tvName.text = profile.fullName
        holder.tvPhone.text = profile.phone

        holder.itemView.setOnClickListener {
            onItemClick(profile)
        }
    }

    override fun getItemCount(): Int = profiles.size

    fun updateList(newList: List<ProfileEntity>) {
        profiles = newList
        notifyDataSetChanged()
    }
}
