package com.greenfoxrepository.springadvanced;

import com.greenfoxrepository.springadvanced.Controllers.MainRestController;
import com.greenfoxrepository.springadvanced.Models.Post;
import com.greenfoxrepository.springadvanced.Services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MainRestControllerTests {

    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @InjectMocks
    private MainRestController mainRestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(mainRestController).build();
    }

    @Test
    public void testFetchPostsAndSaveToDatabase() throws Exception {
        List<Post> posts = Arrays.asList(
                new Post(1L, 1L, "Title 1", "Content 1"),
                new Post(2L, 2L, "Title 2", "Content 2")
        );

        when(postService.fetchPosts()).thenReturn(posts);

        mockMvc.perform(get("/v1/retrofit/posts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("Title 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].title").value("Title 2"));

        verify(postService, times(2)).savePost(any(Post.class));
    }

    @Test
    public void testFetchPostAndSaveToDatabase() throws Exception {
        Long postId = 1L;
        Post post = new Post(postId, 1L, "Title 1", "Content 1");

        when(postService.fetchPostsById(Math.toIntExact(postId))).thenReturn(post);

        mockMvc.perform(get("/v1/retrofit/posts/{id}", postId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(postId))
                .andExpect(jsonPath("$.title").value("Title 1"));

        verify(postService, times(1)).savePost(any(Post.class));
    }
}
