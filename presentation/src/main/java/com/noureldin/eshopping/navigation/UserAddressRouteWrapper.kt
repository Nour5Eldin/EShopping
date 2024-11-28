package com.noureldin.eshopping.navigation

import android.os.Parcelable
import com.noureldin.eshopping.model.UserAddress
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserAddressRouteWrapper(
    val userAddress: UserAddress?
) : Parcelable
