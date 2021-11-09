package com.ubaya.advweek4.view

import android.view.View
import com.ubaya.advweek4.model.Student

interface ButtonDetailClickListener {
    fun onButtonDetailClick(v: View)
}
interface ButtonNotifClick {
    fun onButtonNotificationClick(v: View,student:Student)
}
interface ButtonEditClick {
    fun onButtonEditClick(v: View)
}

