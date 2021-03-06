package com.kyupkyup.politicsagora.detailFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.kyupkyup.politicsagora.DetailActivity
import com.kyupkyup.politicsagora.R
import com.kyupkyup.politicsagora.viewmodel.DetailViewModel
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

        (activity as DetailActivity?)!!.supportActionBar!!.title = sharedViewModel.candidateName + "의 공약"

        sharedViewModel.itemLiveData.observe(viewLifecycleOwner, Observer {
            detailAdapter = DetailAdapter(this, it)
            viewPager = view.findViewById(R.id.viewPager)
            tabLayout = view.findViewById(R.id.tabLayout)

            viewPager.adapter = detailAdapter

            TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy
            { tab, position ->
                if(it[position].prmsRealmName == ""){
                    tab.text = "${it[position].prmsTitle}"
                }
                else{
                    tab.text = "${it[position].prmsRealmName}"
                }
            }).attach()
        })

    }
}