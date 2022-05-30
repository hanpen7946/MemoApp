package com.example.memoapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import com.example.memoapp.databinding.FragmentAddMemoListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddMemoList : Fragment() {
    private var _binding: FragmentAddMemoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var memodata:MemoData

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

        //フラグメントを閉じてFABを再表示する部分
        binding.EndButton.setOnClickListener{
            //フラグメントを閉じる
            parentFragmentManager.beginTransaction().remove(this).commit()

            //MainActivityのFABを取得・再表示・活性化
            val fb = requireActivity().findViewById<FloatingActionButton>(R.id.FabAddList)
            fb.visibility = View.VISIBLE
            fb.isClickable = true

            //FABにリスナーを再設置する・・・なぜかメインアクティビティで付けたリスナーが外れる　
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

        //追加ボタンを押した処理
        binding.AddButton.setOnClickListener{
            val et:EditText = view.findViewById(R.id.EditTitle)
            val en:EditText = view.findViewById(R.id.EditNumber)
            val ib:ImageButton = view.findViewById(R.id.CategoryButton)
            //処理用変数
            var number:Int
            var category:ImageView = ib
        //追加されないパターン
        if (et.text.isEmpty()) {
            et.setHint("タイトルを入力してください")
        //追加されるパターン
        } else {
            if (en.text.isEmpty()){
                number = 1
            } else{
                number = en.text.toString().toInt()
            }

        }

            /*タイトルを入れないと追加できない
              数量は入れてないと１になる
              カテゴリも選択しないとなしになる*/
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }