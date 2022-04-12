package com.example.retrofitpractice2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.retrofitpractice2.Fragment.EntertainmentFragment;
import com.example.retrofitpractice2.Fragment.HealthFragment;
import com.example.retrofitpractice2.Fragment.HomeFragment;
import com.example.retrofitpractice2.Fragment.ScienceFragment;
import com.example.retrofitpractice2.Fragment.SportsFragment;
import com.example.retrofitpractice2.Fragment.TechnologyFragment;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();
            case 3:
                return new ScienceFragment();
            case 4:
                return new EntertainmentFragment();
            case 5:
                return new TechnologyFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
