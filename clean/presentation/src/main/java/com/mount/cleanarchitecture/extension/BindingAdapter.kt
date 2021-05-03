package com.mount.cleanarchitecture.extension

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mount.cleanarchitecture.R
import com.mount.cleanarchitecture.base.BindingItem
import com.mount.cleanarchitecture.base.RecyclerViewAdapter

@BindingAdapter("recyclerItems")
fun RecyclerView.setRecyclerViewItems(items : List<BindingItem>?) {
    if(adapter == null) {
        this.adapter  = RecyclerViewAdapter()
        this.layoutManager = LinearLayoutManager(context)
    }
    items?.let { (adapter as RecyclerViewAdapter)?.updateItem(it) }
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url : String?) {
    if(!url.isNullOrBlank()) {
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(this)
    }
}

@BindingAdapter("isBookmark")
fun ImageView.setBookmarkTint(isBookmark : Boolean?) {
    val colorYellow: Int = ContextCompat.getColor(context, R.color.yellow)
    val colorBlack: Int = ContextCompat.getColor(context, R.color.black)

    isBookmark?.let {
        if(it) this.setColorFilter(colorYellow)
        else this.setColorFilter(colorBlack)
    }
}