package com.example.politicsagora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.example.politicsagora.findByVote.CandidatesOfVoteArgs
import com.example.politicsagora.viewmodel.CandidtatesOfVoteViewModel
import com.example.politicsagora.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()
    val args: DetailActivityArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val textView : TextView = findViewById(R.id.textView3)
        viewModel.sgId = args.sgId
        viewModel.sgTypecode = args.sgTypecode
        viewModel.candidateId = args.candidateId



        viewModel.fetchCandidateInfo()

        viewModel.itemLiveData.observe(this, Observer{
            Log.d("result", viewModel.itemLiveData.value.toString())
            textView.text = viewModel.itemLiveData.value.toString()
        })
    }
}