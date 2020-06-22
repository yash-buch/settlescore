package com.binc.settlescore.presentation.view.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.binc.settlescore.R
import com.binc.settlescore.presentation.model.UserInfoItem

class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup, private var userItemAdapter: UserItemAdapter) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_layout, parent, false)) {

    private var nameTV: TextView? = null
    private var checkBox: CheckBox? = null
    private var pos: Int = -1

    init {
        nameTV = itemView.findViewById(R.id.tv_name)
        checkBox = itemView.findViewById(R.id.cb_check)
        itemView.setOnClickListener {
            checkBox?.isChecked = !checkBox?.isChecked!!
            userItemAdapter.setItemSelected(checkBox?.isChecked!!, pos)
        }
    }

    fun bind(userItem: UserInfoItem, position: Int) {
        nameTV?.text = userItem.user.name
        checkBox?.isChecked = userItem.checked
        pos = position
    }

    interface UserItemAdapter {
        fun setItemSelected(value: Boolean, pos: Int)
    }
}