package com.example.memoapp


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.memoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var mMemoData: MutableList<MemoData> = mutableListOf()
    lateinit var listView:ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val egg = MemoData(false,"卵",2,129)

        mMemoData = arrayListOf(egg)

        //カスタムアダプターの生成と設定
        listView = findViewById(R.id.MemoList)
        var mCustomAdapter = CustomAdapter(this, mMemoData)
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
            binding.FabAddList.isClickable = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

   /*fun AddMemo(md: MemoData){
       mMemoData.add(md)
    }*/

    }

