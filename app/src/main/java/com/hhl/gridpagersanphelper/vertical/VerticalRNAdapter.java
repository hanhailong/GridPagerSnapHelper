package com.hhl.gridpagersanphelper.vertical;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hhl.gridpagersanphelper.DataSourceUtils;
import com.hhl.gridpagersanphelper.GlideApp;
import com.hhl.gridpagersanphelper.R;

import java.util.List;

/**
 * Created by hanhailong on 2017/8/20.
 */

public class VerticalRNAdapter extends RecyclerView.Adapter<VerticalRNAdapter.ViewHolder> {

    private final List<DataSourceUtils.ItemData> mDataList;
    private final LayoutInflater mLayoutInflater;
    private final int mItemWidth;
    private final int mItemHeight;

    public VerticalRNAdapter(Context context, List<DataSourceUtils.ItemData> dataList, int itemWidth
            , int itemHeight) {
        mDataList = dataList;
        mLayoutInflater = LayoutInflater.from(context);
        this.mItemWidth = itemWidth;
        this.mItemHeight = itemHeight;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.view_item, parent, false),
                mItemWidth, mItemHeight);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView, int itemWidth, int itemHeight) {
            super(itemView);

            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            layoutParams.width = itemWidth;
            layoutParams.height = itemHeight;

            imageView = (ImageView) itemView.findViewById(R.id.view_item_icon);
            textView = (TextView) itemView.findViewById(R.id.view_item_title);
        }

        public void bindData(DataSourceUtils.ItemData itemData) {
            if (itemData != null) {
                itemView.setVisibility(View.VISIBLE);
                GlideApp.with(itemView).load(itemData.url).into(imageView);
                textView.setText(itemData.title);
            } else {
                itemView.setVisibility(View.GONE);
            }
        }
    }
}
