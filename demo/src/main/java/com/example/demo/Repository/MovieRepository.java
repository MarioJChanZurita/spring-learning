package com.example.demo.Repository;

import com.example.demo.Entities.Movie;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
    
}
