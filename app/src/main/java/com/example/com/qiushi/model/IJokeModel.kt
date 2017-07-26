package com.example.com.qiushi.model

import com.example.com.qiushi.been.JokeContent
import rx.Subscriber
import rx.Subscription

/**
 * Created by 蒲家旺 on 2017/7/26.
 * model的基类
 */
interface IJokeModel {
    /**
     * 加载数据
     */
   fun loadInfo(subscriber: Subscriber<List<JokeContent>>):Subscription

}