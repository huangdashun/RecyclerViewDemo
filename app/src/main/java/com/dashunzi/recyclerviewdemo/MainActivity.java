package com.dashunzi.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<DataBean> mDatas = new ArrayList<>();
    private List<DataBean> mStaggerDatas = new ArrayList<>();


    private int[] mListIcons = new int[]{R.mipmap.g1, R.mipmap.g2, R.mipmap.g3, R.mipmap.g4,
            R.mipmap.g5, R.mipmap.g6, R.mipmap.g7, R.mipmap.g8, R.mipmap.g9, R.mipmap.g10, R
            .mipmap.g11, R.mipmap.g12, R.mipmap.g13, R.mipmap.g14, R.mipmap.g15, R.mipmap
            .g16, R.mipmap.g17, R.mipmap.g18, R.mipmap.g19, R.mipmap.g20, R.mipmap.g21, R
            .mipmap.g22, R.mipmap.g23, R.mipmap.g24, R.mipmap.g25, R.mipmap.g26, R.mipmap
            .g27, R.mipmap.g28, R.mipmap.g29};

    private int[] mStaggerIcons = new int[]{R.mipmap.p1, R.mipmap.p2, R.mipmap.p3, R
            .mipmap.p4, R.mipmap.p5, R.mipmap.p6, R.mipmap.p7, R.mipmap.p8, R.mipmap.p9, R
            .mipmap.p10, R.mipmap.p11, R.mipmap.p12, R.mipmap.p13, R.mipmap.p14, R.mipmap
            .p15, R.mipmap.p16, R.mipmap.p17, R.mipmap.p18, R.mipmap.p19, R.mipmap.p20, R
            .mipmap.p21, R.mipmap.p22, R.mipmap.p23, R.mipmap.p24, R.mipmap.p25, R.mipmap
            .p26, R.mipmap.p27, R.mipmap.p28, R.mipmap.p29, R.mipmap.p30, R.mipmap.p31, R
            .mipmap.p32, R.mipmap.p33, R.mipmap.p34, R.mipmap.p35, R.mipmap.p36, R.mipmap
            .p37, R.mipmap.p38, R.mipmap.p39, R.mipmap.p40, R.mipmap.p41, R.mipmap.p42, R
            .mipmap.p43, R.mipmap.p44};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        //找到recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //默认是竖直
        initListV();

    }

    private void initListV() {
        //设置adapter
        LinearLayoutManager layoutManger = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManger);
        //设置adapter
        mRecyclerView.setAdapter(new MyAdapter(this, mDatas));
    }

    private void initListH() {
        //设置adapter
        LinearLayoutManager layoutManger = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManger);
        //设置adapter
        mRecyclerView.setAdapter(new MyAdapter(this, mDatas));
    }


    private void initGridV() {
        //设置adapter
        LinearLayoutManager layoutManger = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManger);
        //设置adapter
        mRecyclerView.setAdapter(new MyAdapter(this, mDatas));
    }

    private void initGridH() {
        //设置adapter
        LinearLayoutManager layoutManger = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManger);
        //设置adapter
        mRecyclerView.setAdapter(new MyAdapter(this, mDatas));
    }

    private void initStaggerV() {
        //设置adapter
        StaggeredGridLayoutManager layoutManger = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManger);
        //设置adapter
        mRecyclerView.setAdapter(new StaggerAdapter(this, mStaggerDatas));
    }

    private void initStaggerH() {
        //设置adapter
        StaggeredGridLayoutManager layoutManger = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManger);
        //设置adapter
        mRecyclerView.setAdapter(new StaggerAdapter(this, mStaggerDatas));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list_v:
                initListV();
                break;
            case R.id.action_list_h:
                initListH();
                break;
            case R.id.action_grid_v:
                initGridV();
                break;
            case R.id.action_grid_h:
                initGridH();
                break;
            case R.id.action_stagger_v:
                initStaggerV();
                break;
            case R.id.action_stagger_h:
                initStaggerH();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < mListIcons.length; i++) {
            int iconId = mListIcons[i];
            DataBean dataBean = new DataBean();
            dataBean.iconId = iconId;
            dataBean.text = "我是item" + i;
            //添加到集合
            mDatas.add(dataBean);

        }
        for (int i = 0; i < mStaggerIcons.length; i++) {
            int iconId = mStaggerIcons[i];
            DataBean dataBean = new DataBean();
            dataBean.iconId = iconId;
            dataBean.text = "我是item" + i;
            //添加到集合
            mStaggerDatas.add(dataBean);

        }
    }
}
