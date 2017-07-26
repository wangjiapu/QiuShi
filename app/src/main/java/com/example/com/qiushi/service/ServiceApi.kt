package com.example.com.qiushi.service

import com.example.com.qiushi.been.JokeContent
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import rx.Observable

/**
 * Created by 蒲家旺 on 2017/7/25.
 */
interface ServiceApi {

    @GET("{url}")
    fun downloadPicFromNet(@Path("url") url:String):Observable<ResponseBody>

    @GET("url")
    fun getcall():Observable<List<JokeContent>>

    @GET("wb/recom/2015/12/09/144967331344791573.jpeg")
    fun downloadPicFromNet():Observable<ResponseBody>

}