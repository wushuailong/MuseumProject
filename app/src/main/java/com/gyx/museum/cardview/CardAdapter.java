package com.gyx.museum.cardview;


import android.support.v7.widget.CardView;

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 14;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
