package com.greenfoxrepository.springadvanced.Services;

import com.greenfoxrepository.springadvanced.Models.Post;
import com.greenfoxrepository.springadvanced.Repositories.PostRepository;
import com.greenfoxrepository.springadvanced.Util.RetrofitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostServiceImpl implements PostService {

    private Retrofit retrofit;
    private PostApi postApi;
    private PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        retrofit = RetrofitUtil.getRetrofitInstance();
        postApi = retrofit.create(PostApi.class);
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> fetchPosts() {
        List<Post> postResponse = new ArrayList<>();
        Call<List<Post>> fetchPostCall = postApi.fetchPost();
        try {
            Response<List<Post>> response = fetchPostCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                postResponse = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postResponse;
    }

    @Override
    public Post fetchPostsById(int id) {
        Post post = null;
        Call<Post> postCall = postApi.fetchPostById(id);

        try {
            Response<Post> response = postCall.execute();
            if (response.isSuccessful() && response.body() != null) {
                post = response.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
