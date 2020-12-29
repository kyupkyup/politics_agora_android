package com.example.politicsagora.findByVote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.politicsagora.R
import com.example.politicsagora.adapter.VoteListAdapter
import com.example.politicsagora.model.Vote

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

    private val layoutManager: RecyclerView.LayoutManager? = null

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

        val items = listOf(
            Vote("asdf", "asdf", "123", "1234"),
            Vote("asdf", "asdf", "123", "1234"),
            Vote("asdf", "asdf", "123", "1234")
        )
        voteAdapter.updateVoteItems(items)

    }
}