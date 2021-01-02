package com.example.politicsagora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.politicsagora.detailFragments.DetailAdapter
import com.example.politicsagora.findByVote.CandidatesOfVoteArgs
import com.example.politicsagora.viewmodel.CandidtatesOfVoteViewModel
import com.example.politicsagora.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {
    private val viewModel: DetailViewModel by viewModels()
    val args: DetailActivityArgs by navArgs()
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        viewModel.sgId = args.sgId
        viewModel.sgTypecode = args.sgTypecode
        viewModel.candidateId = args.candidateId
        viewModel.sgRegionName = args.sgRegionName
        viewModel.cityName = args.cityName
        viewModel.gihoSangse = args.gihoSangse
        viewModel.party = args.party
        viewModel.candidateName = args.candidateName
        viewModel.candidateChineseName = args.candidateChineseName
        viewModel.gender = args.gender
        viewModel.birthday = args.birthday
        viewModel.age = args.age
        viewModel.addr = args.addr
        viewModel.job = args.job
        viewModel.edu = args.edu
        viewModel.career1 = args.career1
        viewModel.career2 = args.career2

        viewModel.fetchCandidateInfo()
        val navController = findNavController(R.id.fragment2)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment2)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}