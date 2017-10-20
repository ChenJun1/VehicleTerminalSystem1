package com.cvnavi.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cvnavi.app.R;

/**
 * Created by wangshy on 17/8/17.
 */

public class TextInformationAdapter extends RecyclerView.Adapter<TextInformationAdapter.ViewHolder> {

    public void setItmeCheck(onItmeCheck itmeCheck) {
        this.itmeCheck = itmeCheck;
    }

    private onItmeCheck itmeCheck;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.text_information_itme, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itmeCheck.onCheck(position);
            }
        });
        holder.textView.setText("-----");
        holder.textView2.setText("-----");
        holder.textView3.setText("-----");
        holder.textView5.setText("-----");
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public interface onItmeCheck {
        void onCheck(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView5;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            textView = (TextView) view.findViewById(R.id.textView);
            textView2 = (TextView) view.findViewById(R.id.textView2);
            textView3 = (TextView) view.findViewById(R.id.textView3);
            textView5 = (TextView) view.findViewById(R.id.textView5);
        }
    }
}
