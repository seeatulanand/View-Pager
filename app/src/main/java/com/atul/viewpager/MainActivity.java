package com.atul.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    AutoScrollViewPager viewPager;
    Integer[] imageId = {R.drawable.ic_baseline_battery_charging_full_24, R.drawable.ic_outline_battery_alert_24, R.drawable.ic_baseline_battery_full_24, R.drawable.ic_outline_battery_alert_24};
    String[] imagesName = {"image1","image2","image3","image4"};
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=findViewById(R.id.text);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        Dialog dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pager_layout);
        viewPager = (AutoScrollViewPager) dialog.findViewById(R.id.viewpager);
        viewPager.startAutoScroll();
        viewPager.setInterval(3000);
        viewPager.setCycle(true);
        viewPager.setStopScrollWhenTouch(true);

        PagerAdapter adapter = new CustomAdapter(MainActivity.this, imageId, imagesName);
        viewPager.setAdapter(adapter);
        dialog.show();
    }
}