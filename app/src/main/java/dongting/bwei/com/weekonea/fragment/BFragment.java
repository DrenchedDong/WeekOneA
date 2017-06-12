package dongting.bwei.com.weekonea.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.weekonea.R;
import dongting.bwei.com.weekonea.adapter.BAdapter;
import dongting.bwei.com.weekonea.bean.ABean;

/**
 * 作者:${董婷}
 * 日期:2017/6/10
 * 描述:
 */

public class BFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<ABean> aList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.afragent, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rr);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        aList = new ArrayList<>();

        initData();

        BAdapter adapter = new BAdapter(aList,getActivity());
        recyclerView.setAdapter(adapter);

        //设置布局管理器
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager
                (2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

    }

    private void initData() {

        for (int i=0;i<5;i++){

            ABean bBean =new ABean("B"+i,"哈哈",R.drawable.b);
            ABean cBean =new ABean("B"+i,"哈哈",R.drawable.c);
            ABean eBean =new ABean("B"+i,"哈哈",R.drawable.e);
            ABean aBean =new ABean("B"+i,"哈哈",R.drawable.a);

            aList.add(aBean);
            aList.add(bBean);
            aList.add(cBean);
            aList.add(eBean);
        }
    }
}
