package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bi: FragmentAddMemoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        bi = FragmentAddMemoListBinding.inflate(layoutInflater)
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

    }
}