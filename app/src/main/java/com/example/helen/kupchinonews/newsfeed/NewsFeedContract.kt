package com.example.helen.kupchinonews.newsfeed

import com.example.helen.kupchinonews.mvp.BasePresenter
import com.example.helen.kupchinonews.mvp.BaseView
import java.util.*

class NewsFeedContract {

    interface View : BaseView<Presenter> {

        fun showLoadingIndicator()

        fun showErrorPanel(errorResID: Int)

        fun showErrorToast(errorResID: Int)

        fun showNewsFeed(newsFeed: ArrayList<NewsItem>? = null)

        fun showRefreshIndicator()

        fun toggleExpandableContent(positionInAdapter: Int)

        fun showNewsItemMenu(positionInAdapter: Int)

        fun dismissNewsItemMenu()

    }

    interface Presenter : BasePresenter {

        fun fetchNewsFeed()

        fun processNewsFeed(newsFeed: ArrayList<NewsItem>): ArrayList<NewsItem>

        fun isLoadingActive(): Boolean

        fun isContentsPresent(): Boolean

        fun setLoading(isLoadingActive: Boolean)

        fun retryFetching()

    }

}