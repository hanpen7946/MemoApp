package com.example.memoapp

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*



class CustomAdapter(context: Context, var Memolist: MutableList<MemoData>) : ArrayAdapter<MemoData>(context, 0, Memolist) {
    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //タップされたアイテムを格納
        val memo = Memolist[position]

        //レイアウトの設定
        var view = convertView
        if(convertView == null) {
            view = layoutInflater.inflate(R.layout.custom_list_item, parent, false)
        }

        //各ビューの設定
        val title_ca = view?.findViewById<TextView>(R.id.MemoTitle)
        title_ca?.text = memo.title_md
        val quantity_ca = view?.findViewById<TextView>(R.id.Quantity)
        quantity_ca?.text = memo.quantity_md.toString() + "個"
        val price_ca = view?.findViewById<TextView>(R.id.Price)
        price_ca?.text = memo.price_md.toString() + "円"
        val checkbox_ca = view?.findViewById<CheckBox>(R.id.CheckBox)
        checkbox_ca?.setOnClickListener{
            if(checkbox_ca.isChecked) {
                title_ca?.paint?.flags = Paint.STRIKE_THRU_TEXT_FLAG
                title_ca?.setTextColor(Color.GRAY)
                quantity_ca?.setTextColor(Color.GRAY)
                price_ca?.setTextColor(Color.GRAY)
            } else{
                title_ca?.paint?.flags = Paint.ANTI_ALIAS_FLAG
                title_ca?.setTextColor(Color.BLACK)
                quantity_ca?.setTextColor(Color.BLACK)
                price_ca?.setTextColor(Color.BLACK)
            }
            notifyDataSetChanged()
        }
        return view!!
    }
}
