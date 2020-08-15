package com.dreamxu.mvvmexample

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dreamxu.mvvmexample.adapters.PlaceListAdapter
import com.dreamxu.mvvmexample.models.NicePlace
import com.dreamxu.mvvmexample.viewmodels.PlaceListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var mNicePlacesRecyclerView: RecyclerView
    private lateinit var mFab: FloatingActionButton
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mNicePlacesViewModel: PlaceListViewModel
    private lateinit var mNicePlacesAdapter: PlaceListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNicePlacesRecyclerView = findViewById(R.id.places_list)
        mFab = findViewById(R.id.fab)
        mProgressBar = findViewById(R.id.progress_bar)

        mNicePlacesViewModel = ViewModelProviders.of(this).get(PlaceListViewModel::class.java)
        mNicePlacesViewModel.getNicePlaces().observe(this, Observer<List<NicePlace>>() {
            mNicePlacesAdapter.notifyDataSetChanged()
        })
        mNicePlacesViewModel.getIsUpdating().observe(this, Observer {
            if (it) {
                showProgressBar()
                mNicePlacesRecyclerView.smoothScrollToPosition(mNicePlacesViewModel.getNicePlaces().value!!.size-1)
            } else {
                hideProgressBar()
            }
        })

        mFab.setOnClickListener {
            mNicePlacesViewModel.addPlace(NicePlace("", "China Shanghai"))
        }

        initRecycleView()
    }

    private fun initRecycleView() {
        mNicePlacesAdapter = PlaceListAdapter(mNicePlacesViewModel.getNicePlaces().value!!, this)
        mNicePlacesRecyclerView.layoutManager = LinearLayoutManager(this)
        mNicePlacesRecyclerView.adapter = mNicePlacesAdapter
    }

    private fun showProgressBar() {
        mProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        mProgressBar.visibility = View.GONE
    }
}
