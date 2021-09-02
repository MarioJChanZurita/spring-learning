package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Movie;
import com.example.demo.Repository.MovieRepository;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService( MovieRepository movieRepository ){
        this.movieRepository = movieRepository;
    }
    
    public List<Movie> findAllMovies(){
        return this.movieRepository.findAll();
    }

    public Movie findMovie(String id){
        return this.movieRepository.findById(id).orElse(null);
    }

    public void addMovie(Movie movie){
        this.movieRepository.save(movie);
    }

    public void updateMovie(Movie updatedMovie, String id){
        Movie movie = this.movieRepository.findById(id).orElse(null);
        movie.setName(updatedMovie.getName());
        movie.setDate(updatedMovie.getDate());
        movie.setStars(updatedMovie.getStars());
        this.movieRepository.save(movie);
    }

    public void deleteMovie(String id){
        this.movieRepository.deleteById(id);
    }

}
