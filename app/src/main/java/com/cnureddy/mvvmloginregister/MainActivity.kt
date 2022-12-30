package com.cnureddy.mvvmloginregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cnureddy.mvvmloginregister.databinding.ActivityMainBinding
import com.cnureddy.mvvmloginregister.repository.LoginRepository
import com.cnureddy.mvvmloginregister.viewmodel.LoginViewModel
import com.cnureddy.mvvmloginregister.viewmodel.LoginViewModelFactory
//https://www.youtube.com/watch?v=Cs4VuyZYhC8
//https://github.com/nameisjayant/Android-ViewModel-Factory-Example-In-Kotlin/blob/master/app/src/main/java/com/codingwithjks/fragmentswithviewmodel/ViewModel/UserViewModel.kt

//https://www.howtodoandroid.com/mvvm-retrofit-recyclerview-kotlin/

class MainActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //   val loginRepository = LoginRepository()
        // val loginViewModelFactory = LoginViewModelFactory(loginRepository)
        loginViewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(applicationContext,LoginRepository())
        )[LoginViewModel::class.java]

        //must for xml view responses
        binding.login = loginViewModel
        binding.lifecycleOwner = this

        loginViewModel.responseFromRepo.observe(this, Observer {
            Log.d("hello", it)
            binding.resultTxt.text = it.toString()
        })
    }
}