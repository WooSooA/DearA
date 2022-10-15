package com.jenny.deara.board

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jenny.deara.R
import com.jenny.deara.utils.FBAuth

class BoardListAdapter(val context: Context,val boardkeyList : MutableList<String>)
    : RecyclerView.Adapter<BoardListAdapter.ViewHolder>() {

    var datas = mutableListOf<BoardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  BoardListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.board_list_item, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder:  BoardListAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position], boardkeyList[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title: TextView = itemView.findViewById(R.id.boardTitle)
        private val time: TextView = itemView.findViewById(R.id.boardTime)
        private val uid: TextView = itemView.findViewById(R.id.boardWriter)

        fun bind(item: BoardModel, key:String) {
            title.text = item.title
            time.text = item.time
            //uid.text = item.uid
            uid.text = FBAuth.getNick(item.uid)

            // 내부페이지로 이동
            itemView.setOnClickListener {
                val intent = Intent(context, BoardInsideActivity::class.java)
                intent.putExtra("key", boardkeyList[position])
                itemView.context.startActivity(intent)
            }
        }
    }
}