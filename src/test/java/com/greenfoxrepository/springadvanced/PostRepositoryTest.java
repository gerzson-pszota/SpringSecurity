
package com.greenfoxrepository.springadvanced;

import com.greenfoxrepository.springadvanced.Models.Post;
import com.greenfoxrepository.springadvanced.Repositories.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testSaveAndFindAll() {
        // Given
        Post post1 = new Post(1L, 1L, "Title 1", "Content 1");
        Post post2 = new Post(2L, 2L, "Title 2", "Content 2");

        // When
        postRepository.save(post1);
        postRepository.save(post2);

        // Then
        List<Post> allPosts = postRepository.findAll();
        assertThat(allPosts).isNotEmpty();
        assertThat(allPosts).hasSize(2);
    }

    @Test
    public void testFindById() {
        // Given
        Post post = new Post(1L, 1L, "Title 1", "Content 1");
        postRepository.save(post);

        // When
        Post foundPost = postRepository.findById(1L).orElse(null);

        // Then
        assertThat(foundPost).isNotNull();
        assertThat(foundPost.getId()).isEqualTo(1L);
    }
}

