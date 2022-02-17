package com.isuru.kotlinapp.repository.local

import android.content.Context
import android.content.SharedPreferences
import com.isuru.kotlinapp.R

class SharedPreferencesClient constructor(context: Context) {

    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences_file_key),Context.MODE_PRIVATE)

    private var context:Context = context

    fun getFullName(): String?{
        return sharedPreferences.getString(context.getString(R.string.full_name),"")
    }

    fun setFullName(fullName: String){
        sharedPreferences.edit().putString(context.getString(R.string.full_name),fullName).apply()
    }

}