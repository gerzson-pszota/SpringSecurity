package com.greenfoxrepository.springadvanced.Controllers;

import com.greenfoxrepository.springadvanced.Models.Post;
import com.greenfoxrepository.springadvanced.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/retrofit")
public class MainRestController {
    private final PostService postService;

    @Autowired
    public MainRestController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> fetchPostsAndSaveToDatabase() {
        List<Post> posts = postService.fetchPosts();

        for (Post post : posts) {
            postService.savePost(post);
        }

        return posts;
    }

    @GetMapping("/posts/{id}")
    public Post fetchPostAndSaveToDatabase(@PathVariable("id") int id) {
        Post post = postService.fetchPostsById(id);

        if (post != null) {
            postService.savePost(post);
        }

        return post;
    }
}
