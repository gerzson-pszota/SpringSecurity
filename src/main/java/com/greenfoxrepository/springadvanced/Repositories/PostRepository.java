package com.greenfoxrepository.springadvanced.Repositories;

import com.greenfoxrepository.springadvanced.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
