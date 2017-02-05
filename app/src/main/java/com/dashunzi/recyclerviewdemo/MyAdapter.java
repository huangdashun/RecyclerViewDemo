package com.dashunzi.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/5 0005.
 * 作者：大顺子
 * recyclerView适配器
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context context;
    private List<DataBean> datas;

    //通过构造函数传递一个上下文
    public MyAdapter(Context context, List<DataBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {//决定根布局
        TextView tv = new TextView(context);
        View itemView = View.inflate(context, R.layout.item_list, null);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {//填充数据
        holder.setDataAndRefreshUI(datas.get(position));
    }

    @Override
    public int getItemCount() {//条目总数
        if (datas != null) {
            return datas.size();
        }
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView mTv;
        private ImageView mIv;

        public MyHolder(View itemView) {
            super(itemView);
            //初始化孩子对象
            mTv = (TextView) itemView.findViewById(R.id.tv_name);
            mIv = (ImageView) itemView.findViewById(R.id.iv_icon);
        }

        public void setDataAndRefreshUI(DataBean dataBean) {
            mTv.setText(dataBean.text);
            mIv.setImageResource(dataBean.iconId);
        }
    }
}

