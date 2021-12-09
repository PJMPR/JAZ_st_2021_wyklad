package com.example.demo.controllers;

import com.example.demo.contract.GenreDto;
import com.example.demo.contract.MovieDto;
import com.example.demo.services.TheMovieDbServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("movies-client")
@RequiredArgsConstructor
public class MoviesClientController {

    private final TheMovieDbServiceClient client;

    @GetMapping("{id}")
    public ResponseEntity getMovie(@PathVariable int id){
        var movie = client.getMovie(id);
        return ResponseEntity.ok(movie);
    }

}
