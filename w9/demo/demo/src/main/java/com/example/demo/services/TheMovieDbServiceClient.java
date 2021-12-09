package com.example.demo.services;

import com.example.demo.contract.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TheMovieDbServiceClient {

    private final RestTemplate rest;
    @Value("${themoviesdb.api.key}") String apiKey;

    @Cacheable(value = "TheMovieDb", key = "#id")
    public MovieDto getMovie(int id){

        var movie = rest.getForEntity("https://api.themoviedb.org/3/movie/" +
                id +
                "?api_key=" + apiKey, MovieDto.class).getBody();
        return movie;
    }

}
