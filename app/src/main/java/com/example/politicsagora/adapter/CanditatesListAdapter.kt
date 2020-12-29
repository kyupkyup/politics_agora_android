package com.example.politicsagora.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.model.Candidate

class CandidateViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    //TODO("후보자 view 생성해서 변수 입력 및 초기화") 뷰바인딩

}

class CanditatesListAdapter : RecyclerView.Adapter<CandidateViewHolder>() {
    private var CandidateItems : List<Candidate> = ArrayList<Candidate>()

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
        TODO("뷰모델에서 데이터 받아와서 view에 바인딩해주기")
    }

    override fun getItemCount(): Int {
        return CandidateItems.size
    }
}