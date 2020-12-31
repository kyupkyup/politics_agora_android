package com.example.politicsagora.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.findByVote.Votes
import com.example.politicsagora.findByVote.VotesDirections
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote


class VoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val textView1 : TextView
    val layout : LinearLayout

    init {
        textView1 = itemView.findViewById(R.id.textView)
        layout = itemView.findViewById(R.id.vote_layout)
    }


}

class VoteListAdapter () :RecyclerView.Adapter<VoteViewHolder>() {
    private var voteItems : List<Vote> = ArrayList<Vote>()

    fun updateVoteItems( items : List<Vote>){
        voteItems = items
        notifyDataSetChanged()
    }

    fun returnClick(received_position: Int) : Vote{
        return voteItems[received_position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vote, parent, false)
        return VoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoteViewHolder, position: Int) {
        holder.textView1.text = voteItems[position].sgName
    }

    override fun getItemCount(): Int {
        return voteItems.size

    }
}

