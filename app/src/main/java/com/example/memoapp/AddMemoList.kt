package com.example.memoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding


class AddMemoList : Fragment() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        }


    override fun onPause() {
        super.onPause()
        binding.FabAddList.visibility = View.VISIBLE
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_memo_list, container, false)
    }

}