package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Entities.Movie;
import com.example.demo.Service.MovieService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;


    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    
    @GetMapping("/findAllMovies")
    public List<Movie> findAllMovies(){
        return this.movieService.findAllMovies();
    }

    @GetMapping("/findMovie/{id}")
    public Movie findMovie(@PathVariable String id){
        return this.movieService.findMovie(id);
    }

    @PostMapping("/addMovie")
    public void addMovie(@RequestBody Movie movie){
        this.movieService.addMovie(movie);
    }

    @PutMapping("/updateMovie/{id}")
    public void updateMovie(
        @PathVariable String id,
        @RequestBody Movie movie
    ){
        this.movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable String id){
        this.movieService.deleteMovie(id);
    }

}

