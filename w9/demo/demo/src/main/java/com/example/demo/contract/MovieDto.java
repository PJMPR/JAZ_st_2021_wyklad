package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDto {

    int id;
    @JsonProperty("imdb_id")
    String imdbId;
    @JsonProperty("original_title")
    String originalTitle;
    String overview;
    List<GenreDto> genres;

}
