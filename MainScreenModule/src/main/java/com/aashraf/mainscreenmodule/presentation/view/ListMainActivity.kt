package com.aashraf.mainscreenmodule.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import com.aashraf.mainscreenmodule.MyApplication
import com.aashraf.mainscreenmodule.R
import com.aashraf.mainscreenmodule.data.dataSource.remoteDataSource.UniversityApi
import com.aashraf.mainscreenmodule.presentation.viewModel.UniversityViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListMainActivity : AppCompatActivity() {

    @Inject
    lateinit var universityApi: UniversityApi
    @Inject
    lateinit var viewModel: UniversityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        viewModel.universities.observe(this) { universities ->
            val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

            lifecycleScope.launch {

                recyclerView.adapter = MainListAdapter(universities.map { it.name })
            }
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()

        }

        lifecycleScope.launch {
            viewModel.getUniversities()
        }

    }
}