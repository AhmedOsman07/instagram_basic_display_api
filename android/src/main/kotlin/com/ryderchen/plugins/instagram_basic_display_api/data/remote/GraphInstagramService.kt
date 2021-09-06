package com.ryderchen.plugins.instagram_basic_display_api.data.remote

import com.ryderchen.plugins.instagram_basic_display_api.data.model.LongAccessTokenInfo
import com.ryderchen.plugins.instagram_basic_display_api.data.model.MediasResponse
import com.ryderchen.plugins.instagram_basic_display_api.data.model.UserInfoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GraphInstagramService {

    @GET("access_token")
    suspend fun getLongAccessTokenInfo(
        @Query("grant_type") grantType: String,
        @Query("client_secret") clientSecret: String,
        @Query("access_token") accessToken: String
    ): LongAccessTokenInfo

    @GET("me")
    suspend fun getUserInfo(
        @Query("fields") fields: String,
        @Query("access_token") accessToken: String
    ): UserInfoResponse

    @GET("me/media")
    suspend fun getMedias(
        @Query("fields") fields: String,
        @Query("access_token") accessToken: String
    ): MediasResponse
}