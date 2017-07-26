package com.example.com.qiushi.views

import com.example.com.qiushi.been.JokeContent

/**
 * Created by 蒲家旺 on 2017/7/26.
 */
interface IJokeView{
    fun showJokes(jokes:List<JokeContent>)
    fun showDialog()
    fun dismissDialog()
}