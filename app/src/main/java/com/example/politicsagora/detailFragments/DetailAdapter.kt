package com.example.politicsagora.detailFragments

import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.provider.Settings.Secure.putInt
import android.provider.Settings.System.putInt
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.politicsagora.model.CandidateDetail
import com.example.politicsagora.model.ParsedCandidateDetail
import com.example.politicsagora.viewmodel.DetailViewModel

class DetailAdapter(fragment: Fragment, val parsedDetailList: List<ParsedCandidateDetail>) :
    FragmentStateAdapter(fragment) {

    var size: Int = parsedDetailList.size
    override fun getItemCount(): Int {

        return size
    }

    override fun createFragment(position: Int): Fragment {
        val DetailPromiseFragment = DetailPromiseFragment()

        DetailPromiseFragment.arguments = Bundle().apply {
            if (parsedDetailList[position].prmmCont == "") {
                putString("object", "공약 없음")
            } else {
                putString("object", parsedDetailList[position].prmmCont)

            }
        }
        return DetailPromiseFragment
    }
}