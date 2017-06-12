package dongting.bwei.com.weekonea.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import dongting.bwei.com.weekonea.R;
import dongting.bwei.com.weekonea.bean.ABean;

/**
 * 作者:${董婷}
 * 日期:2017/6/10
 * 描述:
 */

public class BAdapter extends RecyclerView.Adapter<BAdapter.CViewHolder> {
     LayoutInflater inflater;
    List<ABean> list;
    Context context;

   int itemWidth;

    public BAdapter(List<ABean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);

        WindowManager wm =(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);


        //计算item的宽度
        itemWidth = (wm.getDefaultDisplay().getWidth()-48) / 2;
    }

    @Override
    public BAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.b_fragment_item, parent, false);

        CViewHolder viewHolder = new CViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BAdapter.CViewHolder holder, int position) {

        Bitmap mBitmap =BitmapFactory.decodeResource(context.getResources(),list.get(position).getA());

        //等比缩放
        double ratio = (itemWidth * 1.0) /mBitmap.getWidth();
        int height = (int) (mBitmap.getHeight() * ratio);
        ViewGroup.LayoutParams layoutParams = holder.iv.getLayoutParams();
        layoutParams.width = itemWidth;
        layoutParams.height = height;
        holder.iv.setLayoutParams(layoutParams);

        holder.title.setText(list.get(position).getTitle());

        holder.iv.setImageResource(list.get(position).getA());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView iv;

        public CViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.b_title);
            iv= (ImageView) itemView.findViewById(R.id.b_iv);
        }
    }
}
