package com.appuas0839.app.api

import com.appuas0839.app.data.model.DetailUserResponse
import com.appuas0839.app.data.model.User
import com.appuas0839.app.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token cc16fbfc96ffb18cf4b9e01e4192c75cca253fda")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token cc16fbfc96ffb18cf4b9e01e4192c75cca253fda")
    fun getUserDetail(
        @Path("username") username : String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token cc16fbfc96ffb18cf4b9e01e4192c75cca253fda")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token cc16fbfc96ffb18cf4b9e01e4192c75cca253fda")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>

}