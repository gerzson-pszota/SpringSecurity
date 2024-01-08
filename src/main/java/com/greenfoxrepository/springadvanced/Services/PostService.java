package com.greenfoxrepository.springadvanced.Services;

import com.greenfoxrepository.springadvanced.Models.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<Post> fetchPosts();
    public Post fetchPostsById(int id);
    Post savePost(Post post);
}
