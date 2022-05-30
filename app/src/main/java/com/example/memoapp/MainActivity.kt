package com.example.memoapp

import android.R
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.memoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mCustomAdapter: CustomAdapter
    lateinit var mMemoData: ArrayList<MemoData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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

        //FABボタンのリスナー
        binding.FabAddList.setOnClickListener{
            binding.MemoList.setSelection(binding.MemoList.count-1)
            Log.i("FAB","押せた")
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, AddMemoList())
                addToBackStack(null)
                commit()
            }
            //ボタンの非表示と無効化
            binding.FabAddList.visibility = View.INVISIBLE
            binding.FabListAdd.isClickable = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
      menuInflater.inflate(R.menu.option_menu, menu)
      return true
    }

    }

