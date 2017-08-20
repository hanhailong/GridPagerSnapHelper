package com.hhl.gridpagersanphelper.recyclerview;

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

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    public static final int ROW = 2;
    public static final int COLUMN = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, ROW, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(ROW).setColumn(COLUMN);
        gridPagerSnapHelper.attachToRecyclerView(recyclerView);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / COLUMN;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(dataList, ROW, COLUMN);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        recyclerView.setAdapter(adapter);
    }
}
