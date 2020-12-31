package com.example.politicsagora.detailFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.politicsagora.R
import com.example.politicsagora.viewmodel.DetailViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var detailAdapter: DetailAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
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
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        detailAdapter = DetailAdapter(this)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)

        //TODO("뷰 모델에서 데이터 가져와서 tab 제목에 넣어줄 것.")
        viewPager.adapter = detailAdapter

        sharedViewModel.itemLiveData.observe(viewLifecycleOwner, Observer {
            TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy
            { tab, position ->
                    when (position) {
                        0 -> {
                            tab.text = "후보자"
                        }
                        1->{
                            tab.text = "정치"
                        }
                        2->{
                            tab.text = "경제"
                        }
                        3->{
                            tab.text = ""
                        }
                        4->{
                            tab.text = ""
                        }
                        5->{
                            tab.text = ""
                        }
                        6->{
                            tab.text = ""
                        }
                        7->{
                            tab.text = ""
                        }
                        8->{
                            tab.text = ""
                        }
                        9->{
                            tab.text = ""
                        }
                    }

            }).attach()
        })

    }
}