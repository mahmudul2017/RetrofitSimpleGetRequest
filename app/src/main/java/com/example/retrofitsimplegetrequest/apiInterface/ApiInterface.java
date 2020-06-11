package com.example.retrofitsimplegetrequest.apiInterface;

import com.example.retrofitsimplegetrequest.model.UserPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts")
    Call<List<UserPost>> getPosts();
}
