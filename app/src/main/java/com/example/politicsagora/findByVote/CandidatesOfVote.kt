package com.example.politicsagora.findByVote

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.adapter.CanditatesListAdapter
import com.example.politicsagora.findByCandidate.CandidatesDirections
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote
import com.example.politicsagora.util.RecyclerViewItemClickListener
import com.example.politicsagora.viewmodel.CandidtatesOfVoteViewModel
import com.example.politicsagora.viewmodel.VotesViewmodel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CandidatesOfVote.newInstance] factory method to
 * create an instance of this fragment.
 */
class CandidatesOfVote : Fragment() {
    private val viewModel: CandidtatesOfVoteViewModel by viewModels()
    val args: CandidatesOfVoteArgs by navArgs()
    private val mContext: Context? = getContext()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_candidates_of_vote, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val candidateAdapter = CanditatesListAdapter()
        val candidate_recycler_view: RecyclerView =
            view.findViewById(R.id.candidate_of_vote_recycler_view)

        viewModel.sgId = args.sgId
        viewModel.sgTypecode = args.sgTypecode
        viewModel.fetchCandidateInfo()

        candidate_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = candidateAdapter
        }

        viewModel.itemLiveData.observe(viewLifecycleOwner, Observer {
            candidateAdapter.updateCandidateItems(it)
        })        //TODO("뷰모델 구성해서 받아온 선거 코드 값 넣어주고, api fetch 해서 adapter로 연결")

        candidate_recycler_view.addOnItemTouchListener(
            RecyclerViewItemClickListener(
                mContext,
                candidate_recycler_view,
                object : RecyclerViewItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val items: Candidate = candidateAdapter.returnClick(position)
                        val action =
                            CandidatesOfVoteDirections.actionCandidatesOfVoteToDetailActivity(
                                items.sgId,
                                items.candidateId,
                                items.sgTypecode
                            )
                        findNavController().navigate(action)
                    }
                })
        )
    }


}