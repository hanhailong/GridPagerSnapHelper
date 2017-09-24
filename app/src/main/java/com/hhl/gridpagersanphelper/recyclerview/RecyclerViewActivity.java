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
import com.hhl.gridpagersnaphelper.transform.OneRowDataTransform;
import com.hhl.gridpagersnaphelper.transform.ThreeRowDataTransform;
import com.hhl.gridpagersnaphelper.transform.TwoRowDataTransform;
import com.hhl.recyclerviewindicator.CirclePageIndicator;
import com.hhl.recyclerviewindicator.LinePageIndicator;
import com.hhl.recyclerviewindicator.OnPageChangeListener;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        configFirstRecyclerView(1, 4);
        configSecondRecyclerView(2, 4);
        configThridRecyclerView(3, 3);
    }

    private void configThridRecyclerView(int row, int column) {
        RecyclerView thridRV = (RecyclerView) findViewById(R.id.recycler_view_third);
        thridRV.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, row, LinearLayoutManager.HORIZONTAL, false);
        thridRV.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(row).setColumn(column);
        gridPagerSnapHelper.attachToRecyclerView(thridRV);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / column;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(
                new ThreeRowDataTransform<DataSourceUtils.ItemData>(column), dataList);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        thridRV.setAdapter(adapter);

        //indicator
        LinePageIndicator indicator = (LinePageIndicator) findViewById(R.id.third_page_indicator);
        indicator.setRecyclerView(thridRV);
        //Note: pageColumn must be config
        indicator.setPageColumn(column);

        indicator.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void configSecondRecyclerView(int row, int column) {
        RecyclerView secondRV = (RecyclerView) findViewById(R.id.recycler_view_second);
        secondRV.setHasFixedSize(true);

        //setLayoutManager
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, row, LinearLayoutManager.HORIZONTAL, false);
        secondRV.setLayoutManager(gridLayoutManager);

        //attachToRecyclerView
        GridPagerSnapHelper gridPagerSnapHelper = new GridPagerSnapHelper();
        gridPagerSnapHelper.setRow(row).setColumn(column);
        gridPagerSnapHelper.attachToRecyclerView(secondRV);

        int screenWidth = ScreenUtils.getScreenWidth(this);
        int itemWidth = screenWidth / column;

        //getDataSource
        List<DataSourceUtils.ItemData> dataList = DataSourceUtils.getDataSource();
        dataList = GridPagerUtils.transformAndFillEmptyData(
                new TwoRowDataTransform<DataSourceUtils.ItemData>(column), dataList);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        secondRV.setAdapter(adapter);

        //indicator
        LinePageIndicator indicator = (LinePageIndicator) findViewById(R.id.second_page_indicator);
        indicator.setRecyclerView(secondRV);
        //Note: pageColumn must be config
        indicator.setPageColumn(column);

        indicator.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
                new OneRowDataTransform<DataSourceUtils.ItemData>(column), dataList);

        //setAdapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataList, itemWidth);
        firstRV.setAdapter(adapter);

        //indicator
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.first_page_indicator);
        indicator.setRecyclerView(firstRV);
        //Note: pageColumn must be config
        indicator.setPageColumn(column);

        indicator.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
