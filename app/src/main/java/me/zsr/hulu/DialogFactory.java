package me.zsr.hulu;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import me.zsr.rsscommon.StringUtil;
import me.zsr.viewmodel.ModelProxy;

public class DialogFactory {

    public static void showCreateLocalAccountDialog(Context context) {
        new MaterialDialog.Builder(context)
                .title(R.string.add_subscription)
                .input(R.string.add_subscription_hint, R.string.none, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(MaterialDialog dialog, CharSequence input) {
                        String url = input.toString();
                        if (!StringUtil.isNullOrEmpty(url)) {
                            if (url.startsWith("http")) {

                            } else if (url.startsWith("www")) {
                                url = "http://" + url;
                            } else {
                                url = "http://www." + url;
                            }
                            ModelProxy.addSubscriptionByUrl(url);
                        }
                    }
                }).show();
    }
}
