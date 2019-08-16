package com.ardat.typerumah.Controller

import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.ardat.typerumah.DetailActivity
import com.ardat.typerumah.R
import java.util.ArrayList

class ListRumahAdapter(val mContext : Context?, val settingList: ArrayList<ModelRumah>): RecyclerView.Adapter<ListRumahAdapter.ViewHolder>(){

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.seting_name.text = settingList[position].settingName
        viewHolder.setting_desc.text = settingList[position].settingDesk
        viewHolder.setting_harga.text = settingList[position].settingHarga
        viewHolder.setting_icon.setImageResource(settingList[position].settingIcon)
        viewHolder.setting_item.setOnClickListener {
            val intent = Intent(mContext, DetailActivity::class.java)
            intent.putExtra("nama",settingList[position].settingName)
            intent.putExtra("deskripsi",settingList[position].settingDesk)
            intent.putExtra("harga",settingList[position].settingHarga)
            intent.putExtra("gambar",settingList[position].settingIcon)
            mContext!!.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return settingList.size
    }


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val seting_name = itemView.findViewById<TextView>(R.id.JudulBarang)
        val setting_harga= itemView.findViewById<TextView>(R.id.Harga)
        val setting_desc= itemView.findViewById<TextView>(R.id.Deskripsi)
        val setting_icon= itemView.findViewById<ImageView>(R.id.gambarProduct)
        val setting_item= itemView.findViewById<ConstraintLayout>(R.id.itemList)
    }
}