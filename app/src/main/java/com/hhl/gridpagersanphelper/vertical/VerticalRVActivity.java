package com.hhl.gridpagersanphelper.vertical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hhl.gridpagersanphelper.DataSourceUtils;
import com.hhl.gridpagersanphelper.R;
import com.hhl.gridpagersanphelper.ScreenUtils;
import com.hhl.gridpagersnaphelper.GridPagerSnapHelper;
import com.hhl.gridpagersnaphelper.GridPagerUtils;
import com.hhl.gridpagersnaphelper.transform.VerticalDataTransform;

import java.util.List;

public class VerticalRVActivity extends AppCompatActivity {

    private static final int row = 4;
    private static final int spanCount = 2;

    // spanCount和column是相等的
    private static final int column = spanCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_rv);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_vertical);
        recyclerView.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(row).setColumn(column);
        gridPagerSnapHelper.attachToRecyclerView(recyclerView);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / spanCount;

        int totoalHeight = ScreenUtils.dip2px(this, 400);
        int itemHeight = totoalHeight / row;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(
                new VerticalDataTransform<DataSourceUtils.ItemData>(row, column), dataList);

        //setAdapter
        VerticalRNAdapter adapter = new VerticalRNAdapter(this, dataList, itemWidth, itemHeight);
        recyclerView.setAdapter(adapter);
    }
}
