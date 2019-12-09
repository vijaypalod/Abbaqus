package com.abbaqus.redditfeed;

import android.view.View;

/**
 * Abbaqus
 * Created by Administrator on 22-07-2018.
 */
public interface RecyclerViewClickListener {

    void onClick(int position,View view);

    void onShareClick(int position,View view);
}
