package com.cnureddy.mvvmloginregister.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginRepository {

    private val successMessage = "Login Successfully Completed from Repository"
    var status = MutableLiveData<String>()

    val loginStatus: LiveData<String>
        get() = status

    fun loginPage(name: String?, password: String?) {
        Log.d("userDetails", " name $name : password  $password")
        status.postValue("$successMessage User Name is : $name and Password is : $password")
    }
}