package com.kyupkyup.politicsagora.findByVote

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kyupkyup.politicsagora.R
import com.kyupkyup.politicsagora.adapter.CanditatesListAdapter
import com.kyupkyup.politicsagora.model.Candidate
import com.kyupkyup.politicsagora.util.RecyclerViewItemClickListener
import com.kyupkyup.politicsagora.viewSource.LoadingDialog
import com.kyupkyup.politicsagora.viewmodel.CandidtatesOfVoteViewModel
import kotlinx.android.synthetic.main.fragment_main.*

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
    private lateinit var mContext: Context
    private lateinit var loadingDialog: LoadingDialog

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

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

        loadingDialog = LoadingDialog(mContext)
        loadingDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loadingDialog.show()

        candidate_recycler_view.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = candidateAdapter
        }

        viewModel.itemLiveData.observe(viewLifecycleOwner, Observer {
            candidateAdapter.updateCandidateItems(it)
            loadingDialog.dismiss()
        })
        viewModel.resultItemLiveData.observe(viewLifecycleOwner, Observer{
            Toast.makeText(getActivity(), "리스트를 불러올 수 없습니다.", Toast.LENGTH_LONG ).show()
            loadingDialog.dismiss()
            findNavController().popBackStack()
        })

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
                                items.sgTypecode,
                                items.sgRegionName,
                                items.cityName,
                                items.gihoSangse,
                                items.party,
                                items.candidateName,
                                items.candidateChineseName,
                                items.gender,
                                items.birthday,
                                items.age,
                                items.addr,
                                items.job,
                                items.edu,
                                items.career1,
                                items.career2
                            )
                        findNavController().navigate(action)
                    }
                })
        )
    }


}