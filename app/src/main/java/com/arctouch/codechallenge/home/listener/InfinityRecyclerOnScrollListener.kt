package com.arctouch.codechallenge.home.listener

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class InfinityRecyclerOnScrollListener : RecyclerView.OnScrollListener() {

    private var isLoading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        val totalItemCount = recyclerView.layoutManager?.itemCount
        val firstVisibleItem =
            (recyclerView.layoutManager as LinearLayoutManager?)?.findFirstVisibleItemPosition()

        firstVisibleItem?.let {
            totalItemCount?.let {

                if (visibleItemCount + firstVisibleItem >= totalItemCount && firstVisibleItem >= 0) {
                    onLoadMore()
                    isLoading = true
                }
            }
        }
    }

    abstract fun onLoadMore()
}