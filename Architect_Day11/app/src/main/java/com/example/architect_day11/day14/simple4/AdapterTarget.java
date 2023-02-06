package com.example.architect_day11.day14.simple4;

import android.view.View;
import android.view.ViewGroup;

public interface AdapterTarget {

    int getCount();

    View getView(int position, ViewGroup parent);
}
