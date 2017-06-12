package dongting.bwei.com.weekonea.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dongting.bwei.com.weekonea.MyItemClickListener;
import dongting.bwei.com.weekonea.R;
import dongting.bwei.com.weekonea.bean.ABean;

/**
 * 作者:${董婷}
 * 日期:2017/5/23
 * 描述:
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<ABean> aList;
    Context context;
    LayoutInflater inflater;

    public RecycleViewAdapter(Context context, List<ABean> aList) {
        this.context = context;
        this.aList = aList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = inflater.inflate(R.layout.afragment_item, parent, false);

            OneViewHolder aViewHolder = new OneViewHolder(view);

            return aViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof OneViewHolder) {
            OneViewHolder aViewHolder = (OneViewHolder) holder;
            aViewHolder.a_imageview.setImageResource(aList.get(position).getA());
            aViewHolder.a_title.setText(aList.get(position).getTitle());
            aViewHolder.a_content.setText(aList.get(position).getContent());

            aViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return aList.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {

        ImageView a_imageview;
       TextView a_title;
       TextView a_content;

        public OneViewHolder(View itemView) {
            super(itemView);

            a_content = (TextView) itemView.findViewById(R.id.a_content);
            a_title = (TextView) itemView.findViewById(R.id.a_title);
            a_imageview = (ImageView) itemView.findViewById(R.id.a_imageview);
        }
    }

    public MyItemClickListener listener ;

    public void setOnItemClickListener(MyItemClickListener listener){

        this.listener = listener;
    }
}