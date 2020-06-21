package com.binc.settlescore.presentation.model

import com.binc.settlescore.domain.interactors.UserInfo

data class UserInfoItem (var user: UserInfo, var checked: Boolean)