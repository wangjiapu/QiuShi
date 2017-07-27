package com.example.com.qiushi.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.com.qiushi.R
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by 蒲家旺 on 2017/7/27.
 *
 */
class GlideUtils{
    //静态方法
    companion object {
        fun loadUrlImage(context:Context,url:String,imageView: CircleImageView) {
            Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .error(R.drawable.logo)
                    .into(imageView)

        }
    }
}