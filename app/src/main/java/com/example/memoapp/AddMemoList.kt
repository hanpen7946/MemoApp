package com.example.memoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.memoapp.databinding.FragmentAddMemoListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


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
            Log.i("a","フラグメント閉じた")
            //なんとかしてフラグメントとじろ 完了
            parentFragmentManager.beginTransaction().remove(this).commit()
            //MainActivityのFABを取得
            val fb = requireActivity().findViewById<FloatingActionButton>(R.id.FabAddList)
            fb.visibility = View.VISIBLE
            //trueにはなってる
            fb.isClickable = true
            //FABにリスナーを再設置する　
            fb.setOnClickListener{
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.container,AddMemoList())
                    addToBackStack(null)
                    commit()
                }
                fb.visibility = View.INVISIBLE
                fb.isClickable = false
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }