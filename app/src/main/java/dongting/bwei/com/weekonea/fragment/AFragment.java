package dongting.bwei.com.weekonea.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.weekonea.DetailActivity;
import dongting.bwei.com.weekonea.MyItemClickListener;
import dongting.bwei.com.weekonea.R;
import dongting.bwei.com.weekonea.adapter.RecycleViewAdapter;
import dongting.bwei.com.weekonea.bean.ABean;

/**
 * 作者:${董婷}
 * 日期:2017/6/10
 * 描述:
 */

public class AFragment extends Fragment{

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

        RecycleViewAdapter adapter = new RecycleViewAdapter(getActivity(), aList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("content", aList.get(postion).getContent());
                intent.putExtra("image", aList.get(postion).getA());
                startActivity(intent);
            }
        });

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);


       //recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).build());
        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.RED)
                        .build());

    }

    private void initData() {

        for (int i=0;i<20;i++){
            ABean aBean =new ABean("A"+i,"哈哈",R.drawable.b);
            aList.add(aBean);
        }
    }

}
