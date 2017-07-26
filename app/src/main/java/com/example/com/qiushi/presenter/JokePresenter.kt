package com.example.com.qiushi.presenter

import android.util.Log
import com.example.com.qiushi.been.JokeContent
import com.example.com.qiushi.model.JokeModelImpl
import com.example.com.qiushi.views.IJokeView
import rx.Subscriber

/**
 * Created by 蒲家旺 on 2017/7/26.
 *
 */
class JokePresenter constructor(jokeView:IJokeView){

    val mJokeView=jokeView

    val mJokeModel=JokeModelImpl()

    /**
     *   将view和model进行绑定
     */
    fun fetch(){
        excuteTask()
    }

    //利用Rxjava 加载
    fun excuteTask() {
        var obserable=mJokeModel.loadInfo(object:Subscriber<List<JokeContent>>(){
            override fun onNext(t: List<JokeContent>?) {

                if (t != null) {
                    mJokeView.showJokes(t)
                }else{
                    Log.e("请求数据失败！","请重试")
                }
            }

            override fun onError(e: Throwable?) {
                Log.e("main",e.toString())
            }

            override fun onCompleted() {
            }
        })
    }
}