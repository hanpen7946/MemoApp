package com.example.memoapp


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ListView
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton



class AddMemoList : Fragment() {
    private var _binding: FragmentAddMemoListBinding? = null
    private val binding get() = _binding!!
    private lateinit var main_binding:ActivityMainBinding
    private lateinit var listener: CallbackListener

    interface CallbackListener {
        fun updateMemoList(memo:MemoData)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            //MainActivity（呼び出し元）をListenerに変換する
            val mainActivity: MainActivity= activity as MainActivity
            listener = mainActivity
        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() +
                    " must implement NoticeDialogListener"))
        }
    }
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
            val inputManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
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
            //一つのメモ要素を作成
            val md = MemoData(false,title_am,quantity_am,0)
            listener.updateMemoList(md)
        }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }