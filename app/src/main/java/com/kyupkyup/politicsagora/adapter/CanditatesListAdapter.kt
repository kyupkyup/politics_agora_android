package com.kyupkyup.politicsagora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyupkyup.politicsagora.R
import com.kyupkyup.politicsagora.model.Candidate

class CandidateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    val candidateImageView: ImageView
    val textCandidateName: TextView
    val textPartyName: TextView
    val textSggName: TextView

    init {
        candidateImageView = itemView.findViewById(R.id.candidateImageView)
        textCandidateName = itemView.findViewById(R.id.textCandidateName)
        textPartyName = itemView.findViewById(R.id.textPartyName)
        textSggName = itemView.findViewById(R.id.textSggName)
    }

}

class CanditatesListAdapter : RecyclerView.Adapter<CandidateViewHolder>() {
    private var CandidateItems: List<Candidate> = ArrayList<Candidate>()

    lateinit var view: View
    fun updateCandidateItems(items: List<Candidate>) {
        CandidateItems = items
        notifyDataSetChanged()
    }

    fun returnClick(received_position: Int): Candidate {
        return CandidateItems[received_position]
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CandidateViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.candidate, parent, false)

        return CandidateViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CandidateViewHolder,
        position: Int
    ) {
        var str = "_${CandidateItems[position].candidateId}"
        var resID: Int =
            view.context.getResources().getIdentifier(str, "raw", "com.kyupkyup.politicsagora")
        if (resID != 0) {
            holder.candidateImageView.setImageResource(resID)
        }
        holder.textCandidateName.text = CandidateItems[position].candidateName
        holder.textPartyName.text = CandidateItems[position].party
        holder.textSggName.text = CandidateItems[position].cityName
    }

    override fun getItemCount(): Int {
        return CandidateItems.size
    }
}