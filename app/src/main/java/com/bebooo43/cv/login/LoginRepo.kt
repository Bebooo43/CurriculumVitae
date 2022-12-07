package com.bebooo43.cv.login

import android.content.Context
import com.bebooo43.cv.login.model.User
import com.google.gson.Gson

private const val userPref= "USER_PREF"
private const val lastUser= "USER"

class LoginRepo(private val context: Context) {

    private val pref = context.getSharedPreferences(userPref, Context.MODE_PRIVATE)

    fun login(loginUser: User): User? =
        pref.getString(lastUser, "")?.let {
            Gson().fromJson(it, User::class.java)?.let { savedUser ->
                if (savedUser == loginUser)
                    savedUser
                else
                    null
            }
        }

    fun register (user: User){
        pref.edit()?.also {
            it.putString(lastUser, Gson().toJson(user))
        }?.apply()
    }


}