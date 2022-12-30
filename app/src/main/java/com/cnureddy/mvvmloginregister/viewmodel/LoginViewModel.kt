package com.cnureddy.mvvmloginregister.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cnureddy.mvvmloginregister.model.LoginModel
import com.cnureddy.mvvmloginregister.repository.LoginRepository

class LoginViewModel(private val context: Context, private val loginRepository: LoginRepository) :
    ViewModel() {
    var name = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    // private var userMutableLiveData: MutableLiveData<LoginModel> = MutableLiveData<LoginModel>()


    val responseFromRepo: LiveData<String>
        get() = loginRepository.loginStatus


    fun onClick(view: View) {

        val userDetails = LoginModel(name.value, password.value)

        if (userDetails.name == null) {
            Toast.makeText(context, "Please enter a Name ", Toast.LENGTH_LONG).show()

        } else if (userDetails.password == null) {
            Toast.makeText(context, "Please enter a password", Toast.LENGTH_LONG).show()
        } else if (userDetails.name != null && userDetails.password != null) {
            Toast.makeText(
                context,
                "Name is : ${userDetails.name} and password is : ${userDetails.password}",
                Toast.LENGTH_LONG
            ).show()
            loginRepository.loginPage(userDetails.name, userDetails.password)
        }


    }
}