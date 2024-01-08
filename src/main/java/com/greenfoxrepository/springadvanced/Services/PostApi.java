package com.greenfoxrepository.springadvanced.Services;

import com.greenfoxrepository.springadvanced.Models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface PostApi {

    @GET("/posts")
    Call<List<Post>> fetchPost();

    @GET("/posts/{id}")
    Call<Post> fetchPostById(@Path("id") int id);
}
