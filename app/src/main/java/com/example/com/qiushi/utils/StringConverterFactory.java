package com.example.com.qiushi.utils;

import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v7.widget.DecorContentParent;
import android.util.Log;

import com.example.com.qiushi.been.JokeContent;
import com.google.gson.Gson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;


/**
 * Created by 蒲家旺 on 2017/7/26.
 *
 */

public class StringConverterFactory extends Converter.Factory {

    StringConverterFactory stringConverterFactory=null;
    public  StringConverterFactory create() {
        stringConverterFactory=new StringConverterFactory();
        return stringConverterFactory;
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type, Annotation[] annotations, Retrofit retrofit) {

        Converter converter=new Converter<ResponseBody,List<JokeContent>>(){

            @Override
            public List<JokeContent> convert(ResponseBody value) throws IOException {
                List<JokeContent> list=new  ArrayList<JokeContent>();
                Document doc= Jsoup.parse(value.string());
                Elements div1=doc.getElementsByClass("main");
                Document div1Doc=Jsoup.parse(div1.toString());
                Elements div2=div1Doc.select(".content-block").select(".clearfix");

                Document div2Doc=Jsoup.parse(div2.toString());

                Elements div3=div2Doc.getElementsByClass("col1");
                Document div3Doc=Jsoup.parse(div3.toString());
                Elements div4=div3Doc.select(".article")
                        .select(".block").select(".untagged").select(".mb15");

                for (Element element:div4){

                    Document qiushitag=Jsoup.parse(element.toString());
                    //作者
                    Log.e("1111","2222222222222222");
                    Elements author=qiushitag.select("div.author").select(".clearfix");
                   /* String url=author.select("img").get(1).attr("src");
                    Log.e("1111","2222222222222222");
                    Log.e("img:",url);*/
                    String name=author.select("h2").text();
                    Log.e("name",name);
                    String age=author.select("div.articleGender").text();
                    Log.e("age",age);
                    //内容
                    Elements content=qiushitag.select("div.content");
                    Document con2=Jsoup.parse(content.toString());
                    Elements content_String=con2.select("span");
                    String wocao=content_String.text().replace("<br>","\n").replace("&nbsp;","");

                    //状态---好笑
                    Elements stats=qiushitag.select("div.stats");
                    String stats_vote=Jsoup.parse(stats.toString())
                            .select("span.stats-vote").select("i.number").text();

                    Log.e("stats-vote:",stats_vote);
                    //状态---评论数
                    Elements qiushi_comments=qiushitag.select("a.qiushi_comments");
                    String com=Jsoup.parse(qiushi_comments.toString())
                            .select("i.number").text();
                    Log.e("com:",com);

                  /*  list.add(new JokeContent(wocao,new JokeContent.person(url,name,"n")
                            ,stats_vote+"好笑",com+"评论"));*/
                    list.add(new JokeContent(wocao,"1111",name,age,stats_vote+"好笑",com+"评论"));
                }


                return list;
            }
        };

        return converter;
    }
}
