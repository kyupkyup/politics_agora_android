package com.example.politicsagora.findByVote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.adapter.VoteListAdapter
import com.example.politicsagora.viewmodel.VotesViewmodel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Votes.newInstance] factory method to
 * create an instance of this fragment.
 */
class Votes : Fragment() {
    private val viewModel: VotesViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_votes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val voteAdapter = VoteListAdapter()
        val vote_recycler_view: RecyclerView = view.findViewById(R.id.vote_recycler_view)

        vote_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = voteAdapter
        }

        viewModel.itemLiveData.observe(viewLifecycleOwner, Observer{
            voteAdapter.updateVoteItems(it)
        })
        //TODO("navControlloer 로 다음 fragment로 접근 -> 선거 코드 넘겨줘야 함. 해당 선거 코드에 맞는 후보자 api 연결")
    }
}











