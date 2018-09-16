package me.zsr.hulu.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import me.zsr.rsscommon.htmltextview.custom.UIHandler;

public class IPage extends FrameLayout implements UIHandler {

    public IPage(@NonNull Context context) {
        super(context);
    }

    @Override
    public boolean handleBackPress() {
        return false;
    }
}
