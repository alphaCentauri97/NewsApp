package com.example.retrofitpractice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.retrofitpractice2.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager2 viewPager;
    String[] titles = {"Home","Sports","Health","Science","Entertainment","Technology"};
    String api = "ef6ff7ca71494d9eb9bc092d61167a10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tab);

        viewPager.setAdapter(new FragmentAdapter(this));
        new TabLayoutMediator(tabLayout,viewPager,((tab, position) ->tab.setText(titles[position]) )).attach();

    }
}