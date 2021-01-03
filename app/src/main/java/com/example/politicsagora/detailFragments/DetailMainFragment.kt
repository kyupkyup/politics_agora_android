package com.example.politicsagora.detailFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.politicsagora.DetailActivity
import com.example.politicsagora.MainActivity
import com.example.politicsagora.R
import com.example.politicsagora.viewmodel.DetailViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_OBJECT = "object"

class DetailMainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val sharedViewModel: DetailViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button : Button = view.findViewById(R.id.promise_button)
        val iamge : ImageView = view.findViewById(R.id.imageView)
        val candidate_name : TextView = view.findViewById(R.id.candidate_name)
        val sggName : TextView = view.findViewById(R.id.sggName)
        val party_name : TextView = view.findViewById(R.id.party_name)
        val gender : TextView = view.findViewById(R.id.gender)
        val birthday_age : TextView = view.findViewById(R.id.birthday_age)
        val address : TextView = view.findViewById(R.id.address)
        val job : TextView = view.findViewById(R.id.job)
        val education : TextView = view.findViewById(R.id.education)
        val career1 : TextView = view.findViewById(R.id.career1)
        val career2 : TextView = view.findViewById(R.id.career2)
        var str = "_${sharedViewModel.candidateId}"
        var resID: Int =
            view.context.getResources().getIdentifier(str, "raw", "com.example.politicsagora")
        if (resID != 0) {
            iamge.setImageResource(resID)
        }
        candidate_name.text = "${sharedViewModel.candidateName}(${sharedViewModel.candidateChineseName})"
        sggName.text = sharedViewModel.cityName
        party_name.text = sharedViewModel.party
        gender.text = sharedViewModel.gender
        birthday_age.text = "${sharedViewModel.birthday}(${sharedViewModel.age}세)"
        address.text = sharedViewModel.addr
        job.text = sharedViewModel.job
        education.text = sharedViewModel.edu
        career1.text = sharedViewModel.career1
        career2.text = sharedViewModel.career2

        button.text = "공약 불러오는 중..."
        button.setEnabled(false)


        sharedViewModel.itemLiveData.observe(viewLifecycleOwner, Observer {
            button.setEnabled(true)
            button.text = "공약 보기"
        })
        sharedViewModel.resultItemLiveData.observe(viewLifecycleOwner, Observer {
            button.text = "공약 없음"
            Toast.makeText(getActivity(), "해당 후보자는 등록된 공약이 없습니다.", Toast.LENGTH_LONG).show()
        })

        (activity as DetailActivity?)!!.supportActionBar!!.title = sharedViewModel.candidateName

        button.setOnClickListener {
            val actionDetailMainFragment = DetailMainFragmentDirections.actionDetailMainFragmentToDetailFragment()
            findNavController().navigate(actionDetailMainFragment)
            }




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailMainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailMainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}