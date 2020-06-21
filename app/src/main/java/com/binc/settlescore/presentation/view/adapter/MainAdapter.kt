package com.binc.settlescore.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binc.settlescore.presentation.model.UserInfoItem
import com.binc.settlescore.presentation.view.viewholder.UserViewHolder
import javax.inject.Inject

class MainAdapter @Inject constructor(): RecyclerView.Adapter<UserViewHolder>(), UserViewHolder.UserItemAdapter {
    var userItemList = listOf<UserInfoItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater, parent, this)
    }

    override fun getItemCount(): Int {
        return userItemList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: UserInfoItem = userItemList[position]
        holder.bind(user, position)
    }

    override fun setItemSelected(value: Boolean, pos: Int) {
        userItemList[pos].checked = value
    }
}