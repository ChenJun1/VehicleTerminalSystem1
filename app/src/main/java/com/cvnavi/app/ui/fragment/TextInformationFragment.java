package com.cvnavi.app.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.TextInformationAdapter;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.ui.base.BaseListenerFragment;

import butterknife.BindView;

/**
 * Created by wangshy on 17/8/17.
 *
 * 信息服务--文本信息
 */

public class TextInformationFragment extends BaseListenerFragment {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.content)
    TextView content;
//    @BindView(R.id.framelayout_right)
//    FrameLayout framelayoutRight;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {

    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_text_information;
    }

    @Override
    public void initView() {
        TextInformationAdapter adapter = new TextInformationAdapter();
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerview.setAdapter(adapter);
        adapter.setItmeCheck(new TextInformationAdapter.onItmeCheck() {
            @Override
            public void onCheck(int position) {
                title.setText(position + "--------");
//                Log.e("TextInformationFragment", "---wangshy---->>>> onCheck(TextInformationFragment.java:48)" + position);
            }
        });
    }

    @Override
    protected void lazyLoad() {

    }
}
