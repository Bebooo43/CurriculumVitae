package com.bebooo43.cv.main.work

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bebooo43.cv.databinding.ItemWorkBinding

class WorkAdapter(private val list: ArrayList<Work>) : RecyclerView.Adapter<WorkAdapter.WorkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val binding =  ItemWorkBinding.inflate(LayoutInflater.from(parent.context))
        return WorkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class WorkViewHolder(private val viewBinding: ItemWorkBinding) : ViewHolder(viewBinding.root) {
        fun bind(work: Work){
            viewBinding.apply {
                logoIV.setBackgroundResource(work.imageResId)
                titleTV.text = work.title
                positionTV.text = work.position
                durationTV.text = work.duration
            }
        }
    }

    fun addWork(work: Work){
        list.add(0, work)
        notifyItemInserted(0)
    }
}