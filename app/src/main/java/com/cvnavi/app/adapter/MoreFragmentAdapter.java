package com.cvnavi.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.MoreFragmentBean;

import java.util.List;

/**
 * 作者：wangshy on 17/10/18 17:10
 */

public class MoreFragmentAdapter extends RecyclerView.Adapter<MoreFragmentAdapter.ViewHolder> {
    private int before = -1;

    public int getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }

    public int getJustNow() {
        return justNow;
    }

    public void setJustNow(int justNow) {
        this.justNow = justNow;
    }

    private int justNow = -1;
    private List<MoreFragmentBean> fragmentBeanList;

    public MoreFragmentAdapter() {
    }

    public MoreFragmentAdapter(List<MoreFragmentBean> fragmentBeanList) {
        this.fragmentBeanList = fragmentBeanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.morefragment_itme, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(fragmentBeanList.get(position).getName());
        if (getJustNow() == position)
            holder.textView.setCompoundDrawablesWithIntrinsicBounds(0, fragmentBeanList.get(position).getDrawableTop1(), 0, 0);
        else
            holder.textView.setCompoundDrawablesWithIntrinsicBounds(0, fragmentBeanList.get(position).getDrawableTop(), 0, 0);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDrawableTop(position);
                if (itmeCheck != null)
                    itmeCheck.onClick(position);
            }
        });
    }

    public void setDrawableTop(int drawableTop) {
        if (getBefore() == drawableTop)
            return;
        else {
            if (getBefore() != -1)
                notifyItemChanged(getBefore());
            setBefore(drawableTop);
            setJustNow(drawableTop);
            notifyItemChanged(drawableTop);
        }
    }

    @Override
    public int getItemCount() {
        return fragmentBeanList == null ? 0 : fragmentBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.morefragment_itme_text);
        }
    }

    public interface OnClickListener {
        void onClick(int p);
    }

    public void setClickListener(OnClickListener itmeCheck) {
        this.itmeCheck = itmeCheck;
    }

    private OnClickListener itmeCheck;
}
