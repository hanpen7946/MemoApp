package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import com.example.memoapp.databinding.ActivityMainBinding
import com.example.memoapp.databinding.FragmentAddMemoListBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.FabListAdd.setOnClickListener{
            Log.i("Fabbutton","FAB押した")
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
