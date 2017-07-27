package com.example.com.qiushi.activitys

import android.app.ProgressDialog
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import com.example.com.qiushi.Adapeter.JokeListAdatpter
import com.example.com.qiushi.R
import com.example.com.qiushi.been.JokeContent
import com.example.com.qiushi.presenter.JokePresenter
import com.example.com.qiushi.views.IJokeView
import kotlinx.android.synthetic.main.activity_main.*

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MainActivity : AppCompatActivity()
        ,IJokeView, android.support.v7.widget.Toolbar.OnMenuItemClickListener, NavigationView.OnNavigationItemSelectedListener {


    lateinit var dialog: ProgressDialog//加载进度条



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setOnMenuItemClickListener(this)
        JokePresenter(this).fetch()

        ngv.setNavigationItemSelectedListener(this)
        val resource=resources
        val csl=resource.getColorStateList(R.color.ngv_menu_item_color)
        ngv.itemTextColor=csl
        ngv.menu.getItem(0).setChecked(true)
    }

    override fun dismissDialog() {
        if(dialog!=null&& dialog.isShowing)
            dialog.dismiss()
    }

    override fun showDialog() {
        dialog= ProgressDialog(this)
        dialog.setTitle("加载中。。。")
        dialog.show()
    }
    override fun showJokes(jokes: List<JokeContent>) {
        rv.layoutManager= LinearLayoutManager(this) as RecyclerView.LayoutManager?
        rv.adapter=JokeListAdatpter(this,jokes)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.hot -> Toast.makeText(this, "热门", Toast.LENGTH_SHORT).show()
                R.id.ph -> Toast.makeText(this, "热图", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }

}




