package com.example.projectwerk.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectwerk.databinding.ListItemSfeerBinding
import com.example.projectwerk.models.Sfeer

class SfeerAdapter(private var sfeerClickListener: SfeerClickListener) : ListAdapter<Sfeer, SfeerViewHolder>(
        SfeerDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SfeerViewHolder {
        return SfeerViewHolder(

                ListItemSfeerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: SfeerViewHolder, position: Int) {
        val sfeer = getItem(position)
        holder.bindData(sfeer)
        holder.itemView.setOnClickListener {
            sfeerClickListener.onSfeerClicked(sfeer)
        }
    }

}


private class SfeerDiffCallback : DiffUtil.ItemCallback<Sfeer>() {
    override fun areItemsTheSame(oldItem: Sfeer, newItem: Sfeer): Boolean {
        return oldItem.recordid == newItem.recordid
    }

    override fun areContentsTheSame(oldItem: Sfeer, newItem: Sfeer): Boolean {
        return oldItem == newItem
    }

}

class SfeerViewHolder(val binding: ListItemSfeerBinding) :
        RecyclerView.ViewHolder(binding.root) {
    fun bindData(sfeer: Sfeer) {
        binding.sfeer = sfeer
    }

}


interface SfeerClickListener{
    fun onSfeerClicked(sfeer: Sfeer)

}