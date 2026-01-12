package com.example.profiler.ui.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.profiler.R
import com.example.profiler.data.entity.ProfileFieldEntity

class CustomFieldsAdapter(
    private var fields: List<ProfileFieldEntity>
) : RecyclerView.Adapter<CustomFieldsAdapter.FieldViewHolder>() {

    class FieldViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvKey: TextView = itemView.findViewById(R.id.tvKey)
        val tvValue: TextView = itemView.findViewById(R.id.tvValue)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_custom_field, parent, false)
        return FieldViewHolder(view)
    }

    override fun onBindViewHolder(holder: FieldViewHolder, position: Int) {
        val field = fields[position]
        holder.tvKey.text = field.fieldKey
        holder.tvValue.text = field.fieldValue
    }

    override fun getItemCount(): Int = fields.size

    fun updateList(newList: List<ProfileFieldEntity>) {
        fields = newList
        notifyDataSetChanged()
    }
}
