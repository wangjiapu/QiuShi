package com.example.com.qiushi.Adapeter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.com.qiushi.R
import com.example.com.qiushi.been.JokeContent
import kotlinx.android.synthetic.main.jokelist_item.view.*
import kotlinx.android.synthetic.main.jokelist_item2.view.*

/**
 * Created by 蒲家旺 on 2017/7/26.
 */
internal class JokeListAdatpter(var context: Context,var list:List<JokeContent>)
    :RecyclerView.Adapter<JokeListAdatpter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        if (viewType==1)
            return ViewHolder(View.inflate(parent?.context, R.layout.jokelist_item2,null) )
        else
            return ViewHolder(View.inflate(parent?.context, R.layout.jokelist_item,null) )

    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        when(getItemViewType(position)){
            1 -> Toast.makeText(context,"到底了",Toast.LENGTH_SHORT).show()
            else -> {
                if (holder != null) {
                    holder.jokecontent.text=list[position].title
                    //holder.img.setImageBitmap()
                    holder.name.text=list[position].name
                    holder.sex.text=list[position].sex
                    holder.com.text=list[position].com
                    holder.small.text=list[position].zan
                }
            }
        }
    }

    override fun getItemCount()=list.size

    override fun getItemViewType(position: Int): Int{
        if (position==list.size)
            return 1
        return 2
    }

    internal class ViewHolder(rootView: View):RecyclerView.ViewHolder(rootView){

        var jokecontent=rootView.joke
        var img=rootView.person
        var name=rootView.personid
        var sex=rootView.sex

        var small=rootView.zan
        var com=rootView.com
    }

    internal class ViewHolder2(rootView: View):RecyclerView.ViewHolder(rootView){
        var per=rootView.bt1
        var next=rootView.bt2
    }
}