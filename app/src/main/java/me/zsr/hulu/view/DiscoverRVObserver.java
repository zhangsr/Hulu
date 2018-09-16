package me.zsr.hulu.view;

import android.view.View;

import java.util.List;

import me.zsr.rssbean.Discover;

public interface DiscoverRVObserver extends  RecycleViewObserver<Discover>{
    void onAddButtonClick(View view, List<Discover> dataList, int pos);
}
