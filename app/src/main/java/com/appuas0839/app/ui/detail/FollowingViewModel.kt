package com.appuas0839.app.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appuas0839.app.api.RetrofitClient
import com.appuas0839.app.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingViewModel : ViewModel() {
    val listFollowing = MutableLiveData<ArrayList<User>>()

    fun setListFollowing(username: String) {
        RetrofitClient.appInstance
                .getFollowing(username)
                .enqueue(object : Callback<ArrayList<User>> {
                    override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                        if (response.isSuccessful) {
                            listFollowing.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                        Log.d("Failure", t.message.toString())
                    }

                })
    }

    fun getListFollowing(): LiveData<ArrayList<User>> {
        return listFollowing
    }
}