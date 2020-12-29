package com.example.politicsagora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote

class CandidateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val textView : TextView

    init {
        textView = itemView.findViewById(R.id.textView2)
    }

}

class CanditatesListAdapter : RecyclerView.Adapter<CandidateViewHolder>() {
    private var CandidateItems : List<Candidate> = ArrayList<Candidate>()


    fun updateCandidateItems( items : List<Candidate>){
        CandidateItems = items
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CandidateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.candidate, parent, false)

        return CandidateViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CandidateViewHolder,
        position: Int
    ) {
        holder.textView.text = CandidateItems[position].sgId

    }

    override fun getItemCount(): Int {
        return CandidateItems.size
    }
}