package com.example.politicsagora.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.findByVote.Votes
import com.example.politicsagora.findByVote.VotesDirections
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote
import java.lang.Integer.parseInt
import java.time.LocalDate
import java.time.format.DateTimeFormatter

var Strnow = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))

class VoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val vote_date: TextView
    val vote_name: TextView
    val vote_layout : ConstraintLayout
    val notification_vote : TextView

    init {
        vote_date = itemView.findViewById(R.id.vote_date)
        vote_name = itemView.findViewById(R.id.vote_name)
        vote_layout = itemView.findViewById(R.id.vote_layout)
        notification_vote= itemView.findViewById(R.id.notification_vote)

    }
}

class VoteListAdapter() : RecyclerView.Adapter<VoteViewHolder>() {
    private var voteItems: List<Vote> = ArrayList<Vote>()

    fun updateVoteItems(items: List<Vote>) {
        voteItems = items
        notifyDataSetChanged()
    }

    fun returnClick(received_position: Int): Vote {
        return voteItems[received_position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vote, parent, false)
        return VoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoteViewHolder, position: Int) {
        holder.vote_date.text = voteItems[position].sgId
        holder.vote_name.text = voteItems[position].sgName

        if (voteItems[position].sgTypecode == "0"){
            holder.vote_layout.setEnabled(false)
            holder.notification_vote.visibility = VISIBLE
            holder.notification_vote.text = "조회 불가 선거"
            holder.vote_layout.setBackgroundColor(100000)
        }
        else if(parseInt(voteItems[position].sgId) > parseInt(Strnow)){
            holder.vote_layout.setEnabled(false)
            holder.notification_vote.visibility = VISIBLE
            holder.notification_vote.text = "선거 예정"
            holder.vote_layout.setBackgroundColor(100000)

        }
        else{
            holder.vote_layout.setEnabled(true)
            holder.notification_vote.visibility = INVISIBLE
            holder.vote_layout.setBackgroundResource(R.drawable.border)
        }



    }

    override fun getItemCount(): Int {
        return voteItems.size

    }
}

