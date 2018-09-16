package me.zsr.hulu.view;

import java.util.List;

import me.zsr.rssbean.Article;

public interface ArticleListViewCallback {
    void onArticleClick(List<Article> articleList, int pos);
}
