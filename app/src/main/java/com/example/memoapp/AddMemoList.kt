package com.example.memoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.security.AccessController.getContext


class AddMemoList : Fragment() {
    private var _binding: FragmentAddMemoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var main_binding:ActivityMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentAddMemoListBinding.inflate(inflater,container,false)
        main_binding = ActivityMainBinding.inflate(layoutInflater)
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
        }

        //追加ボタンを押した処理
        binding.AddButton.setOnClickListener{
            val et:EditText = view.findViewById(R.id.EditTitle)
            val eq:EditText = view.findViewById(R.id.EditQuantity)
            //処理用変数
            var quantity_am:Int

        //追加されないパターン
        if (et.text.isEmpty()) {
            et.setHint("タイトルを入力してください")

        //追加されるパターン
        } else {
            var title_am:String = et.text.toString()
            if (eq.text.isEmpty()){
                quantity_am= 1
            } else{
                quantity_am = eq.text.toString().toInt()
            }

            val md = MemoData(false,title_am,quantity_am,0)
            //MainActivity().AddMemo(md)
            var nd:MutableList<MemoData> = mutableListOf(md)
            var list:ListView = main_binding.MemoList
            var mCustomAdapter = CustomAdapter(requireContext(),nd)
            list.adapter = mCustomAdapter
        }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }