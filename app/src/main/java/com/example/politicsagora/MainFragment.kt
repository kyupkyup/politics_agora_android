package com.example.politicsagora

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController
import com.example.politicsagora.databinding.ActivityMainBinding
import com.example.politicsagora.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    private var fragmentFirstBinding: FragmentMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMainBinding.bind(view)

        fragmentFirstBinding = binding
        binding.button.setOnClickListener {
            val actionMainToDetailActivity =
                MainFragmentDirections.actionMainFragmentToDetailActivity(
                    "20170509",
                    "100120965",
                    "1",
                    "대한민국",
                    "전국",
                    "",
                    "더불어민주당",
                    "문재인",
                    "文在寅",
                    "남",
                    "19530124",
                    "64",
                    "",
                    "정당인",
                    "경희대학교 법률학과 졸업",
                    "(전)더불어민주당 당대표",
                    "(전)제 19대 국회의원"
                )
            findNavController().navigate(actionMainToDetailActivity)
        }

        binding.button2.setOnClickListener {
            val actionMainFragmentToFindByCandidate =
                MainFragmentDirections.actionMainFragmentToCandidates()
            findNavController().navigate(actionMainFragmentToFindByCandidate)
        }
        binding.button3.setOnClickListener {
            val actionMainFragmentToFindByVote = MainFragmentDirections.actionMainFragmentToVotes()
            findNavController().navigate(actionMainFragmentToFindByVote)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFirstBinding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}