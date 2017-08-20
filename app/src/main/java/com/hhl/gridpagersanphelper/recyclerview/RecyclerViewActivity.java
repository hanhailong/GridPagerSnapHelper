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
import com.hhl.gridpagersnaphelper.transform.FirstOrderTransform;
import com.hhl.gridpagersnaphelper.transform.SecondOrderTransform;
import com.hhl.gridpagersnaphelper.transform.ThirdOrderTransform;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    public static final int ROW = 1;
    public static final int COLUMN = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        configFirstRecyclerView(1, 4);
        configSecondRecyclerView(2, 4);
        configThridRecyclerView(3, 3);
    }

    private void configThridRecyclerView(int row, int column) {
        RecyclerView firstRV = (RecyclerView) findViewById(R.id.recycler_view_third);
        firstRV.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, row, LinearLayoutManager.HORIZONTAL, false);
        firstRV.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(row).setColumn(column);
        gridPagerSnapHelper.attachToRecyclerView(firstRV);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / column;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(
                new ThirdOrderTransform<DataSourceUtils.ItemData>(column), dataList);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        firstRV.setAdapter(adapter);
    }

    private void configSecondRecyclerView(int row, int column) {
        RecyclerView firstRV = (RecyclerView) findViewById(R.id.recycler_view_second);
        firstRV.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, row, LinearLayoutManager.HORIZONTAL, false);
        firstRV.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(row).setColumn(column);
        gridPagerSnapHelper.attachToRecyclerView(firstRV);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / column;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(
                new SecondOrderTransform<DataSourceUtils.ItemData>(column), dataList);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        firstRV.setAdapter(adapter);
    }

    private void configFirstRecyclerView(int row, int column) {
        RecyclerView firstRV = (RecyclerView) findViewById(R.id.recycler_view_first);
        firstRV.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, row, LinearLayoutManager.HORIZONTAL, false);
        firstRV.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(row).setColumn(column);
        gridPagerSnapHelper.attachToRecyclerView(firstRV);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / column;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(
                new FirstOrderTransform<DataSourceUtils.ItemData>(column), dataList);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        firstRV.setAdapter(adapter);
    }
}
