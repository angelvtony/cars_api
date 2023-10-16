package com.example.mycars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycars.models.Result

class MyAdapter(var con:Context, var list: List<Result>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    inner class ViewHolder(v : View) : RecyclerView.ViewHolder(v)
    {
        var name = v.findViewById<TextView>(R.id.textView)
        var country = v.findViewById<TextView>(R.id.textView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(con).inflate(R.layout.list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text=list[position].Mfr_Name
        holder.country.text=list[position].Country
    }
}