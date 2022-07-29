package com

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.siara.myposts.databinding.RetrofitListIteamBinding
import retrofit2.http.POST

class Retrofits(
    var context: Context, var postList: List<post>?
    ) : RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView =
            RetrofitListIteamBinding.inflate(LayoutInflater.from(context), parent, false)
             return RetrofitViewHolder(bindingView)
    }

        override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
            var currentItem = postList.get(position)

            with(holder.bindingView) {
                tvUserId.text = currentItem.userId
                tvId.text = currentItem.id
                tvTittle.text = currentItem.title
                tvBody.text = currentItem.body
            }

        }

        override fun getItemCount(): Int {
            return postList.size
        }
    }

    class RetrofitViewHolder(var bindingView: RetrofitListIteamBinding) :
        RecyclerView.ViewHolder(bindingView.root) {
}