package com.hhl.gridpagersanphelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hhl.gridpagersanphelper.recyclerview.RecyclerViewActivity;
import com.hhl.gridpagersanphelper.vertical.VerticalRVActivity;
import com.hhl.gridpagersanphelper.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpToRecyclerView(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

    public void jumpToViewPager(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void jumpToVerticalRecyclerView(View view) {
        startActivity(new Intent(this, VerticalRVActivity.class));
    }
}
