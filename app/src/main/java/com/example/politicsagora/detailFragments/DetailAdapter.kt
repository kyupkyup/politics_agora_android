package com.example.politicsagora.detailFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.politicsagora.model.CandidateDetail

class DetailAdapter(fragment : Fragment) : FragmentStateAdapter(fragment){
    var size : Int = 10
    override fun getItemCount(): Int{

        return size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = DetailFragment1()
        fragment.arguments = Bundle().apply{
            putInt("object", position + 1)
        }
        return fragment
    }
}