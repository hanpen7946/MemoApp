package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ListView
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mCustomAdapter: CustomAdapter
    lateinit var mMemoData: ArrayList<MemoData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.FabListAdd.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, AddMemoList())
                addToBackStack(null)
                commit()
            }
            //ボタンの非表示と無効化
            binding.FabAddList.visibility = View.INVISIBLE
            binding.FabListAdd.isClickable = false

        }

        val egg = MemoData("卵", 1,R.drawable.ic_egg)
        val fish = MemoData("肉",1,R.drawable.ic_fish)
        val ai = MemoData("ひき肉",1,R.drawable.ic_meat)
        val a = MemoData("ひき肉",1,R.drawable.ic_meat)
        val aa = MemoData("ひき肉",1,R.drawable.ic_meat)
        val  b= MemoData("ひき肉",1,R.drawable.ic_meat)
        val  c= MemoData("ひき肉",1,R.drawable.ic_meat)
        val  cc= MemoData("ひき肉",1,R.drawable.ic_meat)
        val  ccc= MemoData("ひき肉",1,R.drawable.ic_meat)
        val cccc = MemoData("ひき肉",1,R.drawable.ic_meat)
        val  v= MemoData("ひき肉",1,R.drawable.ic_meat)
        val  vv= MemoData("ひき肉",1,R.drawable.ic_meat)
        val  vvv= MemoData("最後",1,R.drawable.ic_meat)

        mMemoData = arrayListOf(egg,fish,ai,a,aa,b,c,cc,ccc,cccc,v,vv,vvv)

        val listView = findViewById<ListView>(R.id.MemoList)

        //カスタムアダプターの生成と設定
        mCustomAdapter = CustomAdapter(this, mMemoData)
        listView.adapter = mCustomAdapter
    binding.FabListAdd.bringToFront()
    }

    }
