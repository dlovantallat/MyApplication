package com.example.android.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabLayout tabs = findViewById(R.id.tabs);
        CustomViewPager pager = findViewById(R.id.viewPager);
        ThePagerAdapter adapter = new ThePagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new ProfileFragment(), "Profile");

        //if the number is 1 for some animation view
        //if we use 0 the animation is gone
        pager.setOffscreenPageLimit(0);
        pager.setAdapter(adapter);

        tabs.setupWithViewPager(pager);

        pager.setOnPageChangeListener(new CustomViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabs.setScrollPosition(position, 0f, true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
