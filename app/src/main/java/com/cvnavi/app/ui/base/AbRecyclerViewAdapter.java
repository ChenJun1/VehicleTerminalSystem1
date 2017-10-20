package com.cvnavi.app.ui.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cvnavi.app.ui.base.listener.OnItemClickListener;
import com.cvnavi.app.ui.base.listener.OnItemLongClickListener;
import com.cvnavi.app.ui.base.listener.OnLoadMoreListener;


/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 11:33
 * version: 1.0
 * Depict:
 */
public abstract class AbRecyclerViewAdapter extends RecyclerView.Adapter {
    private OnItemClickListener onItemClickListener;
    private OnLoadMoreListener onLoadMoreListener;
    private OnItemLongClickListener onItemLongClickListener;

    private boolean isLoaded = true;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    final public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    final public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    /**
     * @param position
     * @param views    传入需要点击的view
     */
    final protected void setOnItemClick(final int position, View... views) {
        if (onItemClickListener != null)
            for (View view : views) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(position, v);
                    }
                });
            }
    }

    /**
     * @param position
     * @param views    传入长按的view
     */
    final protected void setOnItemLongClick(final int position, View... views) {
        if (onItemLongClickListener != null)
            for (View view : views) {
                view.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onItemLongClickListener.onItemLongClick(position, v);
                        return true;
                    }
                });
            }
    }

    /**
     * @param onLoadMoreListener 设置加载更多接口
     * @param recyclerView
     */
    final public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener, RecyclerView recyclerView) {
        this.onLoadMoreListener = onLoadMoreListener;
        attachRecyclerView(recyclerView);
    }

    private void attachRecyclerView(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (isLoaded && totalItemCount <= (lastVisibleItem + visibleThreshold) && dy > 0) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        isLoaded = false;
                    }
                }
            });
        }
    }

    /**
     * @param isLoaded 设置是否加载更多
     */
    public void setLoaded(boolean isLoaded) {
        this.isLoaded = isLoaded;
    }
}
