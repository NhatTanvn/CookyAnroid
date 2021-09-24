package com.example.cooky;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class CookyFragment extends Fragment {

    ViewFlipper view_flipper;
    private int [] banners={R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_cooky, container, false);
        view_flipper =view.findViewById(R.id.view_flipper);

        for (int i=0;i<banners.length;i++){
            ImageView img = new ImageView(view.getContext());
            img.setImageResource(banners[i]);
            view_flipper.addView(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);

        }
        view_flipper.setFlipInterval(5000);
        view_flipper.setAutoStart(true);
        return view;
    }
}
