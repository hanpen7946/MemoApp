package com.example.memoapp






import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.memoapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),AddMemoList.CallbackListener {

    private lateinit var binding: ActivityMainBinding
    var mMemoData: MutableList<MemoData> = mutableListOf()
    lateinit var listView:ListView
    lateinit var mCustomAdapter:CustomAdapter

    override fun updateMemoList(memo: MemoData) {
        mMemoData.add(memo)
        mCustomAdapter = CustomAdapter(this, mMemoData)
        listView.adapter = mCustomAdapter
        binding.MemoList.setSelection(binding.MemoList.count-1)
        //データベースへプッシュ
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listView = findViewById(R.id.MemoList)

        //データベースからデータ引っ張る
        //ゴミ箱のリスナー・データベースへのプッシュ
        //ソート


        //テストデータの挿入
        val egg = MemoData(false,"we",5,129)
        mMemoData = arrayListOf(egg)
        mCustomAdapter = CustomAdapter(this, mMemoData)
        listView.adapter = mCustomAdapter
        val eg = MemoData(false,"we",5,129)
        mMemoData.add(eg)
        mCustomAdapter.notifyDataSetChanged()
        //FABボタンのリスナー
        binding.FabAddList.setOnClickListener{
            binding.MemoList.setSelection(binding.MemoList.count-1)
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
    }

