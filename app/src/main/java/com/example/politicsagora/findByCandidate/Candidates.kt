package com.example.politicsagora.findByCandidate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.adapter.CanditatesListAdapter
import com.example.politicsagora.adapter.VoteListAdapter
import com.example.politicsagora.model.Candidate
import com.example.politicsagora.model.Vote

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Candidates.newInstance] factory method to
 * create an instance of this fragment.
 */
class Candidates : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_candidates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val button : Button = view.findViewById(R.id.button4)
//        button.setOnClickListener {
//            val action = CandidatesDirections.actionCandidatesToVotesOfCandidate()
//            findNavController().navigate(action)
//        }
        val CandidateAdapter = CanditatesListAdapter()
        val candidate_recycler_view: RecyclerView = view.findViewById(R.id.candidate_recycler_view)

        candidate_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = CandidateAdapter
        }
        val items = listOf(
            Candidate(
                "asdfasdfasdf",
                "asdf",
                "123",
                "1234",
                "asdf",
                "asdfasdf",
                "asdffdsf",
                "123123",
                "123123123",
                "1123123",
                "asdfsd",
                "asdfa",
                "asdf",
                "asdf",
                "asdfasd", "asdf", "asdf", "asdf1", "asdf", "asdf"
            ),
            Candidate(
                "asdf",
                "asdf",
                "123",
                "1234",
                "asdf",
                "asdfasdf",
                "asdffdsf",
                "123123",
                "123123123",
                "1123123",
                "asdfsd",
                "asdfa",
                "asdf",
                "asdf",
                "asdfasd", "asdf", "asdf", "asdf1", "asdf", "asdf"
            ), Candidate(
                "asdf",
                "asdf",
                "123",
                "1234",
                "asdf",
                "asdfasdf",
                "asdffdsf",
                "123123",
                "123123123",
                "1123123",
                "asdfsd",
                "asdfa",
                "asdf",
                "asdf",
                "asdfasd", "asdf", "asdf", "asdf1", "asdf", "asdf"
            )
        )
        CandidateAdapter.updateCandidateItems(items)

    }
}