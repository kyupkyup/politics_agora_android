package com.kyupkyup.politicsagora.findByVote

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyupkyup.politicsagora.R
import com.kyupkyup.politicsagora.adapter.VoteListAdapter
import com.kyupkyup.politicsagora.model.Vote
import com.kyupkyup.politicsagora.util.RecyclerViewItemClickListener
import com.kyupkyup.politicsagora.viewSource.LoadingDialog
import com.kyupkyup.politicsagora.viewmodel.VotesViewmodel

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
    private lateinit var mContext: Context
    private lateinit var loadingDialog: LoadingDialog

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

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
        loadingDialog = LoadingDialog(mContext)
        loadingDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loadingDialog.show()

        viewModel.itemLiveData.observe(viewLifecycleOwner, Observer {
            voteAdapter.updateVoteItems(it)
            loadingDialog.dismiss()

        })
        viewModel.resultItemLiveData.observe(viewLifecycleOwner, Observer{
            Toast.makeText(getActivity(), "리스트를 불러올 수 없습니다.", Toast.LENGTH_LONG ).show()
            loadingDialog.dismiss()
            findNavController().popBackStack()
        })

        vote_recycler_view.addOnItemTouchListener(
            RecyclerViewItemClickListener(
                mContext,
                vote_recycler_view,
                object : RecyclerViewItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        val items: Vote = voteAdapter.returnClick(position)
                        Log.d("result", items.toString())
                        val action = VotesDirections.actionVotesToCandidatesOfVote(items.sgId, items.sgTypecode)
                        findNavController().navigate(action)
                    }
                })
        )

        //TODO("navControlloer 로 다음 fragment로 접근 -> 선거 코드 넘겨줘야 함. 해당 선거 코드에 맞는 후보자 api 연결")\
    }
}











