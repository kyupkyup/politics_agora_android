package com.example.politicsagora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote


class VoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val textView1 : TextView

    init {
        textView1 = itemView.findViewById(R.id.textView)
    }
}

class VoteListAdapter :RecyclerView.Adapter<VoteViewHolder>() {
    private var voteItems : List<Vote> = ArrayList<Vote>()

    fun updateVoteItems( items : List<Vote>){
        voteItems = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vote, parent, false)
        return VoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoteViewHolder, position: Int) {
        holder.textView1.text = voteItems[position].sgId
    }

    override fun getItemCount(): Int {
        return voteItems.size
    }
}

