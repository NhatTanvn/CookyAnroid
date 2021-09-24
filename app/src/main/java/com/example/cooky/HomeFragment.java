package com.example.cooky;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    ViewPager viewPager_home;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     View view =inflater.inflate(R.layout.fragment_home, container, false);

        Log.d("home","onCreate");
     load(view);
        return view;
    }
private void load(View view){
    viewPager_home =view.findViewById(R.id.viewPager_home);
    tabLayout=view.findViewById(R.id.tabLayout_home);

    TabAdapter adapter = new TabAdapter(view.getContext(),getFragmentManager(),5);
    viewPager_home.setAdapter(adapter);

    viewPager_home.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int i = tab.getPosition();
            viewPager_home.setCurrentItem(i);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    });
}
    @Override
    public void onResume() {
        super.onResume();
    }

    class TabAdapter extends FragmentPagerAdapter {
        private int ntabs;
        private Context context;

        public TabAdapter(Context context, FragmentManager fm, int ntabs) {
            super(fm);
            this.context=context;
            this.ntabs=ntabs;
        }


        @NonNull
        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i){
                case 0:
                    fragment= new CookyFragment();
                    break;
                case 1:
                    fragment= new MarketFragment();
                    break;
                case 2:
                    fragment= new FoodFragment();
                    break;
                case 3:
                    fragment= new ChanelFragment();
                    break;
                case 4:
                    fragment= new EventFragment();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return ntabs;
        }

    }
}
