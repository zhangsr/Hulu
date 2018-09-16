package me.zsr.hulu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import me.zsr.hulu.view.ArticleListView;
import me.zsr.hulu.view.ArticleListViewCallback;
import me.zsr.hulu.view.ArticleUtil;
import me.zsr.hulu.R;
import me.zsr.rssbean.Article;
import me.zsr.rsscommon.NumberUtil;

public class ArticleListActivity extends BaseActivity implements ArticleListViewCallback {
    private LinearLayout mRootView;
    private Toolbar mToolbar;
    private ArticleListView mArticleListView;
    private long[] mIdArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);
        mRootView = findViewById(R.id.root);

        initToolbar();
        initContent();
    }

    private void initToolbar() {
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.round_arrow_back_black_24));
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String title = getIntent().getExtras().getString(Constants.KEY_BUNDLE_TITLE);
        mToolbar.setTitle(title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.main_grey_dark));
    }

    private void initContent() {
        mArticleListView = new ArticleListView(this, this);
        mRootView.addView(mArticleListView);

        switch (getIntent().getExtras().getString(Constants.KEY_BUNDLE_TYPE)) {
            case Constants.KEY_BUNDLE_TYPE_SUBSCRIPTION:
                mIdArray = getIntent().getExtras().getLongArray(Constants.KEY_BUNDLE_SUBSCRIPTION_ID);
                mArticleListView.showSubscriptions(NumberUtil.toLongArray(mIdArray));
                break;
            case Constants.KEY_BUNDLE_TYPE_FAV:
                mArticleListView.showFav();
                break;
        }

    }

    @Override
    public void onArticleClick(List<Article> articleList, int pos) {
        Intent intent = new Intent(this, ArticleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putLongArray(Constants.KEY_BUNDLE_ARTICLE_ID, ArticleUtil.getIdArray(articleList));
        bundle.putInt(Constants.KEY_BUNDLE_ARTICLE_INDEX, pos);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
