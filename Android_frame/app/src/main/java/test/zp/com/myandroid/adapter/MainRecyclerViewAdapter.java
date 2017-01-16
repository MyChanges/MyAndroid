package test.zp.com.myandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.zp.com.myandroid.R;

/**
 * Created by change on 2017/1/11.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private String[] mData;

    public MainRecyclerViewAdapter(Context context, String[] data) {
        super();
        this.mContext = context;
        this.mData = data;
    }
    private OnItemClickLitener mOnItemClickLitener;


    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;

    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("MainRecyclerViewAdapter", "onCreateViewHolder: 11111111111" +parent);
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.main_item, parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.e("MainRecyclerViewAdapter", "onBindViewHolder: 33333333333333333");
        holder.tv.setText(mData[position]);
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(v,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            Log.e("MainRecyclerViewAdapter", "MyViewHolder: 22222222222222");
            tv  = (TextView) itemView.findViewById(R.id.tv_main_item_txt);
        }
    }
}
