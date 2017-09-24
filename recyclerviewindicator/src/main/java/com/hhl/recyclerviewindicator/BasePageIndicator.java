package com.hhl.recyclerviewindicator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by HanHailong on 2017/9/24.
 */

public class BasePageIndicator extends View implements PageIndicator {

    private static final int DEFAULT_COLUMN = 1;

    protected RecyclerView mRecyclerView;
    private OnPageChangeListener mListener;
    private int mScrollState;
    private int mPageColumn = DEFAULT_COLUMN;
    protected int mCurrentPage;

    public BasePageIndicator(Context context) {
        super(context);
    }

    public BasePageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasePageIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private OnScrollListener mScrollListener = new OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            onPageScrollStateChanged(newState);

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                int position = 0;
                if (layoutManager instanceof GridLayoutManager) {
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                    position = gridLayoutManager.findFirstVisibleItemPosition();
                    int row = gridLayoutManager.getSpanCount();
                    position = position / (row * mPageColumn);
                } else if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    position = linearLayoutManager.findFirstVisibleItemPosition();
                }

                onPageSelected(position);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
//            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
//
//            int position = 0;
//            if (layoutManager instanceof GridLayoutManager) {
//                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
//                position = gridLayoutManager.findFirstVisibleItemPosition();
//                int row = gridLayoutManager.getSpanCount();
//                position = position / (row * mPageColumn);
//            } else if (layoutManager instanceof LinearLayoutManager) {
//                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
//                position = linearLayoutManager.findFirstVisibleItemPosition();
//            }
//
//            onPageSelected(position);
        }
    };

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }

    @Override
    public void onPageSelected(int position) {
//        if (mScrollState == RecyclerView.SCROLL_STATE_IDLE) {
        if (mCurrentPage == position) return;

        mCurrentPage = position;
        invalidate();
//        }

        if (mListener != null) {
            mListener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        mScrollState = state;

        if (mListener != null) {
            mListener.onPageScrollStateChanged(state);
        }
    }

    @Override
    public void setRecyclerView(RecyclerView view) {
        if (mRecyclerView == view) {
            return;
        }
        if (mRecyclerView != null) {
            mRecyclerView.removeOnScrollListener(mScrollListener);
        }
        if (view.getAdapter() == null) {
            throw new IllegalStateException("RecyclerView does not have adapter instance.");
        }
        mRecyclerView = view;
        mRecyclerView.addOnScrollListener(mScrollListener);
        invalidate();
    }

    @Override
    public void setRecyclerView(RecyclerView view, int initialPosition) {
        setRecyclerView(view);
        setCurrentItem(initialPosition);
    }

    @Override
    public void setCurrentItem(int item) {
        if (mRecyclerView == null) {
            throw new IllegalStateException("RecyclerView has not been bound.");
        }

        int currentPage = eachPageItemCount() * item;

        mRecyclerView.smoothScrollToPosition(currentPage);
        mCurrentPage = item;
        invalidate();
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.mListener = listener;
    }

    @Override
    public void notifyDataSetChanged() {
        invalidate();
    }

    @Override
    public void setPageColumn(int column) {
        if (column <= 0)
            throw new IllegalArgumentException("column must be not null");
        this.mPageColumn = column;
    }

    /**
     * The number of each page
     *
     * @return
     */
    protected int eachPageItemCount() {
        if (mRecyclerView == null) {
            return 0;
        }

        int row = 1;
        RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();

        if (layoutManager != null) {
            if (layoutManager instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                row = gridLayoutManager.getSpanCount();
            }
        }

        return row * mPageColumn;
    }

    protected int pageCount() {
        if (mRecyclerView == null || mRecyclerView.getAdapter() == null)
            return 0;

        int itemCount = mRecyclerView.getAdapter().getItemCount();

        int eachPageCount = eachPageItemCount();

        if (eachPageCount <= 0) return 0;

        return itemCount % eachPageCount == 0 ?
                itemCount / eachPageCount : itemCount / eachPageCount + 1;
    }
}
