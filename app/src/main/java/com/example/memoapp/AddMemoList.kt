package com.example.memoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding


class AddMemoList : Fragment() {
    private var _binding: FragmentAddMemoListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentAddMemoListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.EndButton.setOnClickListener{
            Log.i("a","おせた")
            //なんとかしてフラグメントとじろ
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }
