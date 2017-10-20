package com.cvnavi.app.ui.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 11:33
 * version: 1.0
 * Depict:
 */
public abstract class BaseRecyclerViewAdapter<T> extends AbRecyclerViewAdapter {
    public Context context;
    public List<T> list;

    public BaseRecyclerViewAdapter(Context context, @NonNull List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    final public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayoutId(), parent, false);
        return getViewHolder(view);
    }

    @LayoutRes
    protected abstract int getLayoutId();

    @NonNull
    protected abstract RecyclerView.ViewHolder getViewHolder(View view);

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    final public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindView(holder, position);
    }

    protected abstract void onBindView(RecyclerView.ViewHolder holder, int position);
}
