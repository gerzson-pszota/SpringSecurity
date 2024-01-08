package com.greenfoxrepository.springadvanced.Models;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Post {

    @Id
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
