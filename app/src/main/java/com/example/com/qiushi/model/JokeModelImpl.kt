package com.example.com.qiushi.model

import android.util.Log
import com.example.com.qiushi.been.JokeContent
import com.example.com.qiushi.service.ServiceApi
import com.example.com.qiushi.utils.StringConverterFactory
import org.jsoup.Jsoup
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 *
 * 实现 IjokeModel
 *
 * Created by 蒲家旺 on 2017/7/26.
 */
class JokeModelImpl:IJokeModel{

    val urlBase = "https://www.qiushibaike.com"

    override fun loadInfo(subscriber:Subscriber<List<JokeContent>>):Subscription {
        val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                    .baseUrl(urlBase)
                    .addConverterFactory(StringConverterFactory().create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
        }
        val service = retrofit.create(ServiceApi::class.java)
        val result=service.getcall()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)

        return result
    }
}